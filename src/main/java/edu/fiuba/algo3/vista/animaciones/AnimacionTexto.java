package edu.fiuba.algo3.vista.animaciones;

import edu.fiuba.algo3.vista.etiquetas.Etiqueta;
import javafx.animation.AnimationTimer;
import javafx.scene.media.AudioClip;

public class AnimacionTexto extends AnimationTimer {

    private String textoOriginal;
    private int indiceActual;
    private Etiqueta etiqueta;
    private AudioClip audioClip;

    public AnimacionTexto(String texto) {
        this(texto, 14, true);
    }

    public AnimacionTexto(String texto, int tamanio) {
        this(texto, tamanio, true);
    }

    public AnimacionTexto(String texto, int tamanio, boolean auto_start) {
        this.textoOriginal = texto;
        this.indiceActual = 0;
        this.etiqueta = new Etiqueta(this.textoOriginal, tamanio);
        this.audioClip = new AudioClip("file:media/sfx/apretarTecla.mp3");
        this.audioClip.setRate(4.5);
        this.audioClip.setCycleCount(AudioClip.INDEFINITE);
        if (auto_start) {
            this.empezar();
        }
    }

    private boolean terminoAnimacion() {
        return this.indiceActual > this.textoOriginal.length();
    }

    public void empezar() {
        this.start();
        this.audioClip.play();
    }

    public void terminar() {
        this.stop();
        this.audioClip.stop();
    }

    public void reiniciar(String nuevoMensaje) {
        this.terminar();
        this.textoOriginal = nuevoMensaje;
        this.indiceActual = 0;
        this.etiqueta.setText(this.textoOriginal);
        this.empezar();
    }

    @Override
    public void handle(long now) {
        if (this.terminoAnimacion()) {
            this.stop();
            this.audioClip.stop();
            return;
        }
        String textoAMostrar = this.textoOriginal.substring(0, this.indiceActual);
        this.etiqueta.setText(textoAMostrar);
        this.indiceActual++;
    }

    public Etiqueta getEtiqueta() {
        return this.etiqueta;
    }
}

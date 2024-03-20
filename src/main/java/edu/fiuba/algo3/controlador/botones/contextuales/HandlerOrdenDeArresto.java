package edu.fiuba.algo3.controlador.botones.contextuales;

import edu.fiuba.algo3.modelo.EstadoJuego;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.computadora.ordenesDeArresto.OrdenDeArresto;
import edu.fiuba.algo3.vista.cajas.CajaLugarYFecha;
import edu.fiuba.algo3.vista.contenedores.CuadroDialogo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class HandlerOrdenDeArresto implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionevent){
        OrdenDeArresto ordenDeArresto = Juego.obtenerInstancia().emitirOrdenDeArresto();
        CajaLugarYFecha.obtenerInstancia().mostrarLugarYTiempo();
        if(Juego.obtenerInstancia().estadoMision() == EstadoJuego.EN_CURSO) {
            CuadroDialogo.obtenerInstancia().mostrarEstadoOrdenDeArresto(ordenDeArresto);
        }
        AudioClip audioClip = new AudioClip("file:media/sfx/botonEmitirOrden.mp3");
        audioClip.play(0.5);
    }
}
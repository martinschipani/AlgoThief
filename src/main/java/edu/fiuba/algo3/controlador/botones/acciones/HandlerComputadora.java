package edu.fiuba.algo3.controlador.botones.acciones;

import edu.fiuba.algo3.vista.contenedores.CuadroDialogo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

public class HandlerComputadora implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        CuadroDialogo.obtenerInstancia().mostrarComputadora();
        AudioClip audioClip = new AudioClip("file:media/sfx/botonComputadora.mp3");
        audioClip.play();
    }
}

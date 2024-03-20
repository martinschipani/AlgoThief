package edu.fiuba.algo3.controlador.caracteristicas;

import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public abstract class HandlerCambiarCaracteristica implements EventHandler<ActionEvent> {
    protected Caracteristica caracteristica;
    protected ArrayList<String> valoresPosibles;

    HandlerCambiarCaracteristica(Caracteristica caracteristica){
        this.caracteristica = caracteristica;
        valoresPosibles = new ArrayList<String>();
        this.valoresPosibles.add("");
    }
}

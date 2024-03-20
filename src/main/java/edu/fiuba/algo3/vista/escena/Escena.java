package edu.fiuba.algo3.vista.escena;

import edu.fiuba.algo3.vista.cajas.CajaGeneral;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Escena extends Scene {

    public Escena() {
        super(new StackPane(new CajaGeneral()));
    }
}
package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.vista.botones.contextuales.BotonElegirEdificio;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BotonesEdificio extends VBox {
    public BotonesEdificio(ArrayList<Edificio> edificios) {
        super(5);
        for (Edificio edificio : edificios) {
            this.getChildren().add(new BotonElegirEdificio(edificio));
        }
        this.setAlignment(Pos.TOP_LEFT);
    }
}

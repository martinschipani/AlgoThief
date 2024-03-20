package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.vista.botones.contextuales.BotonElegirCiudad;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BotonesViajes extends VBox {

    public BotonesViajes(ArrayList<Ciudad> ciudades) {
        super(10);
        for (Ciudad ciudad : ciudades) {
            this.getChildren().add(new BotonElegirCiudad(ciudad));
        }
        this.setAlignment(Pos.TOP_LEFT);
    }
}
package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.vista.botones.contextuales.BotonEmitirOrdenDeArresto;
import edu.fiuba.algo3.vista.cajas.CajaCargarCaracteristica;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MenuEmitirOrdenDeArresto extends VBox {
    public MenuEmitirOrdenDeArresto(Computadora computadora) {
        super(15);
        ArrayList<Caracteristica> caracteristicas = computadora.caracteristicasGuardadas();
        for (Caracteristica caracteristica : caracteristicas) {
            this.getChildren().add(new CajaCargarCaracteristica(caracteristica));
        }
        this.getChildren().add(new BotonEmitirOrdenDeArresto());
        this.setAlignment(Pos.BOTTOM_CENTER);
    }
}

package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.vista.botones.contextuales.BotonElegirCaracteristica;
import edu.fiuba.algo3.vista.etiquetas.Etiqueta;
import javafx.scene.layout.HBox;

public class CajaCargarCaracteristica extends HBox {
    public CajaCargarCaracteristica(Caracteristica caracteristica){
        super(5);
        this.getChildren().setAll(new Etiqueta(caracteristica.obtenerNombreTipo() + ":"), new BotonElegirCaracteristica(caracteristica));
    }
}

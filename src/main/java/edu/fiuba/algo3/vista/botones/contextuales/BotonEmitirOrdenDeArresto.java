package edu.fiuba.algo3.vista.botones.contextuales;

import edu.fiuba.algo3.controlador.botones.contextuales.HandlerOrdenDeArresto;
import edu.fiuba.algo3.vista.botones.BotonNegro;
import edu.fiuba.algo3.vista.imagenes.botones.ImagenEmitirOrden;

public class BotonEmitirOrdenDeArresto extends BotonNegro {
    public BotonEmitirOrdenDeArresto() {
        super();
        this.setOnAction(new HandlerOrdenDeArresto());
        this.setGraphic(new ImagenEmitirOrden());
    }
}

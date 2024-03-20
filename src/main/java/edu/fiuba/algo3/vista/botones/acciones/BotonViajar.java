package edu.fiuba.algo3.vista.botones.acciones;

import edu.fiuba.algo3.controlador.botones.acciones.HandlerViajar;
import edu.fiuba.algo3.vista.botones.BotonBlancoTransparente;
import edu.fiuba.algo3.vista.imagenes.botones.ImagenViajar;

public class BotonViajar extends BotonBlancoTransparente {

    public BotonViajar() {
        super();
        this.setOnAction(new HandlerViajar());
        this.setGraphic(new ImagenViajar());
    }
}

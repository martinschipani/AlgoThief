package edu.fiuba.algo3.vista.botones.acciones;

import edu.fiuba.algo3.controlador.botones.acciones.HandlerComputadora;
import edu.fiuba.algo3.vista.botones.BotonBlancoTransparente;
import edu.fiuba.algo3.vista.imagenes.botones.ImagenComputadora;

public class BotonComputadora extends BotonBlancoTransparente {

    public BotonComputadora() {
        super();
        this.setOnAction(new HandlerComputadora());
        this.setGraphic(new ImagenComputadora());
    }
}

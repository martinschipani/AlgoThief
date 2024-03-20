package edu.fiuba.algo3.vista.botones.acciones;

import edu.fiuba.algo3.controlador.botones.acciones.HandlerVer;
import edu.fiuba.algo3.vista.botones.BotonBlancoTransparente;
import edu.fiuba.algo3.vista.imagenes.botones.ImagenVer;

public class BotonVer extends BotonBlancoTransparente {

    public BotonVer() {
        super();
        this.setOnAction(new HandlerVer());
        this.setGraphic(new ImagenVer());
    }
}

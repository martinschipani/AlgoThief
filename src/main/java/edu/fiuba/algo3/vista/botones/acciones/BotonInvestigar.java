package edu.fiuba.algo3.vista.botones.acciones;

import edu.fiuba.algo3.controlador.botones.acciones.HandlerInvestigar;
import edu.fiuba.algo3.vista.botones.BotonBlancoTransparente;
import edu.fiuba.algo3.vista.imagenes.botones.ImagenInvestigar;

public class BotonInvestigar extends BotonBlancoTransparente {

    public BotonInvestigar() {
        super();
        this.setOnAction(new HandlerInvestigar());
        this.setGraphic(new ImagenInvestigar());
    }
}

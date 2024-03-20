package edu.fiuba.algo3.vista.botones.contextuales;

import edu.fiuba.algo3.controlador.botones.contextuales.HandlerContinuar;
import edu.fiuba.algo3.vista.botones.BotonBlanco;

public class BotonContinuar extends BotonBlanco {
    public BotonContinuar(){
        super("Continuar");
        this.setOnAction(new HandlerContinuar());
    }
}

package edu.fiuba.algo3.vista.botones.contextuales;

import edu.fiuba.algo3.controlador.botones.contextuales.HandlerComenzarMision;
import edu.fiuba.algo3.vista.botones.BotonBlanco;

public class BotonComenzarMision extends BotonBlanco {
    public BotonComenzarMision(){
        super("Comenzar nueva mision");
        this.setOnAction(new HandlerComenzarMision());
    }
}

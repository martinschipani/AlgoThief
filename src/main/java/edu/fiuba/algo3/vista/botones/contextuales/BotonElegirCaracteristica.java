package edu.fiuba.algo3.vista.botones.contextuales;

import edu.fiuba.algo3.controlador.caracteristicas.CreadorHandlerCaracteristica;
import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.vista.botones.BotonBlanco;

public class BotonElegirCaracteristica extends BotonBlanco {
    public BotonElegirCaracteristica(Caracteristica caracteristica){
        super(caracteristica.obtenerValor());
        this.setOnAction(CreadorHandlerCaracteristica.obtenerInstancia().crearHandler(caracteristica));
    }
}

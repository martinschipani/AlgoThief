package edu.fiuba.algo3.vista.botones.contextuales;

import edu.fiuba.algo3.controlador.botones.contextuales.HandlerElegirCiudad;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.vista.botones.BotonNegro;

public class BotonElegirCiudad extends BotonNegro {
    public BotonElegirCiudad(Ciudad ciudad) {
        super("-\t" + ciudad.obtenerNombre());
        this.setOnAction(new HandlerElegirCiudad(ciudad));
    }
}

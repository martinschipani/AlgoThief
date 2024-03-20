package edu.fiuba.algo3.vista.botones.contextuales;

import edu.fiuba.algo3.controlador.botones.contextuales.HandlerElegirEdificio;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.vista.botones.BotonNegro;

public class BotonElegirEdificio extends BotonNegro {
    public BotonElegirEdificio(Edificio edificio) {
        super("-\t" + edificio.obtenerNombre());
        this.setOnAction(new HandlerElegirEdificio(edificio));
    }
}

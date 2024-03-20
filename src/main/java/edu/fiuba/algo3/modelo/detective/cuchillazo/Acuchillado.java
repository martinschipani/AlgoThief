package edu.fiuba.algo3.modelo.detective.cuchillazo;

import edu.fiuba.algo3.modelo.reloj.Reloj;

public class Acuchillado implements Cuchillazo {
    public Cuchillazo acuchillar(Reloj reloj){
        reloj.avanzarTiempo(1);
        return this;
    }
}

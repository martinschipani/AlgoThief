package edu.fiuba.algo3.modelo.detective.cuchillazo;

import edu.fiuba.algo3.modelo.reloj.Reloj;

public class SinAcuchillar implements Cuchillazo{
    public Cuchillazo acuchillar(Reloj reloj){
        reloj.avanzarTiempo(2);
        return new Acuchillado();
    }
}
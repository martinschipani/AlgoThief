package edu.fiuba.algo3.modelo.computadora.ordenesDeArresto;

import edu.fiuba.algo3.modelo.ladron.Ladron;

public class OrdenInvalida implements OrdenDeArresto {

    public boolean esPara(Ladron ladron) {
        return false;
    }
}

package edu.fiuba.algo3.modelo.pistas;

import java.util.Map;

public class PistasDeCiudad {

    private Map<String, PistasDeEdificio> pistasDeCiudades;

    public PistasDeCiudad(Map<String, PistasDeEdificio> pistasDeCiudades) {
        this.pistasDeCiudades = pistasDeCiudades;
    }

    public String leerPista(String ciudad, String tipoDeEdificio) {
        return pistasDeCiudades.get(ciudad).leerPista(tipoDeEdificio);
    }
}

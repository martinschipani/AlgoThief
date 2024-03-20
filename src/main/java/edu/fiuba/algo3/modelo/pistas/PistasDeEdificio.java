package edu.fiuba.algo3.modelo.pistas;

import java.util.Map;

public class PistasDeEdificio {

    private Map<String, String> pistasDeEdificio;

    public PistasDeEdificio(Map<String, String> pistasDeEdificio) {
        this.pistasDeEdificio = pistasDeEdificio;
    }

    public String leerPista(String tipoDeEdificio) {
        return pistasDeEdificio.get(tipoDeEdificio);
    }
}

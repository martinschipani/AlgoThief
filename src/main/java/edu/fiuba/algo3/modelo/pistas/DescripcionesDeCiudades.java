package edu.fiuba.algo3.modelo.pistas;

import edu.fiuba.algo3.modelo.lectores.LectorDeDescripciones;

import java.util.Map;

public class DescripcionesDeCiudades {

    private static DescripcionesDeCiudades instancia = null;
    private Map<String, String> descripciones;

    private DescripcionesDeCiudades() {
        LectorDeDescripciones lector = new LectorDeDescripciones("src/main/java/edu/fiuba/algo3/config/descripcionCiudades.json");
        descripciones = lector.cargarDescripciones();
    }

    private static void crearDescripciones() {
        if (instancia == null) {
            instancia = new DescripcionesDeCiudades();
        }
    }

    public static DescripcionesDeCiudades obtenerInstancia() {
        if (instancia == null) {
            crearDescripciones();
        }
        return instancia;
    }

    public String leerDescripcion(String nombreCiudad) {
        return descripciones.get(nombreCiudad);
    }
}

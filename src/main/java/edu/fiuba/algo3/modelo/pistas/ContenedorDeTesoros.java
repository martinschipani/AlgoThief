package edu.fiuba.algo3.modelo.pistas;

import edu.fiuba.algo3.modelo.lectores.LectorDeTesoros;

import java.util.Map;

public class ContenedorDeTesoros {

    private static ContenedorDeTesoros instancia = null;
    private Map<String, String> tesoros;

    private ContenedorDeTesoros() {
        LectorDeTesoros lector = new LectorDeTesoros("src/main/java/edu/fiuba/algo3/config/tesoros.json");
        tesoros = lector.cargarTesoros();
    }

    private static void crearContenedorDeTesoros() {
        if (instancia == null) {
            instancia = new ContenedorDeTesoros();
        }
    }

    public static ContenedorDeTesoros obtenerInstancia() {
        if (instancia == null) {
            crearContenedorDeTesoros();
        }
        return instancia;
    }

    public String leerTesoro(String nombreCiudad) {
        return tesoros.get(nombreCiudad);
    }

}
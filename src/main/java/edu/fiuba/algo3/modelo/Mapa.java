package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.detective.Detective;
import edu.fiuba.algo3.modelo.excepciones.RutaInexistente;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.lectores.LectorDeMapa;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Mapa {

    private static Mapa instancia = null;

    private ArrayList<Ciudad> ciudades;
    private Map<String, Map<String, Integer>> distancias;
    private Map<String,ArrayList<String>> adyacencias;

    private Mapa() {
        LectorDeMapa lectorDeMapa = new LectorDeMapa("src/main/java/edu/fiuba/algo3/config/ciudades.json");
        this.distancias = lectorDeMapa.cargarDistancias();
        this.ciudades = lectorDeMapa.cargarCiudades();
        this.adyacencias = lectorDeMapa.cargarAdyacencias();
    }

    private static void crearMapa() {
        if (instancia == null) {
            instancia = new Mapa();
        }
    }

    public static Mapa obtenerInstancia() {
        if (instancia == null) {
            crearMapa();
        }
        return instancia;
    }

    public void realizarViaje(Ciudad origen, Ciudad destino, Detective detective) {
        int distancia = this.calcularDistanciaEntre(origen, destino);
        detective.viajar(distancia);
    }

    public Ciudad crearRutaDelLadron(int longitud, Ladron ladron) {
        for (Ciudad ciudad : ciudades) {
            ciudad.reiniciarCiudad();
        }

        Ciudad ciudadSiguiente = this.obtenerCiudadRandom();
        ciudadSiguiente.establecerRutaDelLadron("Final");
        ciudadSiguiente.asignarLadron(ladron);
        Ciudad ciudadactual = null;

        for (int i = 0; i < longitud; i++) {
            ciudadactual = obtenerCiudadRandom(ciudadSiguiente);
            ciudadactual.establecerRutaDelLadron(ciudadSiguiente.obtenerNombre());
            ciudadSiguiente = ciudadactual;
        }

        return ciudadactual;
    }

    private Ciudad obtenerCiudadRandom(Ciudad ciudadSiguiente) {
        Random random = new Random(System.nanoTime());
        Ciudad ciudadRandom = ciudades.get(random.nextInt(ciudades.size()));

        while (!ciudadRandom.obtenerRutaDelLadron().equals("Default") || !adyacencias.get(ciudadRandom.obtenerNombre()).contains(ciudadSiguiente.obtenerNombre())) {
            ciudadRandom = ciudades.get(random.nextInt(ciudades.size()));
        }
        return ciudadRandom;
    }

    private Ciudad obtenerCiudadRandom() {
        Random random = new Random(System.nanoTime());
        Ciudad ciudadRandom = ciudades.get(random.nextInt(ciudades.size()));

        while (!ciudadRandom.obtenerRutaDelLadron().equals("Default")) {
            ciudadRandom = ciudades.get(random.nextInt(ciudades.size()));
        }
        return ciudadRandom;
    }

    public int calcularDistanciaEntre(Ciudad ciudadOrigen, Ciudad ciudadDestino) throws RutaInexistente {
        if (distancias.get(ciudadOrigen.obtenerNombre()).get(ciudadDestino.obtenerNombre()) == null) {
            throw new RutaInexistente("Ruta inexistente");
        }
        return distancias.get(ciudadOrigen.obtenerNombre()).get(ciudadDestino.obtenerNombre());
    }

    ////// TEST //////
    public Ciudad obtenerCiudad(String nombre) {
        Ciudad ciudadBuscada = null;
        for (Ciudad ciudad : ciudades) {
            if (ciudad.obtenerNombre().equals(nombre)) {
                ciudadBuscada = ciudad;
            }
        }
        return ciudadBuscada;
    }
}

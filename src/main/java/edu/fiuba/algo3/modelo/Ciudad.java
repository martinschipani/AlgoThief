package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.detective.Detective;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.NoLadron;

import java.util.ArrayList;
import java.util.Random;

public class Ciudad {

    private String nombre;
    private ArrayList<Edificio> edificios;
    private ArrayList<Ciudad> ciudadesAdyacentes;
    private String ciudadRecorrido;
    private int contadorVisitas;

    public Ciudad(String nombre){
        this.edificios = new ArrayList<>();
        this.ciudadesAdyacentes = new ArrayList<>();
        this.contadorVisitas = 0;
        this.nombre = nombre;
        this.ciudadRecorrido = "Default";
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public String visitarEdificio(Detective detective, Edificio edificio){
        this.incrementarContador();
        detective.visitarEdificio(edificio, this.contadorVisitas);
        if (this.estaEnLaRutaDelLadron()) {
            return detective.leerPistaConLadron(this.ciudadRecorrido, edificio.obtenerTipo());
        }
        return detective.leerPista(this.ciudadRecorrido, edificio.obtenerTipo());
    }

    public void agregarEdificio(Edificio edificio){
        this.edificios.add(edificio);
    }

    public void agregarRutaDeVuelo(Ciudad ciudad) {
        ciudadesAdyacentes.add(ciudad);
    }

    public void establecerRutaDelLadron(String ciudadSiguiente) {
        this.ciudadRecorrido = ciudadSiguiente;
    }

    public String obtenerRutaDelLadron() {
        return this.ciudadRecorrido;
    }

    public Boolean estaEnLaRutaDelLadron() {
        return !this.ciudadRecorrido.equals("Default");
    }

    public void asignarLadron(Ladron ladron) {
        Random random = new Random(System.nanoTime());
        edificios.get(random.nextInt(edificios.size())).establecerLadron(ladron);
    }

    public void reiniciarCiudad() {
        this.ciudadRecorrido = "Default";
        for (Edificio edificio : edificios) {
            edificio.establecerLadron(new NoLadron());
        }
    }

    public Ciudad realizarViaje(Ciudad destino, Detective detective) {
        Mapa.obtenerInstancia().realizarViaje(this, destino, detective);
        if (destino.estaEnLaRutaDelLadron()) {
            detective.recibirAtaque();
        }
        return destino;
    }

    private String obtenerPista(Detective detective, Edificio edificio){
        if (this.estaEnLaRutaDelLadron()) {
            return detective.leerPistaConLadron(ciudadRecorrido, edificio.obtenerTipo());
        }
        return detective.leerPista(ciudadRecorrido, edificio.obtenerTipo());
    }

    private void incrementarContador(){
        if(this.contadorVisitas < 3){
            this.contadorVisitas++;
        }
    }

    ////// VISTA //////
    public ArrayList<Ciudad> obtenerCiudadesAdyacentes() {
        return ciudadesAdyacentes;
    }

    ////// VISTA //////
    public ArrayList<Edificio> obtenerEdificios() {
        return edificios;
    }

    ////// TEST //////
    public int obtenerVisitas() {
        return this.contadorVisitas;
    }

    ////// TEST //////
    public void asignarSiguiente(Ciudad siguiente){
        this.ciudadRecorrido = siguiente.obtenerNombre();
    }
}

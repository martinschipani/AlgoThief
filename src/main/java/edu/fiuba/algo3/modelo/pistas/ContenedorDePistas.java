package edu.fiuba.algo3.modelo.pistas;

import edu.fiuba.algo3.modelo.excepciones.ContenedorNoExiste;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Sospechoso;
import edu.fiuba.algo3.modelo.lectores.LectorDePistas;

import java.util.Map;

public class ContenedorDePistas {

    private static ContenedorDePistas instancia = null;

    private Map<String, PistasDeCiudad> pistas;
    private CalculadorPistaLadron calculadorPistaLadron;

    private ContenedorDePistas() {
        this.calculadorPistaLadron = new CalculadorPistaLadron();
        LectorDePistas lector = new LectorDePistas("src/main/java/edu/fiuba/algo3/config/pistas.json");
        this.pistas = lector.cargarPistas();
    }

    public static ContenedorDePistas obtenerInstancia() throws ContenedorNoExiste {
        if (instancia == null) {
            instancia = new ContenedorDePistas();
        }
        return instancia;
    }

    public String leerPista(String dificultad, String ciudad, String tipoDeEdificio) {
        String pistaEdificio = pistas.get(dificultad).leerPista(ciudad, tipoDeEdificio);
        return pistaEdificio;
    }

    public String leerPistaConLadron(String dificultad, String ciudad, String tipoDeEdificio) {
        String pistaEdificio =  pistas.get(dificultad).leerPista(ciudad, tipoDeEdificio);
        return pistaEdificio + this.calculadorPistaLadron.calcularPistaLadron();
    }

    public void cargarPistasLadron(Ladron ladron) {
        this.calculadorPistaLadron.cargarAtributos(ladron);
    }

    ////// TEST //////
    public static ContenedorDePistas obtenerInstanciaTEST() throws ContenedorNoExiste {
        if (instancia == null) {
            LectorDePistas lector = new LectorDePistas("src/main/java/edu/fiuba/algo3/config/pistas.json");
            lector.cargarPistas();

            Ladron ladron= new Sospechoso();
            instancia.calculadorPistaLadron.cargarAtributos(ladron);
        }
        return instancia;
    }

}

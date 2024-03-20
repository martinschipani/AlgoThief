package edu.fiuba.algo3.modelo.pistas;

import edu.fiuba.algo3.modelo.excepciones.TipoDeCaracteristicaInexistente;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.modelo.lectores.LectorDePistasLadron;

import java.util.*;

public class CalculadorPistaLadron {

    private ArrayList<AbstractMap.SimpleEntry<Caracteristica, Boolean>> atributosLadron;
    private Random random;
    private double probabilidadPistaLadron;
    private Map<String, String> pistasLadron;

    CalculadorPistaLadron() {
        this.random = new Random(System.nanoTime());
        this.probabilidadPistaLadron = 0.30;
        LectorDePistasLadron lector = new LectorDePistasLadron("src/main/java/edu/fiuba/algo3/config/pistasLadron.json");
        this.pistasLadron = lector.cargarPistasLadron();
    }

    public String calcularPistaLadron () throws TipoDeCaracteristicaInexistente {

        if (random.nextFloat() >= probabilidadPistaLadron) {

            return "";
        }

        if (atributosLadron.stream().filter(element -> !(element.getValue())).count() == 0) {
            atributosLadron.stream().forEach(element -> element.setValue(false));
        }

        AbstractMap.SimpleEntry atributoEntry = atributosLadron.stream().filter(element -> !(element.getValue())).findFirst().get();
        atributoEntry.setValue(true);
        Caracteristica atributo = (Caracteristica) atributoEntry.getKey();

        if (pistasLadron.get(atributo.obtenerNombreTipo()) != null) {
            return pistasLadron.get(atributo.obtenerNombreTipo()) + atributo.obtenerValor() + ".";
        }
        throw new TipoDeCaracteristicaInexistente("El ladron tiene una caracteristica invalida");
    }

    public void cargarAtributos(Ladron ladron) {
        this.atributosLadron = new ArrayList<>();

        this.atributosLadron.add(new AbstractMap.SimpleEntry(ladron.obtenerSexo(), false));
        this.atributosLadron.add(new AbstractMap.SimpleEntry(ladron.obtenerHobby(), false));
        this.atributosLadron.add(new AbstractMap.SimpleEntry(ladron.obtenerCabello(), false));
        this.atributosLadron.add(new AbstractMap.SimpleEntry(ladron.obtenerSenia(), false));
        this.atributosLadron.add(new AbstractMap.SimpleEntry(ladron.obtenerVehiculo(), false));

        Collections.shuffle(this.atributosLadron);
    }
}

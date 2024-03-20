package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.detective.Detective;
import edu.fiuba.algo3.modelo.detective.DetectiveNovato;
import edu.fiuba.algo3.modelo.ladron.Sospechoso;
import edu.fiuba.algo3.modelo.pistas.ContenedorDePistas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CiudadTest {

    @Test
    public void test01ElContadorDeVisitasNoPasaDeTres() {
        ContenedorDePistas.obtenerInstancia().cargarPistasLadron(new Sospechoso());
        Detective detective = new DetectiveNovato();
        Ciudad buenosAires = new Ciudad("Buenos Aires");
        Ciudad ciudadRecorridoFake = new Ciudad("Montreal");
        buenosAires.asignarSiguiente(ciudadRecorridoFake);

        Edificio biblioteca = new Edificio("Biblioteca", "Biblioteca");
        buenosAires.agregarEdificio((biblioteca));
        for (int i = 0; i < 10; i++) {
            buenosAires.visitarEdificio(detective, biblioteca);
        }
        assertEquals(3, buenosAires.obtenerVisitas());
    }
}

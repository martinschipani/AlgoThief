package edu.fiuba.algo3.modelo.excepciones;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RutaInexistenteTest {

    @Test
    public void calcularDistanciaEntreDosCiudadesInconexasLanzaExcepcion(){
        Ciudad buenosAires = new Ciudad("Buenos Aires");
        Ciudad estambul = new Ciudad("Estambul");
        assertThrows(RutaInexistente.class,
                ()->{
                    Mapa.obtenerInstancia().calcularDistanciaEntre(buenosAires, estambul);
                });
    }
}

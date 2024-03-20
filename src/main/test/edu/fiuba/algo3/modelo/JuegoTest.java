package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.reloj.Fecha;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JuegoTest {

    @Test
    public void test01ViajarDeMexicoARioDeJaneiroYSeActualizaLaCiudadCorrectamente(){
        Juego.obtenerInstancia().resetear();
        Ciudad mexico = Mapa.obtenerInstancia().obtenerCiudad("Mexico");
        Ciudad montreal = Mapa.obtenerInstancia().obtenerCiudad("Montreal");
        montreal.establecerRutaDelLadron("Default");
        Juego.obtenerInstancia().establecerCiudadActual(mexico);
        Juego.obtenerInstancia().viajar(montreal);
        assertSame(Juego.obtenerInstancia().ciudadActual(), montreal);
    }

    @Test
    public void test02ViajarDeMexicoARioDeJaneiroYElTiempoPasaCorrectamente(){
        Juego.obtenerInstancia().resetear();
        Ciudad montreal = Mapa.obtenerInstancia().obtenerCiudad("Montreal");
        Ciudad roma = Mapa.obtenerInstancia().obtenerCiudad("Roma");
        roma.establecerRutaDelLadron("Default");
        Juego.obtenerInstancia().establecerCiudadActual(montreal);
        Fecha fecha = new Fecha (4,  14);
        Juego.obtenerInstancia().viajar(roma);
        assertTrue(Juego.obtenerInstancia().obtenerDetective().obtenerFecha().esIgualA(fecha));
    }


}
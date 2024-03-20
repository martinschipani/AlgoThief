package edu.fiuba.algo3.modelo.excepciones;

import edu.fiuba.algo3.modelo.reloj.Reloj;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorasInvalidasTest {

    @Test
    public void avanzarTiempoConHorasNegativasLanzaExcepcion(){
        Reloj reloj = new Reloj();
        assertThrows(HorasInvalidas.class,
                ()->{
                    reloj.avanzarTiempo(-1);
                });
    }
}

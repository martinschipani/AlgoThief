package edu.fiuba.algo3.modelo.reloj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RelojTest {

    @Test
    public void test01RelojAvanzaSeisHorasYNoPasaDeLaFechaLimite() {
        Reloj reloj = new RelojFake();

        reloj.avanzarTiempo(6);
        assertTrue(reloj.verificarFechaLimite());
    }

    @Test
    public void test02Agregar8DiasSePasaDeLaFechaLimite() {
        Reloj reloj = new RelojFake();

        reloj.avanzarTiempo(192); // 8 (dias) x 24 (horas) = 192

        assertFalse(reloj.verificarFechaLimite());
    }

    @Test
    public void test03AlPasarDeLasOnceSeAgreganOchoHorasSiempre() {
        Reloj reloj1 = new RelojFake();
        Reloj reloj2 = new RelojFake();
        Reloj reloj3 = new RelojFake();
        Fecha unDiaDespues = new Fecha(5, 15);
        Fecha diezDiasDespues = new Fecha(14, 15);
//        Fecha unMesDespues = new Fecha(31, 15);

        reloj1.avanzarTiempo(24);
        reloj2.avanzarTiempo(240); // 10 (dias) x 24 (horas) = 240
//        reloj3.avanzarTiempo(600); // 25 (dias) x 24 (horas) = 600

        assertTrue(reloj1.obtenerFecha().esIgualA(unDiaDespues));
        assertTrue(reloj1.verificarFechaLimite());
        assertTrue(reloj2.obtenerFecha().esIgualA(diezDiasDespues));
        assertFalse(reloj2.verificarFechaLimite());
//        assertTrue(reloj3.obtenerFecha().esIgualA(unMesDespues));
//        assertFalse(reloj3.verificarFechaLimite());
    }
}

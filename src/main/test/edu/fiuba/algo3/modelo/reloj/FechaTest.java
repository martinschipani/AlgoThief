package edu.fiuba.algo3.modelo.reloj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FechaTest {

    @Test
    public void test01avanzarTiempoDevuelveNuevaFecha() {
        Fecha fecha = new Fecha(4, 7);

        Fecha fechaAvanzada = fecha.masHoras(8);

        assertNotSame(fechaAvanzada, fecha);
    }

    @Test
    public void test02fechaOriginalEsAnteriorALaAvanzada() {
        Fecha fecha = new Fecha(4, 7);

        Fecha fechaAvanzada = fecha.masHoras(10);

        assertTrue(fecha.esAntesDe(fechaAvanzada));
    }

    @Test
    public void test03fechaAvanza6Horas() {
        Fecha fecha = new Fecha(4, 7);
        Fecha fechaEsperada = new Fecha(4, 13);

        fecha = fecha.masHoras(6);

        assertTrue(fecha.esIgualA(fechaEsperada));
    }

    @Test
    public void test04muestraFechaCorrectamente() {
        Fecha fecha = new Fecha(4, 7);
        Fecha fechaAvanzada = fecha.conHora(17);
        String formatoFecha = "lunes 7:00 AM";
        String formatoFechaAvanzada = "lunes 5:00 PM";

        assertEquals(formatoFecha, fecha.mostrar());
        assertEquals(formatoFechaAvanzada, fechaAvanzada.mostrar());
    }
}

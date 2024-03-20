package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Sospechoso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadronTest {

    @Test
    public void test01CompararUnLadronSinCaracteristicasConOtroConSexo()
    {
        Ladron ladron1 = new Sospechoso();
        Ladron ladron2 = new Sospechoso();
        ladron2.establecerSexo("Masculino");

        assertFalse(ladron1.esIgualA(ladron2));
        assertFalse(ladron1.esSimilarA(ladron2));
        assertTrue(ladron2.esSimilarA(ladron1));
    }

    @Test
    public void test02CompararDosLadronesDeDistintoSexo()
    {
        Ladron ladron1 = new Sospechoso();
        ladron1.establecerSexo("Femenino");
        Ladron ladron2 = new Sospechoso();
        ladron2.establecerSexo("Masculino");

        assertFalse(ladron1.esIgualA(ladron2));
        assertFalse(ladron1.esSimilarA(ladron2));
        assertFalse(ladron2.esSimilarA(ladron1));
    }

    @Test
    public void test03ElVehiculoDeUnLadronSeAsignaCorrectamente(){
        Ladron ladron1 = new Sospechoso();
        ladron1.establecerVehiculo("Audi");

        assertEquals("Audi", ladron1.obtenerVehiculo().obtenerValor());
    }
}

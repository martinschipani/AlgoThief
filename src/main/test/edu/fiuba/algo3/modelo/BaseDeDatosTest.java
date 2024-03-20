package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.computadora.BaseDeDatos;
import edu.fiuba.algo3.modelo.computadora.ordenesDeArresto.OrdenValida;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Sospechoso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseDeDatosTest {

    @Test
    public void test01BuscarLadronMasculinoEnUnaListaConOtros2()
    {
        Ladron ladron1 = new Sospechoso();
        ladron1.establecerSexo("Masculino");
        Ladron ladron2 = new Sospechoso();
        ladron2.establecerSexo("Masculino");
        ladron2.establecerCabello("Rojo");
        Ladron ladron3 = new Sospechoso();
        ladron3.establecerSexo("Masculino");
        ladron3.establecerHobby("Tenis");
        Ladron ladron4 = new Sospechoso();
        ladron4.establecerSexo("Femenino");
        ladron4.establecerHobby("Tenis");

        BaseDeDatos baseDeDatos = new BaseDeDatos();
        baseDeDatos.agregarLadron(ladron2);
        baseDeDatos.agregarLadron(ladron3);
        baseDeDatos.agregarLadron(ladron4);

        assertFalse(baseDeDatos.buscarLadron(ladron1).getClass() == OrdenValida.class);
    }

    @Test
    public void test02BuscarLadronMasculinoConAnilloEnUnaListaConOtros3LadronesMasculinos()
    {
        Ladron ladron1 = new Sospechoso();
        ladron1.establecerSexo("Masculino");
        ladron1.establecerSenia("Anillo");
        Ladron ladron2 = new Sospechoso();
        ladron2.establecerSexo("Masculino");
        ladron2.establecerCabello("Rojo");
        ladron2.establecerSenia("Anillo");
        Ladron ladron3 = new Sospechoso();
        ladron3.establecerSexo("Masculino");
        ladron3.establecerSenia("Joyas");
        ladron3.establecerVehiculo("Descapotable");
        Ladron ladron4 = new Sospechoso();
        ladron4.establecerSexo("Masculino");
        ladron4.establecerHobby("Tenis");
        ladron4.establecerSenia("Cicatriz");

        BaseDeDatos baseDeDatos = new BaseDeDatos();
        baseDeDatos.agregarLadron(ladron2);
        baseDeDatos.agregarLadron(ladron3);
        baseDeDatos.agregarLadron(ladron4);

        assertTrue(baseDeDatos.buscarLadron(ladron1).getClass() == OrdenValida.class);
    }

    @Test
    public void test03BuscarLadronMasculinoConAnilloYRubioEnUnaListaConOtros3LadronesMasculinos()
    {
        Ladron ladron1 = new Sospechoso();
        ladron1.establecerSexo("Masculino");
        ladron1.establecerSenia("Anillo");
        ladron1.establecerCabello("Rubio");
        Ladron ladron2 = new Sospechoso();
        ladron2.establecerSexo("Masculino");
        ladron2.establecerCabello("Rojo");
        ladron2.establecerSenia("Anillo");
        Ladron ladron3 = new Sospechoso();
        ladron3.establecerSexo("Masculino");
        ladron3.establecerSenia("Joyas");
        ladron3.establecerVehiculo("Descapotable");
        Ladron ladron4 = new Sospechoso();
        ladron4.establecerSexo("Masculino");
        ladron4.establecerHobby("Tenis");
        ladron4.establecerSenia("Cicatriz");

        BaseDeDatos baseDeDatos = new BaseDeDatos();
        baseDeDatos.agregarLadron(ladron2);
        baseDeDatos.agregarLadron(ladron3);
        baseDeDatos.agregarLadron(ladron4);

        assertFalse(baseDeDatos.buscarLadron(ladron1).getClass() == OrdenValida.class);
    }
    
}

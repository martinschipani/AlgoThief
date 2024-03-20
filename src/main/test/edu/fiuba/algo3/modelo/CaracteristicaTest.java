package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.modelo.ladron.caracteristica.TipoCaracteristica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaracteristicaTest {
    
    @Test
    public void test01Comparar2CaracteristicasConDistintoTipo()
    {
        Caracteristica caracteristica1 = new Caracteristica(TipoCaracteristica.SENIA);
        Caracteristica caracteristica2 = new Caracteristica(TipoCaracteristica.CABELLO);

        assertFalse(caracteristica1.compararManeraExacta(caracteristica2));
        assertFalse(caracteristica1.esUna(caracteristica2));
    }

    @Test
    public void test02Comparar2CaracteristicasConMismoTipoYDistintoValor()
    {
        Caracteristica caracteristica1 = new Caracteristica(TipoCaracteristica.SENIA,"Valor 1");
        Caracteristica caracteristica2 = new Caracteristica(TipoCaracteristica.VEHICULO,"Valor 2");

        assertFalse(caracteristica1.compararManeraExacta(caracteristica2));
        assertFalse(caracteristica1.esUna(caracteristica2));
    }

    @Test
    public void test03Comparar2CaracteristicasConMismoTipoYDistintoValorUnoDeEllosNulo()
    {
        Caracteristica caracteristica1 = new Caracteristica(TipoCaracteristica.SEXO,"Valor 1");
        Caracteristica caracteristica2 = new Caracteristica(TipoCaracteristica.SEXO);

        assertFalse(caracteristica1.compararManeraExacta(caracteristica2));
        assertTrue(caracteristica1.esUna(caracteristica2));
        assertFalse(caracteristica2.esUna(caracteristica1));
    }

    @Test
    public void test04Comparar3CaracteristicasConMismoTipoYMismoValor()
    {
        Caracteristica caracteristica1 = new Caracteristica(TipoCaracteristica.HOBBY,"Valor 1");
        Caracteristica caracteristica2 = new Caracteristica(TipoCaracteristica.HOBBY,"Valor 1");
        Caracteristica caracteristica3 = new Caracteristica(TipoCaracteristica.HOBBY,"vAlOr 1");

        assertTrue(caracteristica1.compararManeraExacta(caracteristica2));
        assertTrue(caracteristica1.esUna(caracteristica2));
        assertTrue(caracteristica1.compararManeraExacta(caracteristica3));
    }

}

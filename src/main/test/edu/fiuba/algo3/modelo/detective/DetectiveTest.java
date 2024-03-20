package edu.fiuba.algo3.modelo.detective;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Sospechoso;
import edu.fiuba.algo3.modelo.pistas.ContenedorDePistas;
import edu.fiuba.algo3.modelo.reloj.Fecha;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DetectiveTest {
/*
    @Test
    public void test01DetectiveVisitaUnEdificioYSeDespliegaUnaPista() {
        Edificio puerto = new Edificio("Puerto", "Transporte");
        Detective detective = new DetectiveNovato();
        assertEquals("Cambio dolares por pesos mexicanos", detective.visitarEdificio(Edificio, 1));
    }*/

    @Test
    public void test02DetectiveVisitaUnEdificioYElTiempoTranscurreCorrectamente() {
        Edificio banco = new Edificio("Banco", "Financiero");
        Detective detective = new DetectiveNovato();
        Fecha fecha = new Fecha (4,  8);
        detective.visitarEdificio(banco, 1);
        assertTrue(detective.obtenerFecha().esIgualA(fecha));
    }

    @Test
    public void test03DetectiveViajaDeMontrealAMexico(){
        Mapa mapa = Mapa.obtenerInstancia();
        Detective detective = new DetectiveNovato();
        Ciudad montreal = mapa.obtenerCiudad("Montreal");
        Ciudad mexico = mapa.obtenerCiudad("Mexico");
        mexico.establecerRutaDelLadron("Default");
        Ciudad ciudadActual = montreal;
        Fecha fecha =  new Fecha(4,  11);
        ciudadActual = ciudadActual.realizarViaje(mexico, detective);
        assertEquals(ciudadActual.obtenerNombre(), "Mexico");
        assertTrue(detective.obtenerFecha().esIgualA(fecha));
    }

    @Test
    public void test04DetectiveNovatoComienzaEnMontrealVisitaEdificioYBlibloteca(){
        ContenedorDePistas.obtenerInstancia().cargarPistasLadron(new Sospechoso());
        Detective detective = new DetectiveNovato();
        Ciudad montreal = new Ciudad("Montreal");
        Ciudad siguiente = new Ciudad("Mexico");
        montreal.asignarSiguiente(siguiente);
        Edificio puerto = new Edificio("Puerto", "Transporte");
        Edificio biblioteca = new Edificio("Biblioteca", "Biblioteca");
        montreal.agregarEdificio(puerto);
        montreal.agregarEdificio(biblioteca);
        montreal.visitarEdificio(detective, puerto);
        montreal.visitarEdificio(detective, biblioteca);
        Fecha fecha = new Fecha(4, 10);
        assertTrue(detective.obtenerFecha().esIgualA(fecha));
    }

    @Test
    public void test05DetectiveVisitaUnEdificioYElTiempoTranscurreCorrectamente() {
        Edificio bolsa = new Edificio("Bolsa", "Financiero");
        Detective detective = new DetectiveNovato();
        Fecha fecha = new Fecha(5,  11);
        detective.visitarEdificio(bolsa, 20);
        assertTrue(detective.obtenerFecha().esIgualA(fecha));
    }

    @Test
    public void test06VisitarAeropuertoTresVecesLa(){
        ContenedorDePistas.obtenerInstancia().cargarPistasLadron(new Sospechoso());
        ContenedorDePistas.obtenerInstanciaTEST();
        boolean enCurso = true;
        Detective detective = new DetectiveNovatoFake();
        Ciudad montreal = new Ciudad("Montreal");
        Ciudad siguiente = new Ciudad("Mexico");
        montreal.asignarSiguiente(siguiente);
        Edificio aeropuerto = new Edificio("Aeropuerto", "Transporte");
        Edificio puerto = new Edificio("Puerto", "Transporte");
        montreal.agregarEdificio(aeropuerto);
        montreal.agregarEdificio(puerto);
        for(int i = 0; i < 3; i++){
            montreal.visitarEdificio(detective, aeropuerto);
            enCurso = detective.verificarFechaLimite();
        }
        for(int i = 0; i < 55; i++) {
            montreal.visitarEdificio(detective, puerto);
            enCurso = detective.verificarFechaLimite();
        }
        assertFalse(enCurso);
    }

    @Test
    public void test07DetectiveRecibeUnCuhillazoYDuerme(){
        Detective detective = new DetectiveNovato();
        int distancia = 12600;
        Fecha fecha = new Fecha (5,  7);
        detective.viajarACiudadConLadron(distancia);
        assertTrue(detective.obtenerFecha().esIgualA(fecha));
    }

    @Test
    public void test08DetectiveRecibeDosCuchillazos(){
        Detective detective = new DetectiveNovato();
        int distancia = 900;
        Fecha fecha = new Fecha (4,  12);
        detective.viajarACiudadConLadron(distancia);
        detective.viajarACiudadConLadron(distancia);
        assertTrue(detective.obtenerFecha().esIgualA(fecha));
    }

    @Test
    public void test09DetectiveEntraEnEdificioConLadronSinOrdenDeArrestoYNoLoArresta(){
        Edificio bolsaConLadron = new Edificio("Bolsa", "Financierio");
        Ladron ladron = new Sospechoso();
        bolsaConLadron.establecerLadron(ladron);
        Detective detective = new DetectiveNovatoFake();
        detective.visitarEdificio(bolsaConLadron, 1);
        assertEquals(0, detective.cantidadDeArrestos);
    }

    @Test
    public void test10DetectiveObtieneOrdenDecapturaEntraEnEdificioYAtrapaLadron() {
        Computadora computadora = new Computadora();
        Ladron ladron = new Sospechoso();
        ladron.establecerSexo("Masculino");
        ladron.establecerCabello("Pelirrojo");
        ladron.establecerSenia("Tatuaje");
        ladron.establecerVehiculo("Convertible");
        ladron.establecerHobby("Alpinismo");
        computadora.establecerSospechoso(ladron);
        Edificio bancoConLadron = new Edificio("Banco", "Financiero");
        bancoConLadron.establecerLadron(ladron);
        Detective detective = new DetectiveNovatoFake();
        Fecha fecha = new Fecha(4, 11);
        detective.emitirOrdenDeArresto(computadora);
        detective.visitarEdificio(bancoConLadron, 1);
        assertTrue(detective.obtenerFecha().esIgualA(fecha));
        assertEquals(detective.obtenerContador(),1);
    }
  
    @Test
    public void test11DetectiveConRangoInvestigadorViajaDeMontrealAMexico(){
        Detective detective = new DetectiveInvestigador();
        Ciudad ciudadOrigen = new Ciudad("Montreal");
        Ciudad ciudadDestino = new Ciudad("Mexico");
        ciudadDestino.establecerRutaDelLadron("Default");
        Ciudad ciudadActual = ciudadOrigen;
        ciudadActual = ciudadActual.realizarViaje(ciudadDestino, detective);
        Fecha fecha = new Fecha (4,  10);
        assertEquals(ciudadActual.obtenerNombre(), "Mexico");
        assertTrue(detective.obtenerFecha().esIgualA(fecha));
    }

    @Test
    public void test12DetectiveConRangoDetectiveViajaDeNewYorkAEstambul(){
        Detective detective = new DetectiveDetective();
        Ciudad ciudadOrigen = new Ciudad("New York");
        Ciudad ciudadDestino = new Ciudad("Estambul");
        ciudadDestino.establecerRutaDelLadron("Default");
        Ciudad ciudadActual = ciudadOrigen;
        ciudadActual = ciudadActual.realizarViaje(ciudadDestino, detective);
        Fecha fecha = new Fecha (4,  12);
        assertEquals(ciudadActual.obtenerNombre(), "Estambul");
        assertTrue(detective.obtenerFecha().esIgualA(fecha));
    }

    @Test
    public void test13DetectiveObtieneOrdenDecapturaEntraEnEdificioYAtrapaLadron() {
        Computadora computadora = new Computadora();
        Ladron ladron = new Sospechoso();
        ladron.establecerSexo("Masculino");
        ladron.establecerCabello("Pelirrojo");
        ladron.establecerSenia("Tatuaje");
        ladron.establecerVehiculo("Convertible");
        ladron.establecerHobby("Alpinismo");
        computadora.establecerSospechoso(ladron);
        Edificio bancoConLadron = new Edificio("Banco", "Financiero");
        bancoConLadron.establecerLadron(ladron);
        Detective detective = new DetectiveDetectiveFake();
        Fecha fecha = new Fecha(4, 11);
        detective.emitirOrdenDeArresto(computadora);
        detective.visitarEdificio(bancoConLadron, 1);
        assertTrue(detective.obtenerFecha().esIgualA(fecha));
        assertEquals(detective.obtenerContador(),6);
    }

}

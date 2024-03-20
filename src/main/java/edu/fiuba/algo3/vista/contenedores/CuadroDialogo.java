package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.EstadoJuego;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.computadora.ordenesDeArresto.OrdenDeArresto;
import edu.fiuba.algo3.modelo.computadora.ordenesDeArresto.OrdenValida;
import edu.fiuba.algo3.vista.animaciones.AnimacionTexto;
import edu.fiuba.algo3.vista.contenedores.cuadros.CuadroNegro;
import edu.fiuba.algo3.vista.contenedores.cuadros.MenuHerida;
import edu.fiuba.algo3.vista.etiquetas.Etiqueta;
import javafx.geometry.Pos;

import java.util.ArrayList;

public class CuadroDialogo extends CuadroNegro {

    private static CuadroDialogo instancia = null;
    private Etiqueta mensaje;

    private CuadroDialogo() {
        super();
        this.setPrefSize(400, 350);
        this.setAlignment(Pos.TOP_LEFT);
    }

    public static void crearCuadroDialogo() {
        if (instancia == null) {
            instancia = new CuadroDialogo();
        }
    }

    public static CuadroDialogo obtenerInstancia() {
        if (instancia == null) {
            crearCuadroDialogo();
        }
        return instancia;
    }

    public CuadroDialogo mostrarMensaje(String mensaje) {
        this.actualizarTodo(new AnimacionTexto(mensaje, 12).getEtiqueta());
        return instancia;
    }

    public CuadroDialogo empezarJuego(){
        this.actualizarTodo(new MenuComenzarJuego());
        return instancia;
    }

    public CuadroDialogo desplegarPosiblesViajes(){
        ArrayList<Ciudad> ciudades = Juego.obtenerInstancia().ciudadActual().obtenerCiudadesAdyacentes();
        this.actualizarTodo(new AnimacionTexto("Seleccione la ciudad a la que quiere ir:").getEtiqueta(),
                            new BotonesViajes(ciudades));
        return instancia;
    }

    public CuadroDialogo mostrarCiudad(){
        ArrayList<Edificio> edificios = Juego.obtenerInstancia().ciudadActual().obtenerEdificios();
        this.actualizarTodo(new AnimacionTexto("Seleccione el edificio que quiere investigar:").getEtiqueta(),
                            new BotonesEdificio(edificios));
        return instancia;
    }

    public CuadroDialogo mostrarComputadora(){
        Computadora computadora = Juego.obtenerInstancia().obtenerComputadora();
        this.actualizarTodo(new MenuEmitirOrdenDeArresto(computadora));
        return instancia;
    }

    public CuadroDialogo mostrarEstadoOrdenDeArresto(OrdenDeArresto ordenDeArresto){
        if(ordenDeArresto.getClass() == OrdenValida.class)
            mostrarMensaje("Se emitió exitosamente una orden de arresto para la\n" +
                    " captura de " + ((OrdenValida) ordenDeArresto).obtenerNombreSospechoso() + ".");
        else mostrarMensaje("No se pudo emitir una orden de arresto porque o \nno hay ningún sospechoso en la base de datos que\n" +
                                " cumpla con las características elegidas, o hay 2 o\n más que las cumplen.");
        return instancia;
    }

    public CuadroDialogo sufrirCuchillazo(){
        this.actualizarTodo(new MenuHerida("Un secuaz del sospechoso te hirió con un cuchillo."));
        return instancia;
    }

    public CuadroDialogo sufrirBalazo(){
        this.actualizarTodo(new MenuHerida("El sospechoso te disparó."));
        return instancia;
    }

    public CuadroDialogo update(){
        EstadoJuego estadoMision = Juego.obtenerInstancia().estadoMision();
        String mensaje = "";

        if(estadoMision == EstadoJuego.TIEMPO_AGOTADO){
            mensaje = "Se acabó el tiempo! Se perdió el rastro del ladrón.";
        }

        else if(estadoMision == EstadoJuego.LADRON_ATRAPADO){
            mensaje = "Felicidades! Capturaste al sospechoso y el tesoro está siendo regresado a su lugar de origen.";
        }

        else if(estadoMision == EstadoJuego.LADRON_ESCAPO){
            mensaje = "Atrapaste al ladrón pero como no tenías una orden de arresto para él, salió en libertad..";
        }

        else if(estadoMision == EstadoJuego.SIN_MISION){
            mensaje = "Sin misión.";
        }

        this.actualizarTodo(new MenuComenzarNuevaMision(mensaje));

        return instancia;
    }
}

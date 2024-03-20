package edu.fiuba.algo3.modelo.detective;

import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.computadora.ordenesDeArresto.OrdenDeArresto;
import edu.fiuba.algo3.modelo.computadora.ordenesDeArresto.OrdenInvalida;
import edu.fiuba.algo3.modelo.detective.cuchillazo.Cuchillazo;
import edu.fiuba.algo3.modelo.detective.cuchillazo.SinAcuchillar;
import edu.fiuba.algo3.modelo.detective.randomizador.Randomizador;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.pistas.ContenedorDePistas;
import edu.fiuba.algo3.modelo.reloj.Fecha;
import edu.fiuba.algo3.modelo.reloj.Reloj;
import edu.fiuba.algo3.vista.contenedores.CuadroDialogo;

public abstract class Detective{
    protected Reloj reloj;
    protected Cuchillazo cantidadDeCuchillazos;
    protected boolean fueHerido;
    protected OrdenDeArresto ordenDeArresto;
    protected int cantidadDeArrestos;
    protected float velocidad;
    protected Randomizador randomizador;

    Detective(){
        this.reloj = new Reloj();
        this.cantidadDeCuchillazos = new SinAcuchillar();
        this.ordenDeArresto = new OrdenInvalida();
        this.fueHerido = false;
    }

    public boolean verificarFechaLimite(){
        return( this.reloj.verificarFechaLimite() );
    }

    public void visitarEdificio(Edificio edificio, int horas){
        this.reloj.avanzarTiempo(horas);
        edificio.visitar(this);
    }

    public Fecha obtenerFecha(){
        return this.reloj.obtenerFecha();
    }
    
    public OrdenDeArresto emitirOrdenDeArresto(Computadora computadora) {
        this.ordenDeArresto = computadora.emitirOrdenDeArresto();
        this.reloj.avanzarTiempo(3);
        return this.ordenDeArresto;
    }


    public void arrestarladron(Ladron ladron){
        if(this.ordenDeArresto.esPara(ladron)){
            Juego.obtenerInstancia().asignarDetective(this.incrementarArresto());
            Juego.obtenerInstancia().ganarMision();
        }

        Juego.obtenerInstancia().ladronEscapo();
    }

    public abstract void viajar(int distancia);

    private void sufrirCuchillazo(){
        float probabilidad = this.randomizador.generarProbabilidad();
        if(probabilidad < 0.3){
            this.fueHerido = true;
            this.cantidadDeCuchillazos = this.cantidadDeCuchillazos.acuchillar(this.reloj);
        }
    }

    private void sufrirBalazo(){
        float probabilidad = this.randomizador.generarProbabilidad();
        if(probabilidad < 0.3){
            this.fueHerido = true;
            this.reloj.avanzarTiempo(4);
        }
    }

    public void recibirAtaque(){
        float probabilidad = this.randomizador.generarProbabilidad();
        if(probabilidad < 0.3){
            CuadroDialogo.obtenerInstancia().sufrirBalazo();
            this.sufrirBalazo();
        }
        else{
            CuadroDialogo.obtenerInstancia().sufrirCuchillazo();
            this.sufrirCuchillazo();
        }
    }

    public abstract Detective incrementarArresto();

    public String leerPista(String nombreCiudad, String tipoEdificio){
        return ContenedorDePistas.obtenerInstancia().leerPista(randomizador.generarDificultad(), nombreCiudad, tipoEdificio);
    }

    public String leerPistaConLadron(String nombreCiudad, String tipoEdificio){
        return ContenedorDePistas.obtenerInstancia().leerPistaConLadron(randomizador.generarDificultad(), nombreCiudad, tipoEdificio);
    }

    public void reiniciarReloj(){
        this.reloj = new Reloj();
    }

    public int determinarLongitudMision(){
        if(this.cantidadDeArrestos < 5){
            return 3;
        } else if(this.cantidadDeArrestos < 10){
            return 5;
        } else return 7;
    }

    public String rango(){
        return this.getClass().getSimpleName().substring(9);
    }

    public void viajarACiudadConLadron(int distancia){
        this.cantidadDeCuchillazos = this.cantidadDeCuchillazos.acuchillar(this.reloj);
        this.reloj.avanzarTiempo((int) Math.round(distancia/this.velocidad));
    }

    public boolean estaHerido(){
        return this.fueHerido;
    }

    public void sanar(){
        this.fueHerido = false;
    }

    public int obtenerContador() {
        return this.cantidadDeArrestos;
    }
}

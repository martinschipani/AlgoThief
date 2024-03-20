package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.computadora.ordenesDeArresto.OrdenDeArresto;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Sospechoso;
import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.modelo.lectores.LectorDeLadrones;

import java.util.ArrayList;

public class Computadora {

    private BaseDeDatos baseDeDatos;
    private Ladron ladronGuardado;

    public Computadora(){
        this.baseDeDatos = new BaseDeDatos();
        this.ladronGuardado = new Sospechoso();
        LectorDeLadrones lector = new LectorDeLadrones("src/main/java/edu/fiuba/algo3/config/ladrones.json");
        lector.cargarLadrones(this);
    }

    public void establecerSospechoso(Ladron sospechoso) {
        this.ladronGuardado = sospechoso;
    }

    public void establecerSexo(String sexo){
        this.ladronGuardado.establecerSexo(sexo);
    }

    public void establecerHobby(String hobby){
        this.ladronGuardado.establecerHobby(hobby);
    }

    public void establecerCabello(String pelo){
        this.ladronGuardado.establecerCabello(pelo);
    }

    public void establecerSenia(String senia){
        this.ladronGuardado.establecerSenia(senia);
    }

    public void establecerVehiculo(String vehiculo){
        this.ladronGuardado.establecerVehiculo(vehiculo);
    }

    public ArrayList<Caracteristica> caracteristicasGuardadas(){
        return this.ladronGuardado.obtenerCaracteristicas();
    }

    public OrdenDeArresto emitirOrdenDeArresto(){
        return this.baseDeDatos.buscarLadron(this.ladronGuardado);
    }

    public void agregarLadron(Ladron ladron){
        this.baseDeDatos.agregarLadron(ladron);
    }

    public Ladron obtenerLadronRandom() {
        return this.baseDeDatos.obtenerLadronRandom();
    }

    public void reiniciar() {
        ladronGuardado = new Sospechoso();
    }
}

package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.detective.Detective;
import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.modelo.ladron.caracteristica.TipoCaracteristica;

import java.util.ArrayList;

public abstract class Ladron {
    
    String nombre;
    ArrayList<Caracteristica> caracteristicas;

    public Ladron(){
        this.nombre = "";
        caracteristicas = new ArrayList<Caracteristica>();
        for (TipoCaracteristica tipo: TipoCaracteristica.values()) {
            if (tipo != TipoCaracteristica.SIN_CARACTERISTICA) {
                this.caracteristicas.add(new Caracteristica(tipo));
            }
        }
    }

    private void establecerCaracteristica(TipoCaracteristica tipo, String valor){
        Caracteristica caracteristicaAuxiliar = new Caracteristica(tipo, valor);
        caracteristicas.stream().filter(elemento -> elemento.compararTipo(caracteristicaAuxiliar)).forEach(elemento -> elemento.establecerValor(valor));
    }

    private boolean buscarCaracteristicaSimilarEnLadron(ArrayList<Caracteristica> caracteristicas, Caracteristica caracteristicaABuscar)
    {
        long cantidad = caracteristicas.stream().filter(elemento -> caracteristicaABuscar.esUna(elemento)).count();
        return cantidad > 0;
    }

    private boolean buscarCaracteristicaExactaEnLadron(ArrayList<Caracteristica> caracteristicas, Caracteristica caracteristicaABuscar)
    {
        long cantidad = caracteristicas.stream().filter(elemento -> caracteristicaABuscar.compararManeraExacta(elemento)).count();
        return cantidad > 0;
    }

    public void establecerNombre(String nombre){
        this.nombre = nombre;
    }

    public void establecerSexo(String sexo){
        establecerCaracteristica(TipoCaracteristica.SEXO, sexo);
    }

    public void establecerHobby(String hobby){
        establecerCaracteristica(TipoCaracteristica.HOBBY, hobby);
    }

    public void establecerCabello(String cabello){
        establecerCaracteristica(TipoCaracteristica.CABELLO, cabello);
    }

    public void establecerSenia(String senia){
        establecerCaracteristica(TipoCaracteristica.SENIA, senia);
    }
    
    public void establecerVehiculo(String vehiculo){
        establecerCaracteristica(TipoCaracteristica.VEHICULO, vehiculo);
    }

    public ArrayList<Caracteristica> obtenerCaracteristicas(){
        return caracteristicas;
    }

    public String obtenerNombre(){
        return this.nombre;
    }

    public Caracteristica obtenerSexo(){
        Caracteristica caracteristicaAuxiliar = new Caracteristica(TipoCaracteristica.SEXO, "nada");
        return this.caracteristicas.stream().filter(elemento -> elemento.compararTipo(caracteristicaAuxiliar)).findFirst().get();
    }
    public Caracteristica obtenerHobby(){
        Caracteristica caracteristicaAuxiliar = new Caracteristica(TipoCaracteristica.HOBBY, "nada");
        return this.caracteristicas.stream().filter(elemento -> elemento.compararTipo(caracteristicaAuxiliar)).findFirst().get();
    }

    public Caracteristica obtenerCabello(){
        Caracteristica caracteristicaAuxiliar = new Caracteristica(TipoCaracteristica.CABELLO, "nada");
        return this.caracteristicas.stream().filter(elemento -> elemento.compararTipo(caracteristicaAuxiliar)).findFirst().get();
    }

    public Caracteristica obtenerSenia(){
        Caracteristica caracteristicaAuxiliar = new Caracteristica(TipoCaracteristica.SENIA, "nada");
        return this.caracteristicas.stream().filter(elemento -> elemento.compararTipo(caracteristicaAuxiliar)).findFirst().get();
    }

    public Caracteristica obtenerVehiculo(){
        Caracteristica caracteristicaAuxiliar = new Caracteristica(TipoCaracteristica.VEHICULO, "nada");
        return this.caracteristicas.stream().filter(elemento -> elemento.compararTipo(caracteristicaAuxiliar)).findFirst().get();
    }

    public boolean esSimilarA(Ladron ladron){
        long cantidadMismatches = this.caracteristicas.stream().filter(elemento -> !buscarCaracteristicaSimilarEnLadron(ladron.caracteristicas,elemento)).count();
        return cantidadMismatches == 0;
    }

    public boolean esIgualA(Ladron ladron){
        long cantidadMismatches = this.caracteristicas.stream().filter(elemento -> !buscarCaracteristicaExactaEnLadron(ladron.caracteristicas,elemento)).count();
        return cantidadMismatches == 0;
    }
    
    public abstract void encontrar(Detective detective);
    
}

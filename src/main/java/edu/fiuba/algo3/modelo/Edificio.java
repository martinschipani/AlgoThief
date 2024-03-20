package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.detective.Detective;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.NoLadron;
import edu.fiuba.algo3.modelo.ladron.Sospechoso;

public class Edificio {

    protected Ladron ladron;
    protected String nombre;
    protected String tipo;

    public Edificio(String nombre, String tipo){
        this.ladron = new NoLadron();
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public void establecerLadron(Ladron ladron){
        this.ladron = ladron;
    }

    public String obtenerTipo(){
        return this.tipo;
    }

    public String obtenerNombre(){
        return this.nombre;
    }

    public void visitar(Detective detective){
        this.ladron.encontrar(detective);
    }

    ////// TEST //////
    public Boolean encontrarLadron(){
        return this.ladron.getClass() == Sospechoso.class;
    }

}

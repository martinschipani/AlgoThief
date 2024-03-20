package edu.fiuba.algo3.modelo.computadora.ordenesDeArresto;

import edu.fiuba.algo3.modelo.ladron.Ladron;

public class OrdenValida implements OrdenDeArresto {

    private Ladron ladron;

    public OrdenValida(Ladron ladron){
        this.ladron = ladron;
    }

    public boolean esPara(Ladron ladron){
        return this.ladron.esIgualA(ladron);
    }

    public String obtenerNombreSospechoso(){
        return this.ladron.obtenerNombre();
    }
}

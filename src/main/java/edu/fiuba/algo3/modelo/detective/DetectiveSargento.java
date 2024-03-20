package edu.fiuba.algo3.modelo.detective;

import edu.fiuba.algo3.modelo.detective.randomizador.RandomizadorSargento;

public class DetectiveSargento extends Detective {

    public DetectiveSargento(){
        super();
        this.cantidadDeArrestos = 20;
        this.velocidad = 1500;
        this.randomizador = new RandomizadorSargento();
    }

    public void viajar(int distancia){
        this.reloj.avanzarTiempo((int) Math.round(distancia/this.velocidad));
    }

    @Override
    public Detective incrementarArresto() {
        this.cantidadDeArrestos++;
        return this;
    }

}

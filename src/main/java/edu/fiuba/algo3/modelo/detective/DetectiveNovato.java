package edu.fiuba.algo3.modelo.detective;

import edu.fiuba.algo3.modelo.detective.randomizador.RandomizadorNovato;

public class DetectiveNovato extends Detective {

    public DetectiveNovato(){
        super();
        this.cantidadDeArrestos = 0;
        this.velocidad = 900;
        this.randomizador = new RandomizadorNovato();
    }

    public void viajar(int distancia){
        this.reloj.avanzarTiempo((int) Math.round(distancia/this.velocidad));
    }

    @Override
    public Detective incrementarArresto() {
        this.cantidadDeArrestos++;
        if (cantidadDeArrestos == 5) {
            return new DetectiveDetective();
        }
        return this;
    }
}

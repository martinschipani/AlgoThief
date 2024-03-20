package edu.fiuba.algo3.modelo.detective;

import edu.fiuba.algo3.modelo.detective.randomizador.RandomizadorInvestigador;

public class DetectiveInvestigador extends Detective {

    public DetectiveInvestigador(){
        super();
        this.cantidadDeArrestos = 10;
        this.velocidad = 1300;
        this.randomizador = new RandomizadorInvestigador();
    }

    public void viajar(int distancia){
        this.reloj.avanzarTiempo((int) Math.round(distancia/this.velocidad));
    }

    @Override
    public Detective incrementarArresto() {
        this.cantidadDeArrestos++;
        if (cantidadDeArrestos == 20) {
            return new DetectiveSargento();
        }
        return this;
    }
}

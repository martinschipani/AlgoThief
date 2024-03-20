package edu.fiuba.algo3.modelo.detective;

import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.reloj.RelojFake;

public class DetectiveNovatoFake extends DetectiveNovato {
    public DetectiveNovatoFake(){
        super();
        this.reloj = new RelojFake();
    }

    @Override
    public void arrestarladron(Ladron ladron) {
        if (this.ordenDeArresto.esPara(ladron)) {
            this.incrementarArresto();
        }
    }

}

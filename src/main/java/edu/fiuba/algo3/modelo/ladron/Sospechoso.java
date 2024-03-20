package edu.fiuba.algo3.modelo.ladron;

import edu.fiuba.algo3.modelo.detective.Detective;

public class Sospechoso extends Ladron {
    public void encontrar(Detective detective){
        detective.arrestarladron(this);
    }
}

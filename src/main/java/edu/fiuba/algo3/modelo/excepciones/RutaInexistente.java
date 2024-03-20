package edu.fiuba.algo3.modelo.excepciones;

public class RutaInexistente extends RuntimeException {

    public RutaInexistente(String description){
        super(description);
    }
}

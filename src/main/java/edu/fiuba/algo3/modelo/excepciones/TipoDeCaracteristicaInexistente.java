package edu.fiuba.algo3.modelo.excepciones;

public class TipoDeCaracteristicaInexistente extends RuntimeException {

    public TipoDeCaracteristicaInexistente(String description){
        super(description);
    }
}

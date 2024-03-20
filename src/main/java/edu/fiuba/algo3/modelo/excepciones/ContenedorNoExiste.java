package edu.fiuba.algo3.modelo.excepciones;

public class ContenedorNoExiste extends RuntimeException {

    public ContenedorNoExiste(String description){
        super(description);
    }
}
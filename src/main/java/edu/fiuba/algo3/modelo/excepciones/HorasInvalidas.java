package edu.fiuba.algo3.modelo.excepciones;

public class HorasInvalidas extends RuntimeException {

        public HorasInvalidas(String descripcion) {
                super(descripcion);
        }
}

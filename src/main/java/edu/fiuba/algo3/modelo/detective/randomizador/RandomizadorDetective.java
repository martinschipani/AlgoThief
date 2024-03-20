package edu.fiuba.algo3.modelo.detective.randomizador;

public class RandomizadorDetective extends Randomizador{

    public String generarDificultad(){
        double probabilidad = random.nextDouble();

        if (probabilidad < 0.4) {
            return "Facil";
        } else if (probabilidad < 0.8) {
            return "Media";
        } else {
            return "Dificil";
        }
    }
}
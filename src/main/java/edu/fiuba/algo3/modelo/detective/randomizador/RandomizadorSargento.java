package edu.fiuba.algo3.modelo.detective.randomizador;

public class RandomizadorSargento extends Randomizador{

    public String generarDificultad(){
        double probabilidad = random.nextDouble();

        if (probabilidad < 0.2) {
            return "Facil";
        } else if (probabilidad < 0.4) {
            return "Media";
        } else {
            return "Dificil";
        }
    }
}
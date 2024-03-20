package edu.fiuba.algo3.modelo.detective.randomizador;

public class RandomizadorNovato extends Randomizador{

    public String generarDificultad(){
        double probabilidad = random.nextDouble();

        if (probabilidad < 0.6) {
            return "Facil";
        } else if (probabilidad < 0.8) {
            return "Media";
        } else {
            return "Dificil";
        }
    }
}

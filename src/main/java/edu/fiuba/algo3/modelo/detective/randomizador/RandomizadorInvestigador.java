package edu.fiuba.algo3.modelo.detective.randomizador;

public class RandomizadorInvestigador extends Randomizador{

    public String generarDificultad(){
        double probabilidad = random.nextDouble();

        if (probabilidad < 0.2) {
            return "Facil";
        } else if (probabilidad < 0.6) {
            return "Media";
        } else {
            return "Dificil";
        }
    }
}
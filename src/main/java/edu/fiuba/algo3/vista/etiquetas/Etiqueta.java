package edu.fiuba.algo3.vista.etiquetas;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class Etiqueta extends Label {

    public Etiqueta(String titulo) {
        this(titulo, 12, "#ffffff", "file:fuentes//Minecraftia-Regular.ttf");
    }

    public Etiqueta(String titulo, int tamanioFuente) {
        this(titulo, tamanioFuente, "#ffffff", "file:fuentes//Minecraftia-Regular.ttf");
    }

    public Etiqueta(String titulo, int tamanioFuente, String color) {
        this(titulo, tamanioFuente, color, "file:fuentes//Minecraftia-Regular.ttf");
    }

    public Etiqueta(String titulo, int tamanioFuente, String color, String pathFuente) {
        super(titulo);
        Font fuente = Font.loadFont(pathFuente, tamanioFuente);
        this.setFont(fuente);
        this.setTextFill(Paint.valueOf(color));
        this.setWrapText(true);
    }
}

package edu.fiuba.algo3.vista.botones;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderImage;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public abstract class BotonDeColor extends Button {

    public abstract String getColorFondo();

    public abstract String getColorFill();

    public abstract BorderImage getTipoBorde();

    public BotonDeColor(String titulo, boolean conBorde) {
        super(titulo);
        BackgroundFill fondoNormal = new BackgroundFill(Paint.valueOf(this.getColorFondo()), null, null);
        BorderImage bordeActivo = this.getTipoBorde();
        this.setBackground(new Background(fondoNormal));
        this.setTextFill(Paint.valueOf(this.getColorFill()));
        this.setFont(Font.loadFont("file:fuentes//Minecraftia-Regular.ttf", 12));
        this.setAlignment(Pos.CENTER);
        this.setCursor(Cursor.HAND);

        if (conBorde) {
            this.setOnMouseEntered(e -> {
                this.setBorder(new Border(bordeActivo));
            });
            this.setOnMouseExited(e -> {
                this.setBorder(null);
            });
        }
    }
}

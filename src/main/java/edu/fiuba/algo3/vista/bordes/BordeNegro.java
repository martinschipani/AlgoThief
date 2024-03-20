package edu.fiuba.algo3.vista.bordes;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderWidths;

public class BordeNegro extends BorderImage {

    public BordeNegro() {
        this(10, 0, 10, true);
    }

    public BordeNegro(double bordes) {
        this(bordes, 0, 10, true);
    }

    public BordeNegro(double bordes, double insets, double slices, boolean lleno) {
        super(new Image("file:media/img/pantallaNegra.png"),
                new BorderWidths(bordes),
                new Insets(insets),
                new BorderWidths(slices),
                lleno,
                null, null);
    }
}

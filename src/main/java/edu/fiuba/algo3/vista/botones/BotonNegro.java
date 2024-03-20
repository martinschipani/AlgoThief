package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.vista.bordes.BordeNegro;
import javafx.scene.layout.BorderImage;

public class BotonNegro extends BotonDeColor {

    public BotonNegro() {
        super("", true);
    }

    public BotonNegro(String titulo) {
        super(titulo, true);
    }

    public BotonNegro(String titulo, boolean conBorde) {
        super(titulo, conBorde);
    }

    @Override
    public String getColorFondo() {
        return "transparent";
    }

    @Override
    public String getColorFill() {
        return "#ffffff";
    }

    @Override
    public BorderImage getTipoBorde() {
        return new BordeNegro(7);
    }
}

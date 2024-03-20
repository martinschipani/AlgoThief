package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.vista.bordes.BordeBlanco;
import javafx.scene.layout.BorderImage;

public class BotonBlancoTransparente extends BotonDeColor {

    public BotonBlancoTransparente() {
        super("", true);
    }

    public BotonBlancoTransparente(String titulo) {
        super(titulo, true);
    }

    public BotonBlancoTransparente(String titulo, boolean conBorde) {
        super(titulo, conBorde);
    }

    @Override
    public String getColorFondo() {
        return "transparent";
    }

    @Override
    public String getColorFill() {
        return "#000000";
    }

    @Override
    public BorderImage getTipoBorde() {
        return new BordeBlanco(6);
    }
}

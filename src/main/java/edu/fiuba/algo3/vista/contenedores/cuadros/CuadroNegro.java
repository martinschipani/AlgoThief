package edu.fiuba.algo3.vista.contenedores.cuadros;

import edu.fiuba.algo3.vista.bordes.BordeNegro;
import javafx.scene.layout.Border;

public class CuadroNegro extends CuadroPersonalizable {

    public Border getTipoBorde() {
        return new Border(new BordeNegro());
    }
}

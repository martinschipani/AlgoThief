package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.vista.botones.acciones.BotonComputadora;
import edu.fiuba.algo3.vista.botones.acciones.BotonInvestigar;
import edu.fiuba.algo3.vista.botones.acciones.BotonVer;
import edu.fiuba.algo3.vista.botones.acciones.BotonViajar;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class BotonesAcciones extends HBox {

    public BotonesAcciones() {
        super(5);
        this.getChildren().addAll(
                new BotonVer(),
                new BotonViajar(),
                new BotonInvestigar(),
                new BotonComputadora()
        );
        this.setAlignment(Pos.BOTTOM_CENTER);
    }
}

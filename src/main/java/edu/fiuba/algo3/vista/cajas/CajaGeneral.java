package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.vista.menus.BarraMenus;
import javafx.scene.layout.VBox;

public class CajaGeneral extends VBox {

    private BarraMenus barraMenus;
    private CajaPantalla cajaPantalla;

    public CajaGeneral() {
        super();
        this.barraMenus = new BarraMenus();
        this.cajaPantalla = new CajaPantalla();
        this.getChildren().addAll(this.barraMenus, this.cajaPantalla);
    }
}

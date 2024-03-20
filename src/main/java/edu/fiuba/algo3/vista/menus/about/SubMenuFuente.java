package edu.fiuba.algo3.vista.menus.about;

import edu.fiuba.algo3.controlador.menus.HandlerFuente;
import javafx.scene.control.MenuItem;

public class SubMenuFuente extends MenuItem {

    public SubMenuFuente() {
        super("Fuente");
        this.setOnAction(new HandlerFuente());
    }
}

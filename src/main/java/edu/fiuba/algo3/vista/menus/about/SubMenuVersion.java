package edu.fiuba.algo3.vista.menus.about;

import edu.fiuba.algo3.controlador.menus.HandlerVersion;
import javafx.scene.control.MenuItem;

public class SubMenuVersion extends MenuItem {

    public SubMenuVersion() {
        super("Versión");
        this.setOnAction(new HandlerVersion());
    }
}

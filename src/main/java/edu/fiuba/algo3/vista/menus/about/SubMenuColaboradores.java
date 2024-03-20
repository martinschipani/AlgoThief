package edu.fiuba.algo3.vista.menus.about;

import edu.fiuba.algo3.controlador.menus.HandlerColaboradores;
import javafx.scene.control.MenuItem;

public class SubMenuColaboradores extends MenuItem {

    public SubMenuColaboradores() {
        super("Colaboradores");
        this.setOnAction(new HandlerColaboradores());
    }
}

package edu.fiuba.algo3.vista.menus.about;

import javafx.scene.control.Menu;

public class MenuAcercaDe extends Menu {

    public MenuAcercaDe() {
        super("Acerca De");
        this.getItems().addAll(new SubMenuColaboradores(), new SubMenuFuente(), new SubMenuVersion());
    }
}

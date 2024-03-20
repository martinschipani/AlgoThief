package edu.fiuba.algo3.vista.menus.instrucciones;

import javafx.scene.control.Menu;

public class MenuInstrucciones extends Menu {

    public MenuInstrucciones() {
        super("Instrucciones");
        this.getItems().addAll(new SubMenuComoJugar());
    }
}

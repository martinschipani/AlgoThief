package edu.fiuba.algo3.vista.menus.juego;

import javafx.scene.control.Menu;

public class MenuJuego extends Menu {

    public MenuJuego() {
        super("Juego");
        this.getItems().addAll(new SubMenuReiniciar());
    }
}

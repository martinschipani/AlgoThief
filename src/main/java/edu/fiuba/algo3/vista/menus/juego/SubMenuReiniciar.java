package edu.fiuba.algo3.vista.menus.juego;

import edu.fiuba.algo3.controlador.botones.contextuales.HandlerComenzarMision;
import javafx.scene.control.MenuItem;

public class SubMenuReiniciar extends MenuItem {

    public SubMenuReiniciar() {
        super("Recomenzar Misión");
        this.setOnAction(new HandlerComenzarMision());
    }
}

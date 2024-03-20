package edu.fiuba.algo3.vista.menus.instrucciones;

import edu.fiuba.algo3.controlador.menus.HandlerInstrucciones;
import javafx.scene.control.MenuItem;

public class SubMenuComoJugar extends MenuItem {

    public SubMenuComoJugar() {
        super("Cómo Jugar");
        this.setOnAction(new HandlerInstrucciones());
    }
}

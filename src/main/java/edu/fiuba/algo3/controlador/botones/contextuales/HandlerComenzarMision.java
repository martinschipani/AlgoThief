package edu.fiuba.algo3.controlador.botones.contextuales;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.cajas.CajaLugarYFecha;
import edu.fiuba.algo3.vista.contenedores.CuadroDialogo;
import edu.fiuba.algo3.vista.contenedores.MenuInfoMision;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandlerComenzarMision implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.obtenerInstancia().empezarNuevaMision();
        CajaLugarYFecha.obtenerInstancia().mostrarCuartelGeneral();
        CuadroDialogo.obtenerInstancia().actualizarTodo(new MenuInfoMision());
    }
}

package edu.fiuba.algo3.controlador.botones.contextuales;

import edu.fiuba.algo3.modelo.Edificio;
import edu.fiuba.algo3.modelo.EstadoJuego;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.cajas.CajaLugarYFecha;
import edu.fiuba.algo3.vista.contenedores.CuadroDialogo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandlerElegirEdificio implements EventHandler<ActionEvent> {

    private Edificio edificio;

    public HandlerElegirEdificio(Edificio edificio){
        this.edificio = edificio;
    }

    @Override
    public void handle(ActionEvent actionevent){
        String pista = Juego.obtenerInstancia().visitarEdificio(edificio);
        CajaLugarYFecha.obtenerInstancia().mostrarLugarYTiempo();
        if(Juego.obtenerInstancia().estadoMision() == EstadoJuego.EN_CURSO) {
            CuadroDialogo.obtenerInstancia().mostrarMensaje(pista);
        }
    }
}



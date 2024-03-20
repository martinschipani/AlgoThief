package edu.fiuba.algo3.controlador.botones.contextuales;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.EstadoJuego;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.pistas.DescripcionesDeCiudades;
import edu.fiuba.algo3.vista.animaciones.AnimacionTexto;
import edu.fiuba.algo3.vista.cajas.CajaLugarYFecha;
import edu.fiuba.algo3.vista.contenedores.CuadroDialogo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandlerElegirCiudad implements EventHandler<ActionEvent> {
    private Ciudad ciudad;

    public HandlerElegirCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public void handle(ActionEvent actionevent){
        Juego.obtenerInstancia().viajar(ciudad);
        CajaLugarYFecha.obtenerInstancia().mostrarLugarYTiempo();
        if(Juego.obtenerInstancia().estadoMision() == EstadoJuego.EN_CURSO && !Juego.obtenerInstancia().obtenerDetective().estaHerido()){
           CuadroDialogo.obtenerInstancia().limpiar();
           String descripcion = DescripcionesDeCiudades.obtenerInstancia().leerDescripcion(Juego.obtenerInstancia().ciudadActual().obtenerNombre());
           CuadroDialogo.obtenerInstancia().actualizarTodo(new AnimacionTexto(descripcion).getEtiqueta());
        }
    }
}

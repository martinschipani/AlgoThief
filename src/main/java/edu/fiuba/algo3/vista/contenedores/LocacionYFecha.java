package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.animaciones.AnimacionTexto;
import edu.fiuba.algo3.vista.contenedores.cuadros.CuadroNegro;
import javafx.geometry.Pos;

public class LocacionYFecha extends CuadroNegro {
    private static LocacionYFecha instancia = null;
    private AnimacionTexto lugar;
    private AnimacionTexto tiempo;

    private LocacionYFecha() {
        super();
        this.lugar = new AnimacionTexto(Juego.obtenerInstancia().ciudadActual().obtenerNombre(), 16);
        this.tiempo = new AnimacionTexto(Juego.obtenerInstancia().obtenerHorario(), 14);
        this.agregarTodo(this.lugar.getEtiqueta(), this.tiempo.getEtiqueta());
    }

    private static void crearLocacionYFecha() {
        if (instancia == null) {
            instancia = new LocacionYFecha();
        }
    }

    public static LocacionYFecha obtenerInstancia() {
        if (instancia == null) {
            crearLocacionYFecha();
        }
        return instancia;
    }

    public LocacionYFecha mostrarLugarYTiempo() {
        this.lugar.reiniciar(Juego.obtenerInstancia().ciudadActual().obtenerNombre());
        this.tiempo.reiniciar(Juego.obtenerInstancia().obtenerHorario());
        this.setAlignment(Pos.TOP_CENTER);
        return instancia;
    }

    public LocacionYFecha mostrarCuartelGeneral() {
        this.lugar.reiniciar("Cuartel General");
        this.tiempo.reiniciar("");
        this.setAlignment(Pos.TOP_CENTER);
        return instancia;
    }
}

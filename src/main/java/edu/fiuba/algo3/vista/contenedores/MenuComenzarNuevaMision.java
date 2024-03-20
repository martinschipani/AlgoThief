package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.animaciones.AnimacionTexto;
import edu.fiuba.algo3.vista.botones.contextuales.BotonComenzarMision;
import javafx.scene.layout.VBox;

public class MenuComenzarNuevaMision extends VBox {
    public MenuComenzarNuevaMision(String mensaje){
        super(15);
        String rango = Juego.obtenerInstancia().obtenerDetective().rango();
        int arrestos = Juego.obtenerInstancia().obtenerDetective().obtenerContador();
        String informeDeProgreso = "Tu rango es " + rango + " y tienes " + arrestos + " arrestos registrados.";
        this.getChildren().addAll(new AnimacionTexto(mensaje).getEtiqueta(), new AnimacionTexto(informeDeProgreso).getEtiqueta(), new BotonComenzarMision());
    }
}

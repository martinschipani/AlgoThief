package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.vista.contenedores.BotonesAcciones;
import edu.fiuba.algo3.vista.contenedores.CuadroDialogo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class CajaBotonesYDialogo extends VBox {

    public CajaBotonesYDialogo() {
        super(5);
        this.getChildren().addAll(CuadroDialogo.obtenerInstancia().empezarJuego(), new BotonesAcciones());
        this.setPadding(new Insets(1.5));
        this.setAlignment(Pos.CENTER_RIGHT);
    }
}

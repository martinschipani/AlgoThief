package edu.fiuba.algo3.vista.cajas;

import javafx.scene.layout.HBox;

public class CajaPantalla extends HBox{

    public CajaPantalla() {
        super(0);
        this.getChildren().setAll(CajaLugarYFecha.obtenerInstancia().mostrarCuartelGeneral(), new CajaBotonesYDialogo());
    }
}

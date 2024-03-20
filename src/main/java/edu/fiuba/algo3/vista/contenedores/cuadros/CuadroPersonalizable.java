package edu.fiuba.algo3.vista.contenedores.cuadros;

import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;

public abstract class CuadroPersonalizable extends VBox {

    public abstract Border getTipoBorde();

    public CuadroPersonalizable() {
        super(0);
        this.setBorder(this.getTipoBorde());
    }

    public void limpiar() {
        this.getChildren().clear();
    }

    public void agregar(Node elemento) {
        this.getChildren().add(elemento);
    }

    public void agregarTodo(Node... elementos) {
        this.getChildren().addAll(elementos);
    }

    public void actualizarTodo(Node... elementos) {
        this.getChildren().setAll(elementos);
    }
}

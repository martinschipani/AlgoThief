package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.imagenes.IconoAlgoThief;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Clase utilizada sólo para crear sub-ventanas.
 * */
public class SubEscenario extends Stage {

    public SubEscenario(String titulo, Node... elementos) {
        super();
        StackPane layout = new StackPane(elementos);
        layout.setAlignment(Pos.TOP_CENTER);
        Scene escena = new Scene(layout);
        this.setTitle(titulo);
        this.setScene(escena);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.getIcons().add(new IconoAlgoThief());
        this.sizeToScene();
    }
}

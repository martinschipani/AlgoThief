package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.escena.Escena;
import edu.fiuba.algo3.vista.imagenes.IconoAlgoThief;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Juego.obtenerInstancia().empezarNuevaMision();
        stage.setTitle("-=  AlgoThief  =-");
        stage.setScene(new Escena());
        stage.setResizable(false);
        stage.getIcons().add(new IconoAlgoThief());
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

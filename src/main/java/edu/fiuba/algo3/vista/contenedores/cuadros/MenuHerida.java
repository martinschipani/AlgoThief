package edu.fiuba.algo3.vista.contenedores.cuadros;

import edu.fiuba.algo3.vista.botones.contextuales.BotonContinuar;
import edu.fiuba.algo3.vista.etiquetas.Etiqueta;
import javafx.scene.layout.VBox;

public class MenuHerida extends VBox{
    public MenuHerida(String mensaje){
        super(18);
        this.getChildren().addAll(new Etiqueta(mensaje), new BotonContinuar());
    }
}

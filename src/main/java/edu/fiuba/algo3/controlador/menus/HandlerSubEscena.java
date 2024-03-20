package edu.fiuba.algo3.controlador.menus;

import edu.fiuba.algo3.vista.SubEscenario;
import edu.fiuba.algo3.vista.contenedores.MensajeAbout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class HandlerSubEscena implements EventHandler<ActionEvent> {

    public abstract String getTitulo();

    public abstract String getInfo();

    @Override
    public void handle(ActionEvent actionEvent) {
        MensajeAbout mensajeAbout = new MensajeAbout(this.getInfo());
        SubEscenario subEscenario = new SubEscenario(this.getTitulo(), mensajeAbout);
        subEscenario.setOnHidden(e -> {
            mensajeAbout.terminarAnimacion(); // Para que no siga actualizándose ni reproduciendo sonidos.
        });
        subEscenario.show();
    }
}

package edu.fiuba.algo3.controlador.caracteristicas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.vista.contenedores.CuadroDialogo;
import javafx.event.ActionEvent;

public class HandlerCambiarCabello extends HandlerCambiarCaracteristica{
    public HandlerCambiarCabello(Caracteristica caracteristica){
        super(caracteristica);
        this.valoresPosibles.add("Negro");
        this.valoresPosibles.add("Pelirrojo");
        this.valoresPosibles.add("Rubio");
        this.valoresPosibles.add("Castaño");
    }

    @Override
    public void handle(ActionEvent actionEvent){
        int indiceSiguiente = valoresPosibles.indexOf(caracteristica.obtenerValor()) + 1;
        if(indiceSiguiente >= valoresPosibles.size())
            indiceSiguiente = 0;
        Juego.obtenerInstancia().obtenerComputadora().establecerCabello(valoresPosibles.get(indiceSiguiente));
        CuadroDialogo.obtenerInstancia().mostrarComputadora();
    }
}

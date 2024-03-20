package edu.fiuba.algo3.controlador.caracteristicas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.vista.contenedores.CuadroDialogo;
import javafx.event.ActionEvent;

public class HandlerCambiarHobby extends HandlerCambiarCaracteristica{
    public HandlerCambiarHobby(Caracteristica caracteristica){
        super(caracteristica);
        this.valoresPosibles.add("Alpinismo");
        this.valoresPosibles.add("Croquet");
        this.valoresPosibles.add("Tennis");
    }

    @Override
    public void handle(ActionEvent actionEvent){
        int indiceSiguiente = valoresPosibles.indexOf(caracteristica.obtenerValor()) + 1;
        if(indiceSiguiente >= valoresPosibles.size())
            indiceSiguiente = 0;
        Juego.obtenerInstancia().obtenerComputadora().establecerHobby(valoresPosibles.get(indiceSiguiente));
        CuadroDialogo.obtenerInstancia().mostrarComputadora();
    }
}

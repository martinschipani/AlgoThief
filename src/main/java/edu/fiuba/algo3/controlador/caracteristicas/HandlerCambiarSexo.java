package edu.fiuba.algo3.controlador.caracteristicas;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.vista.contenedores.CuadroDialogo;
import javafx.event.ActionEvent;

public class HandlerCambiarSexo extends HandlerCambiarCaracteristica{
    public HandlerCambiarSexo(Caracteristica caracteristica){
        super(caracteristica);
        this.valoresPosibles.add("Masculino");
        this.valoresPosibles.add("Femenino");
    }

    @Override
    public void handle(ActionEvent actionEvent){
        int indiceSiguiente = valoresPosibles.indexOf(caracteristica.obtenerValor()) + 1;
        if(indiceSiguiente >= valoresPosibles.size())
            indiceSiguiente = 0;
        Juego.obtenerInstancia().obtenerComputadora().establecerSexo(valoresPosibles.get(indiceSiguiente));
        CuadroDialogo.obtenerInstancia().mostrarComputadora();
    }
}

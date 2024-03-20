package edu.fiuba.algo3.controlador.caracteristicas;

import edu.fiuba.algo3.modelo.excepciones.TipoDeCaracteristicaInexistente;
import edu.fiuba.algo3.modelo.ladron.caracteristica.Caracteristica;
import edu.fiuba.algo3.modelo.ladron.caracteristica.TipoCaracteristica;

public class CreadorHandlerCaracteristica {
    private static CreadorHandlerCaracteristica instancia = null;

    private CreadorHandlerCaracteristica() {
        super();

    }

    public static void crearCreadorHandlerCaracteristica() {
        if (instancia == null) {
            instancia = new CreadorHandlerCaracteristica();
        }
    }

    public static CreadorHandlerCaracteristica obtenerInstancia() {
        if (instancia == null) {
            crearCreadorHandlerCaracteristica();
        }
        return instancia;
    }

    public HandlerCambiarCaracteristica crearHandler(Caracteristica caracteristica){
        if(caracteristica.obtenerTipo().equals(TipoCaracteristica.SEXO))
            return new HandlerCambiarSexo(caracteristica);
        else if(caracteristica.obtenerTipo().equals(TipoCaracteristica.HOBBY))
            return new HandlerCambiarHobby(caracteristica);
        else if(caracteristica.obtenerTipo().equals(TipoCaracteristica.CABELLO))
            return new HandlerCambiarCabello(caracteristica);
        else if(caracteristica.obtenerTipo().equals(TipoCaracteristica.SENIA))
            return new HandlerCambiarSenia(caracteristica);
        else if(caracteristica.obtenerTipo().equals(TipoCaracteristica.VEHICULO))
            return new HandlerCambiarVehiculo(caracteristica);
        else throw new TipoDeCaracteristicaInexistente("Caracteristica de tipo inválido.");
    }

}

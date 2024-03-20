package edu.fiuba.algo3.modelo.reloj;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.HorasInvalidas;

public class Reloj {

    protected Fecha fecha;
    protected final Fecha fechaLimite;

    public Reloj(){
        this.fecha = new Fecha(4, 7);
        this.fechaLimite = new Fecha(10, 17);
    }

    public void avanzarTiempo(int horas) throws HorasInvalidas {
        if (horas < 0) {
            throw new HorasInvalidas("Numero de horas negativo");
        }
        Fecha auxiliar = this.fecha.masHoras(0);
        this.fecha = this.fecha.masHoras(horas);
        if(auxiliar.conHora(22).esAntesDe(this.fecha)) {
            this.fecha = this.fecha.masHoras(8);
        }
        if(!verificarFechaLimite()){

            Juego.obtenerInstancia().tiempoAgotado();
        }
    }

    public boolean verificarFechaLimite(){
        return this.fecha.esAntesDe(fechaLimite);
    }

    public Fecha obtenerFecha() {
        return this.fecha;
    }
}

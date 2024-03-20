package edu.fiuba.algo3.modelo.reloj;

public class RelojFake extends Reloj{

    public RelojFake(){
        super();
    }

    @Override
    public void avanzarTiempo(int horas){
            Fecha auxiliar = this.fecha.masHoras(0);
            this.fecha = this.fecha.masHoras(horas);
            if(auxiliar.conHora(22).esAntesDe(this.fecha)) {
                this.fecha = this.fecha.masHoras(8);
            }

    }
}

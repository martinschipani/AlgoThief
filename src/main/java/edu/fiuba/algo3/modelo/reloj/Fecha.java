package edu.fiuba.algo3.modelo.reloj;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Fecha {

    private LocalDateTime fechaReal;

    public Fecha(int diaDelMes, int horaDelDia) {
        this.fechaReal = LocalDateTime.of(2021, 1, diaDelMes, horaDelDia, 0);
    }

    public Fecha(Fecha fechaOriginal) {
        this.fechaReal = fechaOriginal.fechaReal.plusHours(0);
    }

    public Fecha masHoras(int horas) {
        Fecha fecha = new Fecha(this);
        fecha.fechaReal = fecha.fechaReal.plusHours(horas);
        return fecha;
    }

    public Fecha conHora(int nuevaHora) {
        Fecha fecha = new Fecha(this);
        fecha.fechaReal = fecha.fechaReal.withHour(nuevaHora);
        return fecha;
    }

    public boolean esIgualA(Fecha otraFecha) {
        return this.fechaReal.isEqual(otraFecha.fechaReal);
    }

    public boolean esAntesDe(Fecha otrafecha) {
        return this.fechaReal.isBefore(otrafecha.fechaReal);
    }

    public String mostrar() {
        Locale localEsp = new Locale("es", "AR");
        Locale localEng = new Locale("en", "US");
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("EEEE h:mm", localEsp);
        DateTimeFormatter formatoMeridiano = DateTimeFormatter.ofPattern(" a", localEng);
        return this.fechaReal.format(formatoFecha) + this.fechaReal.format(formatoMeridiano);
    }
}

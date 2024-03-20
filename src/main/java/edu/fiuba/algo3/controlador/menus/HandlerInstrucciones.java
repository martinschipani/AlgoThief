package edu.fiuba.algo3.controlador.menus;

public class HandlerInstrucciones extends HandlerSubEscena {

    @Override
    public String getTitulo() {
        return "Instrucciones";
    }

    @Override
    public String getInfo() {
        return "-=\tINSTRUCCIONES\t=-\n" +
                "Tu meta es encontrar al ladrón antes del domingo a las 17:00 hs.\n" +
                "Debes ir de ciudad en ciudad investigando y preguntando por pistas\n" +
                "que te lleven al ladrón.\n" +
                "Cuando tengas suficientes pistas, puedes averiguar la siguiente ciudad\n" +
                "a la que ir, o bien deducir al sospechoso y emitir la orden de arresto.\n" +
                "Si te pasás de la fecha límite o te encontrás al ladrón sin una orden de\n" +
                "arresto, ¡El ladrón se va a escapar!\n" +
                "¡Suerte, detective!";
    }
}

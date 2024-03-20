package edu.fiuba.algo3.vista.imagenes.botones;

import edu.fiuba.algo3.vista.imagenes.VistaImagen;

public abstract class ImagenBoton extends VistaImagen {

    @Override
    public int getAncho() {
        return 75;
    }

    @Override
    public int getAlto() {
        return 45;
    }
}

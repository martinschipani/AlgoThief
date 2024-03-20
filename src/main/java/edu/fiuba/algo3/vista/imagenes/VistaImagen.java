package edu.fiuba.algo3.vista.imagenes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class VistaImagen extends ImageView {

    public abstract int getAncho();

    public abstract int getAlto();

    public abstract String getDirectorioImagen();

    public VistaImagen() {
        super();
        this.setImage(new Image(this.getDirectorioImagen(),
                      this.getAncho(),
                      this.getAlto(),
                      false,
                      false));
    }

    public VistaImagen(String directorioImagen) {
        super();
        this.setImage(new Image(directorioImagen,
                this.getAncho(),
                this.getAlto(),
                false,
                false));
    }
}

package edu.fiuba.algo3.vista.imagenes.ciudades;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenCiudad extends ImageView {

    public ImagenCiudad(String nombreImagen) {
        super();
        this.setImage(new Image(this.getDirectorioImagen(nombreImagen),
                300,
                300,
                false,
                false));
    }

    public String getDirectorioImagen(String nombreImagen) {
        String directorioReal = "file:media/img/ciudades/" + nombreImagen + ".png";
        return directorioReal;
    }
}

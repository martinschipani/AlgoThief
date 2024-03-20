package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.contenedores.LocacionYFecha;
import edu.fiuba.algo3.vista.imagenes.ciudades.ImagenCiudad;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;

public class CajaLugarYFecha extends VBox {
    private static CajaLugarYFecha instancia = null;

    private CajaLugarYFecha() {
        super(5);
        this.setPadding(new Insets(1.5));
        this.setAlignment(Pos.CENTER_LEFT);
    }

    private ImagenCiudad conseguirImagenCiudad(Ciudad ciudad) {
        String nombreImagen = ciudad.obtenerNombre().replace(" ", "").toLowerCase();
        return new ImagenCiudad(nombreImagen);
    }

    public static CajaLugarYFecha obtenerInstancia() {
        if (instancia == null) {
            instancia = new CajaLugarYFecha();
        }
        return instancia;
    }

    public CajaLugarYFecha mostrarLugarYTiempo(){
        this.getChildren().setAll(LocacionYFecha.obtenerInstancia().mostrarLugarYTiempo(),
                                this.conseguirImagenCiudad(Juego.obtenerInstancia().ciudadActual()));
        return instancia;
    }

    public CajaLugarYFecha mostrarCuartelGeneral() {
        String subPathCuartelGeneral = "cuartelGeneral/cuartelgeneral";
        this.getChildren().setAll(LocacionYFecha.obtenerInstancia().mostrarCuartelGeneral(),
                new ImagenCiudad(subPathCuartelGeneral));
        AudioClip audioClip = new AudioClip("file:media/sfx/cuartelGeneral.mp3");
        audioClip.play(0.25);
        return instancia;
    }
}

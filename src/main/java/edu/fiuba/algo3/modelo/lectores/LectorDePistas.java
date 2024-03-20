package edu.fiuba.algo3.modelo.lectores;

import edu.fiuba.algo3.modelo.pistas.PistasDeCiudad;
import edu.fiuba.algo3.modelo.pistas.PistasDeEdificio;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LectorDePistas {

    final private String filePath;

    public LectorDePistas(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, PistasDeCiudad> cargarPistas() {
        Map<String, PistasDeCiudad> contenedorDePistas = new HashMap<>();
        try {
            FileReader reader = new FileReader(this.filePath);
            JSONParser mapParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) mapParser.parse(reader);

            JSONObject pistas = (JSONObject) jsonObject.get("pistas");

            pistas.keySet().forEach(dificultad -> {
                Map<String, PistasDeEdificio> pistasDeCiudad = new HashMap<>();
                JSONObject pistasPorCiudad = (JSONObject) pistas.get(dificultad);

                pistasPorCiudad.keySet().forEach(ciudad -> {
                    Map<String, String> pistasDeEdificio = new HashMap<>();
                    JSONObject pistasPorEdificio = (JSONObject) pistasPorCiudad.get(ciudad);

                    pistasPorEdificio.keySet().forEach(edificio -> {
                        pistasDeEdificio.put(edificio.toString(), pistasPorEdificio.get(edificio).toString());
                    });

                    pistasDeCiudad.put(ciudad.toString(), new PistasDeEdificio(pistasDeEdificio));
                });

                contenedorDePistas.put(dificultad.toString(), new PistasDeCiudad(pistasDeCiudad));
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return contenedorDePistas;
    }
}

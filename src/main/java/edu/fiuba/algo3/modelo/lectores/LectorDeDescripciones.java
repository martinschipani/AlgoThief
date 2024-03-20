package edu.fiuba.algo3.modelo.lectores;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LectorDeDescripciones {

    final private String filePath;

    public LectorDeDescripciones(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, String> cargarDescripciones() {
        Map<String, String> descripciones = new HashMap<>();
        try {
            FileReader reader = new FileReader(this.filePath);
            JSONParser mapParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) mapParser.parse(reader);
            JSONObject descripcionesJSON = (JSONObject) jsonObject.get("descripciones");

            descripcionesJSON.keySet().forEach(element -> {
                descripciones.put(element.toString(), descripcionesJSON.get(element).toString());
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return descripciones;
    }
}

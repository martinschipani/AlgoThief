package edu.fiuba.algo3.modelo.lectores;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LectorDeTesoros {

    private String filePath;

    public LectorDeTesoros(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, String> cargarTesoros() {
        Map<String, String> tesoros = new HashMap<>();
        try {
            FileReader reader = new FileReader(this.filePath);
            JSONParser mapParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) mapParser.parse(reader);
            JSONObject tesorosJSON = (JSONObject) jsonObject.get("tesoros");

            tesorosJSON.keySet().forEach(element -> {
                tesoros.put(element.toString(), tesorosJSON.get(element).toString());
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tesoros;
    }
}

package edu.fiuba.algo3.modelo.lectores;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LectorDePistasLadron {

    private String filePath;

    public LectorDePistasLadron(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, String> cargarPistasLadron() {
        Map<String, String> pistasLadron = new HashMap<>();
        try {
            FileReader reader = new FileReader(this.filePath);
            JSONParser mapParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) mapParser.parse(reader);
            JSONObject pistasLadronJSON = (JSONObject) jsonObject.get("pistasLadron");

            pistasLadronJSON.keySet().forEach(element -> {
                pistasLadron.put(element.toString(), pistasLadronJSON.get(element).toString());
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pistasLadron;
    }
}

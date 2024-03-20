package edu.fiuba.algo3.modelo.lectores;

import edu.fiuba.algo3.modelo.computadora.Computadora;
import edu.fiuba.algo3.modelo.ladron.Ladron;
import edu.fiuba.algo3.modelo.ladron.Sospechoso;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class LectorDeLadrones {

    final private String filePath;

    public LectorDeLadrones (String filePath) {
        this.filePath = filePath;
    }

    public void cargarLadrones(Computadora computadora) {
        try {
            FileReader reader = new FileReader(this.filePath);
            JSONParser mapParser = new JSONParser();
            JSONArray ladronesArray = (JSONArray) mapParser.parse(reader);

            ladronesArray.forEach(element -> {
                JSONObject ladronJSON = (JSONObject) element;
                Ladron ladron = new Sospechoso();

                ladron.establecerNombre(ladronJSON.get("Nombre").toString());
                ladron.establecerSexo(ladronJSON.get("Sexo").toString());
                ladron.establecerHobby(ladronJSON.get("Hobby").toString());
                ladron.establecerCabello(ladronJSON.get("Cabello").toString());
                ladron.establecerSenia(ladronJSON.get("Senia").toString());
                ladron.establecerVehiculo(ladronJSON.get("Auto").toString());

                computadora.agregarLadron(ladron);
            });

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

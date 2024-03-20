package edu.fiuba.algo3.modelo.lectores;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Edificio;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LectorDeMapa {

    final private String filePath;

    public LectorDeMapa(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, Map<String, Integer>> cargarDistancias() {
        final Map<String, Map<String, Integer>> distancias = new HashMap<>();
        try {
            FileReader reader = new FileReader(this.filePath);
            JSONParser mapParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) mapParser.parse(reader);

            JSONObject ciudadesOrigenJSON = (JSONObject) jsonObject.get("distanciasCiudades");

            ciudadesOrigenJSON.keySet().forEach(ciudadOrigen -> {
                JSONObject ciudadDestinoJSON = (JSONObject) ciudadesOrigenJSON.get(ciudadOrigen);

                Map<String, Integer> ciudadMap = new HashMap<>();
                ciudadDestinoJSON.keySet().forEach(ciudadDestino -> {
                    ciudadMap.put(ciudadDestino.toString(), Integer.parseInt(ciudadDestinoJSON.get(ciudadDestino).toString()));
                });
                distancias.put(ciudadOrigen.toString(), ciudadMap);
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return distancias;
    }

    public ArrayList<Ciudad> cargarCiudades() {
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        try {
            FileReader reader = new FileReader(this.filePath);
            JSONParser mapParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) mapParser.parse(reader);

            JSONObject ciudadesOrigenJSON = (JSONObject) jsonObject.get("distanciasCiudades");

            ciudadesOrigenJSON.keySet().forEach(ciudadOrigen -> {
                Ciudad origen = new Ciudad(ciudadOrigen.toString());
                cargarEdificios(origen);
                ciudades.add(origen);
            });

            for (Ciudad origen : ciudades) {
                JSONObject ciudadOrigenJSON = (JSONObject) ciudadesOrigenJSON.get(origen.obtenerNombre());
                for (Ciudad destino : ciudades) {
                    if (ciudadOrigenJSON.get(destino.obtenerNombre()) != null) {
                        origen.agregarRutaDeVuelo(destino);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ciudades;
    }

    private void cargarEdificios(Ciudad ciudad) {
        Random random = new Random(System.nanoTime());
        if (random.nextFloat() < 0.5) {
            ciudad.agregarEdificio(new Edificio("Banco", "Financiero"));
        } else {
            ciudad.agregarEdificio(new Edificio("Bolsa", "Financiero"));
        }

        ciudad.agregarEdificio(new Edificio("Biblioteca", "Biblioteca"));

        if (random.nextFloat() < 0.5){
            ciudad.agregarEdificio(new Edificio("Aeropuerto", "Transporte"));
        } else {
            ciudad.agregarEdificio(new Edificio("Puerto", "Transporte"));
        }
    }

    public Map<String,ArrayList<String>> cargarAdyacencias() {
        Map<String,ArrayList<String>> adyacencias = new HashMap<>();
        try {
            FileReader reader = new FileReader(this.filePath);
            JSONParser mapParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) mapParser.parse(reader);

            JSONObject ciudadesOrigenJSON = (JSONObject) jsonObject.get("distanciasCiudades");

            ciudadesOrigenJSON.keySet().forEach(ciudadOrigen -> {
                JSONObject ciudadDestinoJSON = (JSONObject) ciudadesOrigenJSON.get(ciudadOrigen);
                ArrayList<String> adyacenciasCiudad = new ArrayList<>();

                ciudadDestinoJSON.keySet().forEach(ciudadDestino -> {
                    adyacenciasCiudad.add(ciudadDestino.toString());
                });

                adyacencias.put(ciudadOrigen.toString(), adyacenciasCiudad);
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return adyacencias;
    }
}

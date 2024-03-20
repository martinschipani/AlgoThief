package edu.fiuba.algo3.modelo.computadora;

import edu.fiuba.algo3.modelo.computadora.ordenesDeArresto.OrdenDeArresto;
import edu.fiuba.algo3.modelo.computadora.ordenesDeArresto.OrdenInvalida;
import edu.fiuba.algo3.modelo.computadora.ordenesDeArresto.OrdenValida;
import edu.fiuba.algo3.modelo.ladron.Ladron;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class BaseDeDatos {
    
    private ArrayList<Ladron> listaLadrones;

    public BaseDeDatos(){
        this.listaLadrones = new ArrayList<Ladron>();
    }

    private boolean buscarLadronIdentico(Ladron ladronBuscado)
    {
        long cantidadSospechosos =  this.listaLadrones.stream().filter(elemento->elemento.esIgualA(ladronBuscado)).count();
        return cantidadSospechosos > 0;
    }

    public OrdenDeArresto buscarLadron(Ladron ladronBuscado)
    {
        Stream<Ladron> listaFiltrada =  this.listaLadrones.stream().filter(elemento->elemento.esSimilarA(ladronBuscado));
        
        long cantidadDeCoincidencias = listaFiltrada.count();
        listaFiltrada =  this.listaLadrones.stream().filter(elemento->elemento.esSimilarA(ladronBuscado));

        if(cantidadDeCoincidencias == 1){
            return new OrdenValida(listaFiltrada.findFirst().get());
        }
        return new OrdenInvalida();
    }

    public void agregarLadron(Ladron ladronBuscado)
    {
        if(!buscarLadronIdentico(ladronBuscado))
            this.listaLadrones.add(ladronBuscado);
    }

    public Ladron obtenerLadronRandom()
    {
        Random random = new Random(System.nanoTime());
        return listaLadrones.get(random.nextInt(listaLadrones.size()));
    }
}

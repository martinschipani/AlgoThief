package edu.fiuba.algo3.modelo.ladron.caracteristica;

public class Caracteristica {

    private TipoCaracteristica tipo;
    private String valor;

    Caracteristica()
    {
        this.tipo = TipoCaracteristica.SIN_CARACTERISTICA;
        this.valor = "";
    }

    public Caracteristica(TipoCaracteristica tipo)
    {
        this.tipo = tipo;
        this.valor = "";
    }

    public Caracteristica(TipoCaracteristica tipo, String valor)
    {
        this.tipo = tipo;
        this.valor = valor;
    }

    public void establecerTipo(TipoCaracteristica tipo)
    {
        this.tipo = tipo;
    }

    public void establecerValor(String valor)
    {
        this.valor = valor;
    }

    public boolean compararTipo(Caracteristica caracteristicaAComparar)
    {
        return (this.tipo == (caracteristicaAComparar.tipo));
    }

    public boolean compararValor(Caracteristica caracteristicaAComparar)
    {
        return (this.valor.equalsIgnoreCase(caracteristicaAComparar.valor));
    }

    public boolean valorEsNulo()
    {
        return (this.valor.length() == 0);
    }

    public boolean compararManeraExacta(Caracteristica caracteristicaAComparar)
    {
        return (compararTipo(caracteristicaAComparar) && compararValor(caracteristicaAComparar));
    }

    public boolean esUna(Caracteristica caracteristicaAComparar)
    {
        boolean esSimilar = false;

        if(compararTipo(caracteristicaAComparar))
        {
            if(compararValor(caracteristicaAComparar) || caracteristicaAComparar.valorEsNulo())
            {
                esSimilar = true;
            }
        }

        return esSimilar;
    }

    public TipoCaracteristica obtenerTipo(){
        return this.tipo;
    }

    public String obtenerNombreTipo() {
        return this.tipo.name();
    }

    public String obtenerValor(){
        return this.valor;
    }

}

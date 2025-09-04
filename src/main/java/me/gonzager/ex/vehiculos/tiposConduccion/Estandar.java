package me.gonzager.ex.vehiculos.tiposConduccion;

public class Estandar implements TipoConduccion{

    private static final TipoConduccion instance = new Estandar();

    public Estandar(){}

    @Override
    public Double consumo() {
        return 10.0;
    }

    @Override
    public Double velocidadMaxima() {
        return 150.0;
    }

    @Override
    public TipoConduccion siguiente() {
        return Deportiva.getInstance();
    }

    @Override
    public TipoConduccion anterior() {
        return Ecologica.getInstance();
    }

    public static TipoConduccion getInstance() {
        return instance;
    }

}
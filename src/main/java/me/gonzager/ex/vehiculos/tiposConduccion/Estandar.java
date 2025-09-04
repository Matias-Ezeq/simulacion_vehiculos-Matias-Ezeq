package me.gonzager.ex.vehiculos.tiposConduccion;

public class Estandar implements TipoConduccion{

    private static final TipoConduccion instance = new Estandar();

    public Estandar(){}

    @Override
    public Integer consumo() {
        return 10;
    }

    @Override
    public Integer velocidadMaxima() {
        return 150;
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
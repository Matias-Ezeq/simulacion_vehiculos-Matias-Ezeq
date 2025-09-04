package me.gonzager.ex.vehiculos.tiposConduccion;

public class Deportiva implements TipoConduccion{

    private static final TipoConduccion instance = new Deportiva();

    public Deportiva(){}

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
        return Estandar.getInstance();
    }

    public static TipoConduccion getInstance() {
        return instance;
    }

}


package me.gonzager.ex.vehiculos.tiposConduccion;

public class Deportiva implements TipoConduccion{

    private static final TipoConduccion instance = new Deportiva();

    public Deportiva(){}

    @Override
    public Integer consumo() {
        return 5;
    }

    @Override
    public Integer velocidadMaxima() {
        return 200;
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


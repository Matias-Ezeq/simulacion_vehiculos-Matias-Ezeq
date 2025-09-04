package me.gonzager.ex.vehiculos.tiposConduccion;

public class Ecologica implements TipoConduccion{

    private static final TipoConduccion instance = new Ecologica();

    public Ecologica(){}

    @Override
    public Integer consumo() {
        return 16;
    }

    @Override
    public Integer velocidadMaxima() {
        return 120;
    }

    @Override
    public TipoConduccion siguiente() {
        return Estandar.getInstance();
    }

    @Override
    public TipoConduccion anterior() {
        return Ecologica.getInstance();
    }

    public static TipoConduccion getInstance() {
        return instance;
    }

}
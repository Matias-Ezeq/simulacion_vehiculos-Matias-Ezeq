package me.gonzager.ex.vehiculos.tiposConduccion;

public interface TipoConduccion {
    Integer consumo();
    Integer velocidadMaxima();
    TipoConduccion siguiente();
    TipoConduccion anterior();
}

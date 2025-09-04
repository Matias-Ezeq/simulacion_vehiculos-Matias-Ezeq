package me.gonzager.ex.vehiculos.tiposConduccion;

public interface TipoConduccion {
    Double consumo();
    Double velocidadMaxima();
    TipoConduccion siguiente();
    TipoConduccion anterior();
}

package me.gonzager.ex.vehiculos;

import me.gonzager.ex.vehiculos.tiposConduccion.Ecologica;
import me.gonzager.ex.vehiculos.tiposConduccion.TipoConduccion;

public class Vehiculo {
    private Integer combustible;
    private Integer kilometraje = 0;
    private TipoConduccion tipoConduccion = Ecologica.getInstance();
    private final Integer consumo = tipoConduccion.consumo();
    private final Integer velocidadMaxima = tipoConduccion.velocidadMaxima();
    
    public Vehiculo(Integer combustible) {
        if (combustible < 0) {
            throw new RuntimeException("la cantidad de combustible no puede ser negativa");
        }
        this.combustible = combustible;
    }

    public Integer getCombustible() {
        return combustible;
    }

    public Integer getKilometraje() {
        return kilometraje;
    }

    public TipoConduccion getTipoConduccion() {
        return tipoConduccion;
    }

    public void cargarCombustible(Integer litros) {
        combustible = combustible + litros;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public Integer getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void avanzarTipoConduccion() {
        tipoConduccion = tipoConduccion.siguiente();
    }

     public void retrocederTipoConduccion() {
        tipoConduccion = tipoConduccion.anterior();
    }

    public void avanzar(Integer kilometros) {
        Integer distanciaMaximaPosible = combustible / consumo;
        if (kilometros > distanciaMaximaPosible) {
            avanzar(distanciaMaximaPosible); //recorre hasta donde de la nafta
            throw new RuntimeException("Combustible insuficiente, solo pude recorrer " + distanciaMaximaPosible + " del total de " + kilometros + " kilometros");
        }
        else {
            combustible -= consumo * kilometros;
            kilometraje += kilometros;
        }
    }
}

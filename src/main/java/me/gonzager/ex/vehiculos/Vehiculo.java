package me.gonzager.ex.vehiculos;

import me.gonzager.ex.vehiculos.tiposConduccion.Ecologica;
import me.gonzager.ex.vehiculos.tiposConduccion.TipoConduccion;

public class Vehiculo {
    private Double combustible;
    private Double kilometraje = 0.0;
    private TipoConduccion tipoConduccion = Ecologica.getInstance();
    private final Double consumo = tipoConduccion.consumo();
    private final Double velocidadMaxima = tipoConduccion.velocidadMaxima();
    
    public Vehiculo(Double combustible) {
        this.combustible = combustible;
    }

    public Double getCombustible() {
        return combustible;
    }

    public Double getKilometraje() {
        return kilometraje;
    }

    public TipoConduccion getTipoConduccion() {
        return tipoConduccion;
    }

    public void cargarCombustible(Double litros) {
        combustible = combustible + litros;
    }

    public Double getConsumo() {
        return consumo;
    }

    public Double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void avanzarTipoConduccion() {
        tipoConduccion = tipoConduccion.siguiente();
    }

     public void retrocederTipoConduccion() {
        tipoConduccion = tipoConduccion.anterior();
    }

    public void avanzar(Double kilometros) {
        Double distanciaMaximaPosible = combustible / consumo;
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

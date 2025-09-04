package me.gonzager.ex.vehiculos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class VehiculoTest {

    @Test
    void vehículoRetrocediendoYAvanzandoTiposDeConduccionDeberíaRetornarCorrectamenteLaVelocidad() {
        //Crear un vehículo con 3 Litros de combustible.
        Vehiculo vehiculo = new Vehiculo(3);
        
        //Retroceder el tipo de conducción una vez.
        vehiculo.retrocederTipoConduccion();
        
        //Avanzar el tipo de conduccion 3 veces.
        vehiculo.avanzarTipoConduccion();
        vehiculo.avanzarTipoConduccion();
        vehiculo.avanzarTipoConduccion();

        //Retroceder el tipo de conducción una vez.
        vehiculo.retrocederTipoConduccion();

        //Verificar que la velocidad máxima del auto es de 150 km/h.
        assertEquals(150, vehiculo.getVelocidadMaxima());
    }

    @Test
    void vehículoEnConduccionEstandarDeberíaAvanzarCorrectamenteYReducirElCombustible() {
        //Crear un vehículo con 25 Litros de combustible.
        Vehiculo vehiculo = new Vehiculo(25);

        //Cambiar una vez el tipo de conducción.
        vehiculo.avanzarTipoConduccion();

        //Desplazar 200 kilómetros.
        vehiculo.avanzar(200);

        //Verificar que el auto queden con 200.0 kilomentros y con 5.0 litros de combustible.
        assertEquals(200, vehiculo.getKilometraje());
        assertEquals(5, vehiculo.getCombustible());
    }

    @Test
    void vehiculoEnConduccionDeportivaDeberíaLanzarUnaExcepcionSiNoHaySuficienteCombustible() {
        //Crear un vehículo con 13 Litros de combustible.
        Vehiculo vehiculo = new Vehiculo(13);

        //Cambiar dos veces el tipo de conducción.
        vehiculo.avanzarTipoConduccion();
        vehiculo.avanzarTipoConduccion();

        //Desplazar 75 kilómetros.
        vehiculo.avanzar(75);

        //Verificar que se produjo la RuntimeException "Combustible insuficiente, solo pude recorrer 65 del total de 75.0 kilometros." y que el auto queden con 65.0 kilomentros y con 0.0 litros de combustible.
        //consultar como verificar excepciones
        //assertThrows(RuntimeException.class, "Combustible insuficiente, solo pude recorrer 65 del total de 75 kilometros.");
        assertEquals(65, vehiculo.getKilometraje());
        assertEquals(0, vehiculo.getCombustible());
    }

    @Test
    void valorDeCombustibleMenorACeroAlCrearVehiculoLanzaExcepcion() {
        //Crear un vehículo con -10 Litros de combustible.
        Vehiculo vehiculo = new Vehiculo(-10);
        
        //Verificar que se produjo la RuntimeException "La cantidad de combustible no puede ser negativa.".
        //consultar excepciones
    }

    @Test
    void velocidadMaximaDiferenteSegunTipoDeConduccion() {
        //Crear un vehículo con 10 Litros de combustible.
        Vehiculo vehiculo = new Vehiculo(10);
        
        //Guardar en una variable el valor de la velocidad máxima ecológica.
        Integer velMaxEconomica = vehiculo.getVelocidadMaxima();
        
        //Avanzar el tipo de conducción.
        vehiculo.avanzarTipoConduccion();
        
        //Guardar en una variable el valor de la velocidad máxima estándar.
        Integer velMaxEstandar = vehiculo.getVelocidadMaxima();
        
        //Avanzar el tipo de conducción.
        vehiculo.avanzarTipoConduccion();
        
        //Guardar en una variable el valor de la velocidad máxima deportiva.
        Integer velMaxDeportiva = vehiculo.getVelocidadMaxima();
        
        //Verificar que la velocidad máxima ecológica es menor que la velocidad máxima estándar.
        assertTrue(velMaxEconomica < velMaxEstandar);
        
        //Verificar que la velocidad máxima estándar no es mayor que la velocidad máxima deportiva.
        assertFalse(velMaxEstandar > velMaxDeportiva);
        
        //Verificar que la velocidad máxima estándar no es igual que la velocidad máxima deportiva.
        assertNotEquals(velMaxEstandar, velMaxDeportiva);
    }
}

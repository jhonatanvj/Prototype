/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import Interface.Vehiculos;
import Vehiculos.Automovil;
import Vehiculos.Motocicleta;

/**
 *
 * @author jhona
 */
public class SingletonVehiculoFactory {
    private static SingletonVehiculoFactory instancia;

    private SingletonVehiculoFactory() {
        // Constructor privado para evitar la creación de nuevas instancias
    }

    public static SingletonVehiculoFactory getInstancia() {
        if (instancia == null) {
            instancia = new SingletonVehiculoFactory();
        }
        return instancia;
    }

    public Vehiculos crearVehiculo(String tipoVehiculo) {
        if (tipoVehiculo.equalsIgnoreCase("Automovil")) {
            Automovil auto = new Automovil();
            auto.setNombre("Automóvil");
            auto.setColor("Rojo");
            auto.setVelocidadMaxima(180);
            return auto;
        } else if (tipoVehiculo.equalsIgnoreCase("Motocicleta")) {
            Motocicleta moto = new Motocicleta();
            moto.setNombre("Motocicleta");
            moto.setColor("Azul");
            moto.setVelocidadMaxima(220);
            return moto;
        }
        return null;
    }
}

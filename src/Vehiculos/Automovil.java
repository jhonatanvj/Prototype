/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

import Interface.Vehiculos;

public class Automovil implements Vehiculos {
    private String nombre;
    private String color;
    private int velocidadMaxima;

    public Automovil() {        
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setVelocidadMaxima(int velocidad) {
        this.velocidadMaxima = velocidad;
    }

    @Override
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    @Override
    public Vehiculos clonar() {
        Automovil clon = new Automovil();
        clon.setNombre(this.nombre);
        clon.setColor(this.color);
        clon.setVelocidadMaxima(this.velocidadMaxima);
        return clon;
    }

    @Override
    public String mostrarDatos() {
        return "Automóvil: " + nombre + ", Color: " + color + ", Velocidad Máxima: " + velocidadMaxima + " km/h";
    }
}
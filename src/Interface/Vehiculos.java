/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

/**
 *
 * @author jhona
 */
public interface Vehiculos {
    public void setNombre(String nombre);
    public String getNombre();
    public void setColor(String color);
    public String getColor();
    public void setVelocidadMaxima(int velocidad);
    public int getVelocidadMaxima();
    public Vehiculos clonar();
    public String mostrarDatos();
}


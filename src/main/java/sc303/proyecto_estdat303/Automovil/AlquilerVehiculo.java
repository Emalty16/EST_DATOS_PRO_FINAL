/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sc303.proyecto_estdat303.Automovil;

public class AlquilerVehiculo 
{
    private int id;
   
    private int pasajeros;
    
    private String marca;
    
    private String extras;

    private int dias;
     
    public AlquilerVehiculo(int id, int dias, int pasajeros, String marca, String extras) {
        
        this.id = id;
        
        this.pasajeros = pasajeros;
        
        this.marca = marca;
        
        this.extras = extras;
        
        this.dias = dias;
    }


    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
   

}

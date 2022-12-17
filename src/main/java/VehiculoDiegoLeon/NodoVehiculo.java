/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VehiculoDiegoLeon;


public class NodoVehiculo {

 private String Placa;
 
 private String Cilindro;
 
 private String MarcaAutomovil;
 
 private String modelo;
 
 private int capacidad;
 
 private int año;
 
 private String combustible;
 
 private int alquiler;
 
 private String color;
 
 private String extras;
 
 private NodoVehiculo next;

    public NodoVehiculo(String Placa, String cilindro, String marca, String combustible, String modelo, int capacidad, int año, int alquiler, String color, String extras) {
        this.Placa = Placa;
        this.Cilindro = cilindro;
        this.MarcaAutomovil = marca;
        this.combustible = combustible;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.año = año;
        this.alquiler = alquiler;
        this.color = color;
        this.extras = extras;
    }

    
    
    public NodoVehiculo() {
        
    }

    

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getCilindro() {
        return Cilindro;
    }

    public void setCilindro(String Cilindro) {
        this.Cilindro = Cilindro;
    }

    public String getMarcaAutomovil() {
        return MarcaAutomovil;
    }

    public void setMarcaAutomovil(String MarcaAutomovil) {
        this.MarcaAutomovil = MarcaAutomovil;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public NodoVehiculo getNext() {
        return next;
    }

    public void setNext(NodoVehiculo next) {
        this.next = next;
    }

  

}

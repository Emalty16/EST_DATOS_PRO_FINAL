/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VehiculoDiegoLeon;

public class NodoGeneral {
    
    private AlquilerVehiculo informacion;
    private NodoGeneral next;
    private NodoGeneral back;

    public NodoGeneral(AlquilerVehiculo informacion) 
    
    {
        this.informacion = informacion;
    }

    public AlquilerVehiculo getInformacion() 
    {
        return informacion;
    }

    public void setInformacion(AlquilerVehiculo informacion) 
    {
        this.informacion = informacion;
    }

    public NodoGeneral getNext() 
    {
        return next;
    }

    public void setNext(NodoGeneral next) 
    {
        this.next = next;
    }

    public NodoGeneral getBack() 
    {
        return back;
    }

    public void setBack(NodoGeneral back)
    {
        this.back = back;
    }
      
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sc303.proyecto_estdat303.Clientes;

import RentCar_Proyecto.Clientes.Clientes;


public class NodoClientes {
    
    private Clientes informacion;
    private NodoClientes next;
    private NodoClientes back;
    
    @Override
    public String toString(){
        return "NodeCliente{" + "datos=" + informacion + '}';
    }

   public NodoClientes(Clientes informacion) 
   {
        this.informacion = informacion;
    }
   
   public NodoClientes() 
   {
        
    }

    public Clientes getInformacion() 
    {
        return informacion;
    }

    public void setInformacion(Clientes informacion) 
    {
        this.informacion = informacion;
    }

    public NodoClientes getNext() 
    {
        return next;
    }

    public void setNext(NodoClientes next)
    {
        this.next = next;
    }

    public NodoClientes getBack() 
    {
        return back;
    }

    public void setBack(NodoClientes back)
    {
        this.back = back;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

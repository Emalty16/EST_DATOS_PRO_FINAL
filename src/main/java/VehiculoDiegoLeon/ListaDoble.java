/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VehiculoDiegoLeon;

public class ListaDoble {

    private NodoGeneral cabeza;
    private NodoGeneral cola;

    public ListaDoble(NodoGeneral cabeza, NodoGeneral cola) {
        this.cabeza = cabeza;
        this.cola = cola;
    }

    public ListaDoble() {
        
    }

    public void AgregarListaDoble(AlquilerVehiculo c) {

        if (cabeza == null) 
        {
            
            cabeza = new NodoGeneral(c);
            
            cola = cabeza;
            
            cola.setNext(cabeza);
            
            cabeza.setBack(cola);

        }
        
        else if (c.getId() < cabeza.getInformacion().getId()) 
        {
          NodoGeneral aux = new NodoGeneral(c);
          aux.setNext(cabeza);
          cabeza = aux;
          cola.setNext(cabeza);
          cabeza.setBack(cola);

        } else if (cola.getInformacion().getId() <= c.getId()) 
        {

          cola.setNext(new NodoGeneral(c));
          cola = cola.getNext();
          cola.setNext(cabeza);
          cabeza.setBack(cola);

        } else 
        {
            NodoGeneral aux = cabeza;

            while (aux.getInformacion().getId() < c.getId()) 
            {
                aux = aux.getNext();
            }
            
            NodoGeneral tem = new NodoGeneral(c);
            tem.setNext(aux.getNext());
            tem.setBack(aux);
            aux.setNext(tem);
            tem.getNext().setBack(tem);
        }

    }

    
    public void MostrarListaDoble() {

        NodoGeneral aux = cabeza;
        if (cabeza != null) 
        {

        do 
        {
            
     System.out.println(aux.getInformacion().getId() + "" + aux.getInformacion().getDias() + "" + aux.getInformacion().getMarca() + "" + aux.getInformacion().getPasajeros() + "" + aux.getInformacion().getExtras());
     aux = aux.getNext();

            } while (aux != cabeza);

        }

    }

}

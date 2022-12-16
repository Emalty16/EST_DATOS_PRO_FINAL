/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sc303.proyecto_estdat303.Clientes;


public class ListaSimple {

    private NodoClientes cabeza;
    private NodoClientes cola;

    public ListaSimple(NodoClientes cabeza, NodoClientes cola) {
        this.cabeza = cabeza;
        this.cola = cola;
    }

    public ListaSimple() {

    }

    public void insertar(Clientes C) {
    NodoClientes nuevoNodo = new NodoClientes(C);
    if (cabeza == null) {

    cabeza = nuevoNodo;

    }
    else if (cabeza.getInformacion().getNumeroDeCedula() > nuevoNodo.getInformacion().getNumeroDeCedula()) 
    {
              cabeza = nuevoNodo;

    } 
    else if (cabeza.getInformacion().getNumeroDeCedula() < nuevoNodo.getInformacion().getNumeroDeCedula() && cabeza.getNext() == null) {
      cabeza.setNext(nuevoNodo);

    } 
    else 
    {

    NodoClientes aux = cabeza;
    while (aux.getNext() != null && aux.getNext().getInformacion().getNumeroDeCedula() < nuevoNodo.getInformacion().getNumeroDeCedula()) {
    aux = aux.getNext();

     }
    
    nuevoNodo.setNext(aux.getNext());
   aux.setNext(nuevoNodo);

        }

    }

    public void imprimirLista() {
        NodoClientes aux = cabeza;
        while (aux != null) {

            System.out.print(" " + String.valueOf(aux.getInformacion().getNumeroDeCedula()) + "-" + aux.getInformacion().getNombreCliente() + "-" + aux.getInformacion().getFechaNacimiento() + "-" + aux.getInformacion().getCorreoElectronico() + "-" + String.valueOf(aux.getInformacion().getCategoria())+"\n");
            InterfazClientes i = new InterfazClientes();

            aux = aux.getNext();

        }

    }

    private void modificar(Clientes c) {
        
        NodoClientes actual = new NodoClientes(c);
        actual = cabeza;
        boolean encontrado = false;

        int buscar = c.getNumeroDeCedula();

        if (cabeza != null) {
            while (actual != null) {
                if (actual.getInformacion().getNumeroDeCedula() == buscar) {
                    encontrado = true;
                    System.out.print("nodo encontrado");
                    actual.getInformacion().setNombreCliente(c.getNombreCliente());
                    actual.getInformacion().setFechaNacimiento(c.getFechaNacimiento());
                    actual.getInformacion().setNombreCliente(c.getCorreoElectronico());

                    actual.getInformacion().setCategoria(c.getCategoria());
                    System.out.print(c.getNombreCliente());
                }
                actual = actual.getNext();
            }
            System.out.print("NO ENTRA");

        }

    }

   

    public void eliminar(int id) {

    if (cabeza != null) 
    {
    if (cabeza.getInformacion().getNumeroDeCedula() == id) 
    {
    cabeza = cabeza.getNext();
            } 
    else 
    {
     NodoClientes aux = cabeza;

     while (aux.getNext() != null && aux.getNext().getInformacion().getNumeroDeCedula() < id) {
     aux = aux.getNext();
     }

      if (aux.getNext() != null && aux.getNext().getInformacion().getNumeroDeCedula() == id) {
      aux.setNext(aux.getNext().getNext());
       }
   }

   }

    }

    public void Rango(int a, int h) {

        NodoClientes actual = new NodoClientes();
        
        actual = cabeza;
        boolean encontrado = false;

        if (cabeza != null) 
        {
    while (actual != null) 
    {
     if (actual.getInformacion().getNumeroDeCedula() == h) 
     {
    encontrado = true;
     System.out.print("nodo encontrado");
     if (a > 30) {
     System.out.print("entro deberia de subir rango");
     actual.getInformacion().setCategoria(actual.getInformacion().getCategoria()+1);
    }
     }
    actual = actual.getNext();
    }
   System.out.print("NO ENTRA");

        }

    }

}

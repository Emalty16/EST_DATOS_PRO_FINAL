/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentCar_Proyecto.Vehiculos;


public class ColaVehiculo {
    
    private NodoVehiculo cabeza;
    private NodoVehiculo cola;

    public   ColaVehiculo(NodoVehiculo cabeza, NodoVehiculo cola) {
        this.cabeza = cabeza;
        this.cola = cola;
    }
    
      public ColaVehiculo() {
      
    }
      
      
      public void Insertar(NodoVehiculo v){
          
          if(cabeza == null){
           cabeza = v;
           cola = v;
          }
          
          else
          {
              
        cola.setNext(v);
        cola = v;
          
          }
            
      }
      
      public void Eliminar(String placa) {

        NodoVehiculo aux = new NodoVehiculo();
        
        aux.setPlaca(placa);
        
        
        if (cabeza != null) {
        if (cabeza == cola && placa.equalsIgnoreCase(cabeza.getPlaca())) {
         cabeza = cola = null;

            } else if (aux.getPlaca().equalsIgnoreCase(cabeza.getPlaca())) {

           cabeza = cabeza.getNext();

            } else {
           NodoVehiculo auxiliar = new NodoVehiculo();
           NodoVehiculo anterior = new NodoVehiculo();
           anterior = cabeza;
           auxiliar = cabeza.getNext();
           
                while (auxiliar != null && !auxiliar.getPlaca().equalsIgnoreCase(aux.getPlaca())) {

             anterior = anterior.getNext();
             auxiliar = auxiliar.getNext();
                }
                if (auxiliar != null) {
                anterior.setNext(auxiliar.getNext());

                    if (auxiliar == cola) {

                        cola = anterior;

                    }

                }

            }

        }

    }
      
      public void MostrarCola(){
          NodoVehiculo aux = cabeza;
          
          if(cabeza != null){
              while(aux != null){
                  System.out.println(aux.getPlaca() + " " + aux.getExtras());
                   
                  aux = aux.getNext();
              }
              
          }
      }
      
      
      
      
   
      
      
    
}

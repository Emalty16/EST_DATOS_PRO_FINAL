/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RentCar_Proyecto.Clientes;

public class Clientes {
    
    private String NombreCliente;
    private int NumeroDeCedula;
    private String CorreoElectronico;
    private int Categoria;
    private String fechaNacimiento;
    
    public Clientes(int cedula, String nombre, String fechaNacimiento, String correo, int cate)
    
    {
    this.NumeroDeCedula = cedula;
    this.NombreCliente = nombre;
    this.fechaNacimiento = fechaNacimiento;
    this.CorreoElectronico = correo;
    this.Categoria = cate;
    }

  
   
 public Clientes() {
        
     
    }

    public int getCategoria() 
    
    {
        return Categoria;
    }

    public void setCategoria(int Categoria) 
    {
        this.Categoria = Categoria;
    }

    

    public int getNumeroDeCedula() 
    {
        return NumeroDeCedula;
    }

    public void setNumeroDeCedula(int NumeroDeCedula) 
    {
        this.NumeroDeCedula = NumeroDeCedula;
    }

    public String getNombreCliente() 
    {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) 
    {
        this.NombreCliente = NombreCliente;
    }

    public String getFechaNacimiento() 
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) 
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() 
    {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) 
    {
        this.CorreoElectronico = CorreoElectronico;
    }

  
   
    public String toString()
    {
        return "Clientes{" + "cedula=" + NumeroDeCedula + '}';
    }
    
    
    
    
    
    
    
    
}

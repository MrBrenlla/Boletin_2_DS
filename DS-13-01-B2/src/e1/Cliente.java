/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

/**
 *
 * @author Brais
 */
public final class Cliente extends Persona {
    private final String code;
    private final int numCompras;

    public Cliente(String nome, String apellidos, String DNI,String code, int numCompras, String direccion, int telefono) {
        this.code = code;
        this.numCompras = numCompras;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
     public Cliente(String nome, String apellidos, String DNI,String code, int numCompras, int telefono) {
        this.code = code;
        this.numCompras = numCompras;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.telefono = telefono;
        this.direccion = "Sin direccion";
    }
     
      public Cliente(String nome, String apellidos, String DNI,String code, int numCompras, String direccion) {
        this.code = code;
        this.numCompras = numCompras;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.direccion = direccion;
    }
      
    public Cliente(String nome, String apellidos, String DNI,String code, int numCompras) {
        this.code = code;
        this.numCompras = numCompras;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.direccion = "Sin direccion";
    }
    
    @Override
    public String toString(){
        return nome+" "+apellidos+" "+DNI+" "+code+" "+Integer.toString(numCompras)+" "+direccion+" "+Integer.toString(telefono);
    }
}

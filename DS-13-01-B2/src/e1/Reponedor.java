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
public final class Reponedor extends Traballador {
    private final String empresa;
    
    public Reponedor(String nome, String apellidos,int seguridadeSocial, int salario, Turno turno,String empresa, String DNI, String direccion, int telefono) {
        this.empresa = empresa;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
        this.seguridadeSocial = seguridadeSocial;
        this.salario = salario;
        this.turno = turno;
    }
    
    public Reponedor(String nome, String apellidos,int seguridadeSocial, int salario, Turno turno,String empresa, String DNI, String direccion) {
        this.empresa = empresa;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.direccion = direccion;
        this.seguridadeSocial = seguridadeSocial;
        this.salario = salario;
        this.turno = turno;
    }
        
    public Reponedor(String nome, String apellidos,int seguridadeSocial, int salario, Turno turno,String empresa, String DNI, int telefono) {
        this.empresa = empresa;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.telefono = telefono;
        this.seguridadeSocial = seguridadeSocial;
        this.salario = salario;
        this.turno = turno;
        this.direccion = "Sin direccion";

    }
    
    public Reponedor(String nome, String apellidos,int seguridadeSocial, int salario, Turno turno,String empresa, String DNI) {
        this.empresa = empresa;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.seguridadeSocial = seguridadeSocial;
        this.salario = salario;
        this.turno = turno;
        this.direccion = "Sin direccion";
    }
    
    @Override
    public String toString(){
        return nome+" "+apellidos+" "+Integer.toString(seguridadeSocial)+" "+Integer.toString(salario)+" "+
                turno.toString()+empresa+" "+DNI+" "+direccion+" "+Integer.toString(telefono);
    }
}

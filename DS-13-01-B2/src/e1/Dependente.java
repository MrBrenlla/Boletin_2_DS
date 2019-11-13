/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;


public final class Dependente extends Traballador{
    private final String especialidade;

    public Dependente(String nome, String apellidos,int seguridadeSocial, int salario, Turno turno,String especialidade, String DNI, String direccion, int telefono) {
        this.especialidade = especialidade;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
        this.seguridadeSocial = seguridadeSocial;
        if(turno==Turno.NOITE) this.salario=salario+150;
        else this.salario = salario;
        this.turno = turno;
    }
    
    public Dependente(String nome, String apellidos,int seguridadeSocial, int salario, Turno turno,String especialidade, String DNI, String direccion) {
        this.especialidade = especialidade;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.direccion = direccion;
        this.seguridadeSocial = seguridadeSocial;
        if(turno==Turno.NOITE) this.salario=salario+150;
        else this.salario = salario;
        this.turno = turno;
    }
    
    public Dependente(String nome, String apellidos,int seguridadeSocial, int salario, Turno turno,String especialidade, String DNI, int telefono) {
        this.especialidade = especialidade;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.telefono = telefono;
        this.seguridadeSocial = seguridadeSocial;
        if(turno==Turno.NOITE) this.salario=salario+150;
        else this.salario = salario;
        this.turno = turno;
        this.direccion = "Sin direccion";

    }
    
    public Dependente(String nome, String apellidos,int seguridadeSocial, int salario, Turno turno,String especialidade, String DNI) {
        this.especialidade = especialidade;
        this.nome = nome;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.seguridadeSocial = seguridadeSocial;
        if(turno==Turno.NOITE) this.salario=salario+150;
        else this.salario = salario;
        this.turno = turno;
        this.direccion = "Sin direccion";

    }
    
    @Override
    public String toString(){
        return nome+" "+apellidos+" "+Integer.toString(seguridadeSocial)+" "+Integer.toString(salario)+" "+
                turno.toString()+especialidade+" "+DNI+" "+direccion+" "+Integer.toString(telefono);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;


public abstract class Traballador extends Persona {
    int seguridadeSocial;
    int salario;
    Turno turno;

    public int getSalario(){
        return this.salario;
    }
    
}

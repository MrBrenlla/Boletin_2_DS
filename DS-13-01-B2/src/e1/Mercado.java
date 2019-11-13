/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.ArrayList;
import java.util.HashSet; 
import java.util.Collection;

public class Mercado {
    
    private final HashSet<Cliente> clientela;
    private final HashSet<Traballador> persoal;
    
    public Mercado() {
        this.clientela = new HashSet<>();
        this.persoal = new HashSet<>();
    }
    
    
    public boolean agregarCliente( Cliente c ) {
        return clientela.add(c);
    }
    
    public boolean agregarTraballador(Traballador t ) {
        return persoal.add(t);
    }
    
    public void agregarTraballadores(  Collection<? extends Traballador> col ) {
        col.forEach((t) -> {
            persoal.add(t);
        });
    }
    
    public void agregarClientes(Collection<Cliente> col ) {
        col.forEach((c) -> {
            clientela.add(c);
        });
    }
    
    public int salariosMercado(){
        int suma = 0;
        for (Traballador t : this.persoal) {
            suma += t.getSalario();
        }
        return suma;
    }
    
    public Collection<Persona> personasMercado(){
        ArrayList<Persona> col = new ArrayList<>();
        col.addAll(persoal);
        col.addAll(clientela);
        return col;
    }   
}

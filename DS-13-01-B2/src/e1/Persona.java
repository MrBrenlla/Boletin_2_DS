/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.Objects;
import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 *
 * @author Brais
 */
public abstract class Persona {
    String nome;
    String apellidos;
    String DNI;
    String direccion;
    int telefono;


    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = Integer.valueOf(substring(DNI,0,4)) * hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return this.DNI.equals(other.DNI);
    }
}

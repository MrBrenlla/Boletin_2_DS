/**
 * Boletín 1 de DS            10/10/2019
 * Exercicio e4
 * 
 * @author  Ángel Álvarez Rey e Brais García Brenlla
 */
package e2_e3;


import java.util.*;


public class EuroCoinCollection implements java.lang.Iterable<EuroCoin> {
    
    protected  HashSet<EuroCoin> coleccion;
    protected int iterando;

    public EuroCoinCollection() {
        this.coleccion = new HashSet<>();
        iterando = 0;
    }
    
    
    public boolean insertCoin ( EuroCoin coin ) {
        if (iterando == 0) return coleccion.add(coin);
        else throw new ConcurrentModificationException();
    }
    
    public boolean hasCoin ( EuroCoin coin ) { 
        return coleccion.contains(coin);
    }

    
    public int value () {
        int suma =0;
        EuroCoin copia[]= new EuroCoin[coleccion.size()]; //Crease un array do tamaño do set e copianse os elementos do set desntro deste
        copia = coleccion.toArray(copia);
        for (int i=0 ; i<(coleccion.size()) ; i++){ //Recorrese todo o array para leer os valores e sumalos
            suma += copia[i].getValor();
        } 
        return suma;
    }
    
    public int numCoins () {
        return coleccion.size();
    }
    
    public void removeCoin ( EuroCoin coin ) {
       if (iterando == 0) coleccion.remove(coin);
       else throw new ConcurrentModificationException();

    }
    
    //////////////////////    exercicio 2    ///////////////////////////////////
    public List<EuroCoin> sortNatural(){
       if (iterando == 0){
        // Creamos unha lista cos elementos do HashSet 
        List<EuroCoin> list = new ArrayList<>(this.coleccion);
            /*
        for (EuroCoin c: this.coleccion) List.add(c);
        */
       
        Collections.sort(list);
        return list;
       } else throw new ConcurrentModificationException();

    }
    
    public List<EuroCoin> sortComparator(){
        if (iterando == 0){
        // Creamos unha lista cos elementos do HashSet 
        List<EuroCoin> list = new ArrayList<>(this.coleccion);
        Comparator comp = new Comparator();
        Collections.sort(list, comp);
        return list;
        } else throw new ConcurrentModificationException();

    }
    
    //////////////////////    exercicio 3    ///////////////////////////////////
    @Override
    public Iterador iterator() {
        iterando +=1;
        return (Iterador) this;
    }
    
    
    
}
    
    
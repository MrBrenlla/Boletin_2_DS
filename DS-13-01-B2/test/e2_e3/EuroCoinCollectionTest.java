package e2_e3;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EuroCoinCollectionTest {
    EuroCoin e1_sp1, // Juan Carlos I coin
             e1_sp2, // Felipe VI coin
             e2_sp_2002,  // Juan Carlos I coin of 2002
             e2_sp_2005,  // Juan Carlos I coin of 2005
             c50_it, 
             c20_fr, 
             c50_fr,
             c1_pt,
             c1_es;
    EuroCoinCollection collection;
    /**
     *
     */
    @Before
    public void setUp() {
        collection = new EuroCoinCollection();
        
        // THIS COINS MUST BE PROPERLY CREATED IN ORDER TO THE TEST TO WORK CORRECTLY
        e1_sp1 = new EuroCoin(Valor.EUROS_1,"Juan Carlos I",0,Pais.SPAIN);
        e1_sp2 = new EuroCoin(Valor.EUROS_1,"Felipe VI",0,Pais.SPAIN);
        e2_sp_2002  = new EuroCoin(Valor.EUROS_2,"Juan Carlos I",2002,Pais.SPAIN);
        e2_sp_2005  = new EuroCoin(Valor.EUROS_2,"Juan Carlos I",2005,Pais.SPAIN);
        c50_it = new EuroCoin(Valor.CENTIMOS_50,"",0,Pais.ITALY);
        c20_fr = new EuroCoin(Valor.CENTIMOS_20,"",0,Pais.FRANCE);
        c1_pt = new EuroCoin(Valor.CENTIMOS_1,"",0,Pais.PORTUGAL);
        c1_es = new EuroCoin(Valor.CENTIMOS_1,"",0,Pais.SPAIN);

       
        assertTrue(collection.insertCoin(e1_sp1));
        assertTrue(collection.insertCoin(e1_sp2));
        assertTrue(collection.insertCoin(e2_sp_2002));
        assertFalse(collection.insertCoin(e2_sp_2005)); // Not inserted
        assertTrue(collection.insertCoin(c50_it));
        assertTrue(collection.insertCoin(c20_fr));
        assertFalse(collection.insertCoin(c50_it)); // Not inserted  
    }
    
    @Test
    public void testNumCoins() {       
        assertEquals(5, collection.numCoins());
    }

    @Test
    public void testHasCoin() {
        assertTrue(collection.hasCoin(e1_sp1));
        assertTrue(collection.hasCoin(e2_sp_2005));
        assertFalse(collection.hasCoin(c1_pt));
    }

    @Test
    public void testCollectionValue() {
        assertEquals(470, collection.value());
    }    
    
    @Test
    public void testRemoveCoin() {
        collection.removeCoin(c50_it);
        assertEquals(4, collection.numCoins());
        assertEquals(420, collection.value());
        
        collection.removeCoin(e2_sp_2005); // removes the 2002 coin
        assertEquals(3, collection.numCoins());
        assertEquals(220, collection.value());
        
        collection.removeCoin(c1_pt); // No coin removed
        assertEquals(3, collection.numCoins());
        assertEquals(220, collection.value());
    }  
    
    @Test
    public void testSortNatural() {
        
        
        EuroCoinCollection collectionE2 = new EuroCoinCollection(); //coleccion sortNatural
        EuroCoinCollection collectionT2 = new EuroCoinCollection(); //coleccion comprobacion sortNatural
        
            //EuroCoin(Valor valor, String diseño, int año, Pais pais)
            e1_sp1 = new EuroCoin(Valor.EUROS_1,"Juan Carlos I",0,Pais.SPAIN);
            e1_sp2 = new EuroCoin(Valor.EUROS_1,"Felipe VI",0,Pais.SPAIN);
            e2_sp_2002  = new EuroCoin(Valor.EUROS_2,"Juan Carlos I",2002,Pais.SPAIN);
            e2_sp_2005  = new EuroCoin(Valor.EUROS_2,"Juan Carlos I",2005,Pais.SPAIN);
            c50_it = new EuroCoin(Valor.CENTIMOS_50,"",0,Pais.ITALY);
            c50_fr = new EuroCoin(Valor.CENTIMOS_50,"",0,Pais.FRANCE);
            c1_pt = new EuroCoin(Valor.CENTIMOS_1,"",0,Pais.PORTUGAL);
        
            
            collectionE2.insertCoin(e1_sp1);
            collectionE2.insertCoin(e2_sp_2005);
            collectionE2.insertCoin(c1_pt);
            collectionE2.insertCoin(c50_it);
            collectionE2.insertCoin(c50_fr);
            collectionE2.insertCoin(e2_sp_2002);
            collectionE2.insertCoin(e1_sp2);
         

            List<EuroCoin> list1 = collectionE2.sortNatural();
            //for (int i = 0; i<list1.size(); i++) {
            //   System.out.print(list1.get(i).getValor());
            //   System.out.println(list1.get(i).getPais());
            //}
  
            
            //Coleccion ordenada 
            collectionT2.insertCoin(e2_sp_2005);
            collectionT2.insertCoin(e1_sp1);
            collectionT2.insertCoin(e1_sp2);
            collectionT2.insertCoin(c50_fr);
            collectionT2.insertCoin(c50_it);
            collectionT2.insertCoin(c1_pt);
            
            //System.out.println("'''''''''''''''");
            List<EuroCoin> list2 = collectionT2.sortNatural();
            //for (int i = 0; i<list2.size(); i++) {
            //    System.out.print(list1.get(i).getValor());
            //  System.out.println(list1.get(i).getPais());
            //}
            
            assertTrue(list1.equals(list2));
    }
    
    @Test
    public void testComparator(){
                Comparator c = new Comparator();
        assertEquals(1,c.compare(e2_sp_2005,e1_sp1));
        assertEquals(-1,c.compare(e1_sp1,e2_sp_2005));
        assertEquals(1,c.compare(e2_sp_2005,e2_sp_2002));
        assertEquals(-1,c.compare(e2_sp_2002,e2_sp_2005));
        assertEquals(-1,c.compare(e2_sp_2005,c50_it));
        assertEquals(1,c.compare(c50_it,e2_sp_2005));
        assertEquals(0,c.compare(e2_sp_2005,e2_sp_2005));
    }
    
    @Test
    public void testCompareTo(){
                Comparator c = new Comparator();
        assertEquals(-1,e1_sp1.compareTo(e1_sp2));
        assertEquals(0,e2_sp_2005.compareTo(e2_sp_2005));
    }
    
    @Test
    public void testSortComparator(){
        
            EuroCoinCollection collectionE2 = new EuroCoinCollection(); //coleccion SortComparator
            EuroCoinCollection collectionT2 = new EuroCoinCollection(); //coleccion comprobacion SortComparator
            
            //EuroCoin(Valor valor, String diseño, int año, Pais pais)
            e1_sp1 = new EuroCoin(Valor.EUROS_1,"Juan Carlos I",0,Pais.SPAIN);
            e1_sp2 = new EuroCoin(Valor.EUROS_1,"Felipe VI",0,Pais.SPAIN);
            e2_sp_2002  = new EuroCoin(Valor.EUROS_2,"Juan Carlos I",2002,Pais.SPAIN);
            e2_sp_2005  = new EuroCoin(Valor.EUROS_2,"Juan Carlos I",2005,Pais.SPAIN);
            c50_it = new EuroCoin(Valor.CENTIMOS_50,"",0,Pais.ITALY);
            c50_fr = new EuroCoin(Valor.CENTIMOS_50,"",0,Pais.FRANCE);
            c1_pt = new EuroCoin(Valor.CENTIMOS_1,"",0,Pais.PORTUGAL);
        
            collectionE2.insertCoin(e1_sp1);
            collectionE2.insertCoin(e2_sp_2005);
            collectionE2.insertCoin(c1_pt);
            collectionE2.insertCoin(c50_it);
            collectionE2.insertCoin(c50_fr);
            collectionE2.insertCoin(e2_sp_2002);
            collectionE2.insertCoin(e1_sp2);
            
            List<EuroCoin> list1 = collectionE2.sortComparator();
            //for (int i = 0; i<list1.size(); i++) {
            //  System.out.print(list1.get(i).getValor());
            //  System.out.println(list1.get(i).getPais());
            //}
            
            //Coleccion ordenada 
            collectionT2.insertCoin(e2_sp_2005);
            collectionT2.insertCoin(e1_sp1);
            collectionT2.insertCoin(e1_sp2);
            collectionT2.insertCoin(c50_fr);
            collectionT2.insertCoin(c50_it);
            collectionT2.insertCoin(c1_pt);
          
            //System.out.println("'''''''''''''''");
            List<EuroCoin> list2 = collectionT2.sortComparator();
            //for (int i = 0; i<list2.size(); i++) {
            //    System.out.print(list1.get(i).getValor());
            //    System.out.println(list1.get(i).getPais());
            //}
            
            assertTrue(list1.equals(list2));
            
    }
    
    @Test
    public void testIterator(){
        
            EuroCoinCollection collectionE2 = new EuroCoinCollection(); //coleccion SortComparator
            EuroCoinCollection collectionT2 = new EuroCoinCollection(); //coleccion comprobacion SortComparator
            
            //EuroCoin(Valor valor, String diseño, int año, Pais pais)
            e1_sp1 = new EuroCoin(Valor.EUROS_1,"Juan Carlos I",0,Pais.SPAIN);
            e1_sp2 = new EuroCoin(Valor.EUROS_1,"Felipe VI",0,Pais.SPAIN);
            e2_sp_2002  = new EuroCoin(Valor.EUROS_2,"Juan Carlos I",2002,Pais.SPAIN);
            e2_sp_2005  = new EuroCoin(Valor.EUROS_2,"Juan Carlos I",2005,Pais.SPAIN);
            c50_it = new EuroCoin(Valor.CENTIMOS_50,"",0,Pais.ITALY);
            c50_fr = new EuroCoin(Valor.CENTIMOS_50,"",0,Pais.FRANCE);
            c1_pt = new EuroCoin(Valor.CENTIMOS_1,"",0,Pais.PORTUGAL);
        
            collectionE2.insertCoin(c1_es);
            collectionE2.insertCoin(e1_sp1);
            collectionE2.insertCoin(e2_sp_2005);
            collectionE2.insertCoin(c1_pt);
            collectionE2.insertCoin(c50_it);
            collectionE2.insertCoin(c50_fr);
            
            Iterador i = (Iterador)collectionE2.iterator();
            i.setPais(Pais.SPAIN);
            assertEquals(1,i.coleccion.iterando);
            assertEquals( c1_es,i.next());
            assertEquals(1,i.coleccion.iterando);
            i.remove();
            assertEquals(true,i.hasNext());
            assertEquals( e2_sp_2005,i.next());
            assertEquals( e1_sp1,i.next());
            assertEquals(false,i.hasNext());
            assertEquals(0,i.coleccion.iterando);
            assertEquals(false,collectionE2.hasCoin(c1_es));
    }
    
    @Test(expected = ConcurrentModificationException.class)
    public void testExceptionIsertCoin(){
        EuroCoinCollection collectionE2 = new EuroCoinCollection();
        Iterador i = (Iterador)collectionE2.iterator();
        i.setPais(Pais.SPAIN);
        collectionE2.insertCoin(c50_it);
            
    }
    
        @Test(expected = ConcurrentModificationException.class)
    public void testExceptionremoveCoin(){
        EuroCoinCollection collectionE2 = new EuroCoinCollection();
        collectionE2.insertCoin(c50_it);
        Iterador i = (Iterador)collectionE2.iterator();
        i.setPais(Pais.SPAIN);
        collectionE2.removeCoin(c50_it);
            
    }
    
        @Test(expected = NoSuchElementException.class)
    public void testExceptionNext(){
        EuroCoinCollection collectionE2 = new EuroCoinCollection();
        Iterador i = (Iterador)collectionE2.iterator();
        i.setPais(Pais.SPAIN);
        i.next();
    }
        @Test(expected = IllegalStateException.class)
    public void testExceptionRemove(){
        EuroCoinCollection collectionE2 = new EuroCoinCollection();
        Iterador i = (Iterador)collectionE2.iterator();
        i.setPais(Pais.SPAIN);
        i.remove();
    }
    
@Test(expected = ConcurrentModificationException.class)
    public void testExceptionSortNatural(){
        EuroCoinCollection collectionE2 = new EuroCoinCollection();
        Iterador i = (Iterador)collectionE2.iterator();
        i.setPais(Pais.SPAIN);
        collectionE2.sortNatural();
            
    }
    
@Test(expected = ConcurrentModificationException.class)
    public void testExceptionSortComparator(){
        EuroCoinCollection collectionE2 = new EuroCoinCollection();
        Iterador i = (Iterador)collectionE2.iterator();
        i.setPais(Pais.SPAIN);
        collectionE2.sortComparator();
            
    }
}


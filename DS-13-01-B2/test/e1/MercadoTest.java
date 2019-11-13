
package e1;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.util.HashSet;
import java.util.ArrayList;



public class MercadoTest {
    private Mercado m,m1,m2;
    private Dependente d1,d2,d3,d4,d5,d6,d7,d8;
    private Reponedor r1,r2,r3,r4,r5;
    private Cliente c1,c2,c3,c4,c5;
    HashSet<Traballador> t;
    HashSet<Cliente> cli;
    ArrayList<Persona> p;
    
     @Before
    public void setUp() {
        m = new Mercado();
        m1 = new Mercado();
        m2 = new Mercado();
        
        d1 = new Dependente("d1", "1",567789, 300, Turno.NOITE,"ningunha","45619345677v");
        d2 = new Dependente("d2", "2",56789, 300, Turno.NOITE,"ningunha","45612345677v",6556255);
        d3 = new Dependente("d3", "3",567789, 300, Turno.TARDE,"ningunha","45612355677v","A súa casa");
        d4 = new Dependente("d4", "4",567789, 300, Turno.MANAN,"ningunha","45642345677v","por aí", 625325326);
        d5 = new Dependente("d1", "1",567789, 300, Turno.MANAN,"ningunha","45619345677v");
        d6 = new Dependente("d2", "2",56789, 300, Turno.TARDE,"ningunha","45612345677v",6556255);
        d7 = new Dependente("d3", "3",567789, 300, Turno.NOITE,"ningunha","45612355677v","A súa casa");
        d8 = new Dependente("d4", "4",567789, 300, Turno.NOITE,"ningunha","45642345677v","por aí", 625325326);
        
        r1 = new Reponedor("r1", "1",567789, 300, Turno.MANAN,"ningunha","45619345677r");
        r2 = new Reponedor("r2", "2",567789, 300, Turno.MANAN,"ningunha","45612345677r",6556255);
        r3 = new Reponedor("r3", "3",567789, 300, Turno.MANAN,"ningunha","45612355677r","A súa casa");
        r4 = new Reponedor("r4", "4",567789, 300, Turno.MANAN,"ningunha","45642345677r","por aí", 625325326);
        r5 = null;
        
        c1 = new Cliente("c1", "1", "65454563y","dgh", 29, 625325726);
        c2 = new Cliente("c2", "2", "65458563y","dgh", 29, "Algún sitio");
        c3 = new Cliente("c3", "3", "95454563y","dgh", 29, "por aí", 625325326);
        c4 = new Cliente("c4", "4", "65474563y","dgh", 29);
        c5 = new Cliente("c5", "5", "65479563y","dgh", 29);
       
        t=new HashSet<>();
        t.add(d4);
        t.add(r4);
        
        cli=new HashSet<>();
        cli.add(c4);
        cli.add(c3);
        
        p=new ArrayList<>();
        p.add(d1);
        p.add(r1);
        p.add(c1);
    }
    
    @Test
    public void testEquals(){
    assertEquals(true,c1.equals(c1));
    assertEquals(false,c1.equals(null));
    }
     @Test
    public void testToString(){
        assertEquals("d2 2 56789 450 noite ningunha 45612345677v Sin direccion 6556255",d2.toString());
        assertEquals("d3 3 567789 300 tarde ningunha 45612355677v A súa casa 0",d3.toString());
        assertEquals("r1 1 567789 300 manan ningunha 45619345677r Sin direccion 0",r1.toString());
        assertEquals("c5 5 65479563y dgh 29 Sin direccion 0",c5.toString());
    }  
    
    @Test
    public void testAgregarCliente() {
        assertEquals(true, m.agregarCliente(c1) );
        assertEquals(true, m.agregarCliente(c2) );
        assertEquals(false, m.agregarCliente(c1) );
    }
    
    @Test
    public void testAgregarTraballador() {
        assertEquals(true, m.agregarTraballador(d1));
        assertEquals(true, m.agregarTraballador(r2));
        assertEquals(false, m.agregarTraballador(d1));
        assertEquals(true, m.agregarTraballador(d2));
        assertEquals(false, m.agregarTraballador(r2));
        assertEquals(false, m.agregarTraballador(d5));
    }
     
    @Test
    public void testAgregarTraballadores() {
        m.agregarTraballadores(t);
        assertEquals(true, m.agregarTraballador(r3));
        assertEquals(false, m.agregarTraballador(d4));
        assertEquals(false, m.agregarTraballador(r4));
    }
    
    @Test
        public void testAgregarClientes() {
        m.agregarClientes(cli);
        assertEquals(true,  m.agregarCliente(c5));
        assertEquals(false, m.agregarCliente(c3));
        assertEquals(false, m.agregarCliente(c4));
    }

    @Test
    public void testSalariosMercado() {
        assertEquals(true, m1.agregarTraballador(d6));
        assertEquals(true, m1.agregarTraballador(d7));
        assertEquals(true, m1.agregarTraballador(d8));
        assertEquals(1200, m1.salariosMercado());
    }
    
    @Test
    public void testPersonasMercado() {
        assertEquals(true, m2.agregarTraballador(d1));
        assertEquals(true, m2.agregarTraballador(r1));
        assertEquals(true, m2.agregarCliente(c1));
        assertEquals(p, m2.personasMercado());
    }
     
}

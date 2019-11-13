/**
 * Boletín 1 de DS            10/10/2019
 * Exercicio e4
 * 
 * @author  Ángel Álvarez Rey e Brais García Brenlla
 */
package e2_e3;


public enum Valor{
    EUROS_2(200),EUROS_1(100),CENTIMOS_50(50),CENTIMOS_20(20),CENTIMOS_10(10),CENTIMOS_5(5),CENTIMOS_2(2),CENTIMOS_1(1) ;
    
    private final int centimos;
    
    Valor(int valor){
        this.centimos=valor; 
    }

    public int getCentimos() {
        return centimos;
    }
    
}
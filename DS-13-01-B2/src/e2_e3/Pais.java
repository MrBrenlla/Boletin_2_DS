/**
 * Boletín 1 de DS            10/10/2019
 * Exercicio e4
 * 
 * @author  Ángel Álvarez Rey e Brais García Brenlla
 */
package e2_e3;


public enum Pais{
   AUSTRIA("AT"),BELGIUM("BE"),CYPRUS("CY"),NETHERLANDS("NL"),ESTONIA("EE"),FINLAND("FI"),FRANCE("FR"),
   GERMANY("DE"),GREECE("GR"),IRELAND("IE"),ITALY("IT"),LATVIA("LV"),LITHUANIA("LT"),LUXEMBOURG("LU"),
   MALTA("MT"),MONACO("MC"),PORTUGAL("PT"),SAN_MARINO("SM"),SLOVAKIA("SK"),SLOVENIA("SI"),SPAIN("ES"),
   VATICAN_CITY("VA");
   
    private final String code;
    

    Pais(String code){
        this.code=code;
    }

    public String getCode() {
        return code;
    }
    
    
}


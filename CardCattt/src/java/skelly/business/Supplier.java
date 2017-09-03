package skelly.business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The <code>Supplier</code> class is a sublass of <code>Company</code>
 * @author Skelly
 * @version Card Cat App Proj 1
 */
public class Supplier extends Company {
    
    private String tradeSpecialty;
  
    /**
     * Creates a <code>Supplier</code> with default values.
     */    
    public Supplier(){
        tradeSpecialty = "";
    }

    /**
     * Returns a <code>String</code> that represents the Supplier's trade specialty.
     * @return A <code>String</code> for the Supplier's trade specialty.
     */
    public String getTradeSpecialty() {
        return tradeSpecialty;
    }

    /**
     * Sets the supplier's trade specialty to the specified <code>String</code>
     * @param tradeSpecialty A <code>String</code> for the Supplier's trade specialty.
     */
    public void setTradeSpecialty(String tradeSpecialty) {
        this.tradeSpecialty = tradeSpecialty;
    }
    
}

package skelly.business;

/**
 * The <code>Insurance Company</code> class is a subclass of <code>Company</code>
 * @author Skelly
 * @version Card Cat App Proj 1
 */

public class InsuranceCompany extends Company {
    
    private String claimsContactName;
    private int carrierCode;
   
    
  /**
   * Creates a <code>Insurance Company</code> with default values.
   */  
    public InsuranceCompany(){
        claimsContactName = "";
        carrierCode = 0;
    }

    /**
     * Returns a <code>String</code> that represents the contact's name
     * @return A <code>String</code> for the contact's name.
     */
    public String getContactName() {
        return claimsContactName;
    }

    /**
     * Sets the contact's name to the specified <code>String</code>
     * @param contactName A <code>String</code> for the contact's name.
     */
    public void setContactName(String contactName) {
        this.claimsContactName = contactName;
    }

    /**
     * Returns a <code>int</code> that represents the carrier code.
     * @return A <code>int</code> for the carrier code.
     */
    public int getCarrierCode() {
        return carrierCode;
    }

    /**
     * Sets the carrier code to the specified <code>int</code>
     * @param carrierCode A <code>int</code> for the carrier code.
     */
    public void setCarrierCode(int carrierCode) {
        this.carrierCode = carrierCode;
    }
    
}

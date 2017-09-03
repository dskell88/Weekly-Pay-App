package skelly.business;

/**
 * The <code>Insurance Company</code> class is a subclass of <code>Company</code>
 * @author Skelly
 * @version Card Cat App Proj 1
 */

public abstract class Company {
    
    private String companyName;
    private String contactName;
    private String address;
    private String phone;
    private String fax;

  /**
   * Creates a <code>Company</code> with default values.
   */  
public Company() {
    companyName = "";
    contactName = "";
    address = "";
    phone = "";
    fax = "";
    
    
}
    /**
     * Returns a <code>String</code> that represents the company's name
     * @return A <code>String</code> for the company's name.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the company's name to the specified <code>String</code>
     * @param companyName A <code>String</code> for the contact's name.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Returns a <code>String</code> that represents the contact's name
     * @return A <code>String</code> for the contact's name.
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the contact name to the specified <code>String</code>
     * @param contactName A <code>String</code> for the contact's name.
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * Returns a <code>String</code> that represents the address
     * @return A <code>String</code> for the address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the fax to the specified <code>String</code>
     * @param address A <code>String</code> for the fax.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a <code>String</code> that represents the phone.
     * @return A <code>String</code> for the phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the fax to the specified <code>String</code>
     * @param phone A <code>String</code> for the fax.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns a <code>String</code> that represents the fax
     * @return A <code>String</code> for the fax.
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the fax to the specified <code>String</code>
     * @param fax A <code>String</code> for the fax.
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

}

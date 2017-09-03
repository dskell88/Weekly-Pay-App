package skelly.cardinalapp;

import skelly.cardinalapp.Person;
import skelly.business.InsuranceCarrier;
import skelly.business.Displayable;

/**
 * The <code>Client</code> class is a sublass of <code>Person</code>
 * @author Skelly
 * @version Card Cat App Proj 1
 */
public class Client extends Person implements InsuranceCarrier, Displayable{

    private int clientID;
    private int department;
    private int insuranceCarrier;
  
 /**
 * Creates a <code>Client</code> with default values.
 */  
public Client() {
    super();
    clientID = 0;
    department = 0;
    insuranceCarrier = 0;

    
    
}
    /**
     * Returns a <code>String</code> that represents the Client's number.
     * @return A <code>String</code> for the Client's number.
     */
    public int getClientID() {
        return clientID;
    }
    /**
     * Sets the client number to the specified <code>String</code>
     * @param clientID A <code>String</code> for the Client's number.
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    
    /**
     * Returns a <code>String</code> that represents the Client's insurance carrier.
     * @return A <code>String</code> for the Client's insurance carrier.
     */
    public int getInsuranceCarrier() {
        return insuranceCarrier;
    }

    /**
     * Sets the insurance carrier to the specified <code>String</code>
     * @param insuranceCarrier A <code>String</code> for the Client's insurace carrier.
     */
    public void setInsuranceCarrier(int insuranceCarrier) {     //work on this...
        this.insuranceCarrier = insuranceCarrier;
    }
    
    
        
    @Override
        public String getDisplayText()
    {
	           String ins = ""; 
               if (insuranceCarrier == ALL)
                   ins = "CC";
               else if (insuranceCarrier == COCO)
                   ins = "VC";
               else if (insuranceCarrier == FARM)
                   ins = "NC";
               else if (insuranceCarrier == STATE)
                   ins = "IG";
                   	 
        return super.toString() +
			"Client Number: " + this.clientID + "\n"
                      + "Insurance Carrier: " + ins;
                     
        }

    /**
     * @return the department
     */
    public int getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(int department) {
        this.department = department;
    }
      


}

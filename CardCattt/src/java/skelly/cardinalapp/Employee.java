package skelly.cardinalapp;

import skelly.business.Division;
import skelly.cardinalapp.Person;
import skelly.business.Displayable;
import skelly.business.Division;

/**
 * The <code>Employee</code> class is a sublass of <code>Person</code>
 * @author Skelly
 * @version Card Cat App Proj 1
 */
public class Employee extends Person implements Displayable, Division {

    private String socialSecurity;
    private int division;

 /**
 * Creates a <code>Employee</code> with default values.
 */   
public Employee() {
    super();
    socialSecurity = "";
    division = 0;
    
}

    /**
     * Returns a <code>String</code> that represents the Employee's Social Security Number.
     * @return A <code>String</code> for the Employee's social security number.
     */
    public String getSocialSecurity() {
        return socialSecurity;
    }
    /**
     * Sets the Social Security to the specified <code>String</code>
     * @param socialSecurity A <code>String</code> for the Employee's Social Security Number.
     */
    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }
        

    /**
     * Returns a <code>Int</code> that represents the Employee's Division.
     * @return A <code>Int</code> for the Employee's Division.
     */
    public int getDivision() {
        return division;
    }

    /**
     * Sets the Division to the specified <code>Int</code>
     * @param division A <code>Int</code> for the Employee's Division.
     */
    public void setDivision(int division) {
        this.division = division;
    }
       
    
        @Override
        public String getDisplayText()
    {
               String cc = ""; 
               if (division == CC)
                   cc = "CC";
               else if (division == VC)
                   cc = "VC";
               else if (division == NC)
                   cc = "NC";
               else if (division == IG)
                   cc = "IG";
                   

		return super.toString() +
			"Social Security: " + socialSecurity + "\n"
                      + "Division: " +cc;
                        
       
    }
}

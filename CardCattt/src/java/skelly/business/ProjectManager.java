package skelly.business;

import java.text.NumberFormat;
import skelly.cardinalapp.Employee;

/**
 * The <code>Project manager</code> class is a subclass of <code>Employee</code>
 * @author Skelly
 * @version Card Cat App Proj 1
 */

public final class ProjectManager extends Employee implements PayPlanPercent {
    
    private int ProjID;
    private String startDate;
    private double payPlan;  
    
  /**
   * Creates a <code>ServiceTech</code> with default values.
   */    
    public ProjectManager(){
        ProjID = 0;
        startDate = "";
        payPlan = 0.0;
    }

    /**
     * Returns a <code>String</code> that represents the Start Date
     * @return A <code>String</code> for the Start Date..
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date to the specified <code>String</code>
     * @param startDate A <code>String</code> for the start date.
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns a <code>double</code> that represents the Pay Plan
     * @return A <code>double</code> for the Pay plan
     */
    public double getPayPlan() {
        return payPlan;
    }

    /**
     * Sets the pay plan to the specified <code>double</code>
     * @param payPlan A <code>double</code> for the start date.
     */
    public void setPayPlan(double payPlan) {
        this.payPlan = payPlan;
    }
    
        @Override
        public String getDisplayText()
    {
        
        NumberFormat percent = NumberFormat.getPercentInstance();
        double cg = 0.0;
        if (payPlan == FIRST)
            cg = .30;
        else if (payPlan == SECOND)
            cg = .40;
        else if (payPlan == THIRD)
            cg = .50;
            
        
	String displayText =  
	     "Start date: " + this.getStartDate() + "\n" 
           + "Pay Plan: " + percent.format(cg);
	return displayText;
    }

    /**
     * @return the ProjID
     */
    public int getProjID() {
        return ProjID;
    }

    /**
     * @param ProjID the ProjID to set
     */
    public void setProjID(int ProjID) {
        this.ProjID = ProjID;
    }

    
}

package skelly.business;

import skelly.cardinalapp.Employee;


/**
 * The <code>ServiceTech</code> class is a final class
 * @author Skelly
 * @version Card Cat App Proj 1
 */
public final class ServiceTech extends Employee implements Trade {
    
    private String workCompNum;
    private int trade;
     
  /**
   * Creates a <code>ServiceTech</code> with default values.
   */    
    public ServiceTech(){
        workCompNum = "";
        trade = 0;
    }

    /**
     * Returns a <code>String</code> that represents the Service Tech's work comp number.
     * @return A <code>String</code> for the Service Tech's comp number.
     */
    public String getWorkCompNum() {
        return workCompNum;
    }

    /**
     * Sets the Service tech's work comp number to the specified <code>String</code>
     * @param workCompNum A <code>String</code> for the Service tech's work comp number.
     */
    public void setWorkCompNum(String workCompNum) {
        this.workCompNum = workCompNum;
    }

    /**
     * Returns a <code>String</code> that represents the Service Tech's trade.
     * @return A <code>String</code> for the Service Tech's comp number.
     */
    public int getTrade() {
        return trade;
    }

    /**
     * @param trade the trade to set
     */
    public void setTrade(int trade) {
        this.trade = trade;
    }
    
    @Override
    public String getDisplayText(){

                String displayText = "";
        displayText += "Worker's Comp Number:\t" + this.workCompNum + "\n";

        
        
       
        String tg = "";
        if (trade == ROOF)
            tg = "Roofing";
        else if (trade == SIDE)
            tg = "Siding";
        else if (trade == GUT)
            tg = "Guttering";
            
        displayText+= "Trade:\t" + tg + "\n";
        return displayText;
        
    }

  
    
}

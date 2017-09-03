/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skelly.business;

/**
 *
 * @author dskelly
 */
public class Job {
    
    private int JobID;
    private String jobProfit;
    
    public Job () {
        JobID = 0;
        jobProfit = "";
    }

    /**
     * @return the JobID
     */
    public int getJobID() {
        return JobID;
    }

    /**
     * @param JobID the JobID to set
     */
    public void setJobID(int JobID) {
        this.JobID = JobID;
    }

    /**
     * @return the jobProfit
     */
    public String getJobProfit() {
        return jobProfit;
    }

    /**
     * @param jobProfit the jobProfit to set
     */
    public void setJobProfit(String jobProfit) {
        this.jobProfit = jobProfit;
    }
    
}

package skelly.cardinalapp;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import skelly.business.Job;
import skelly.business.ProjectManager;
import skelly.cardinalapp.Client;
import skelly.data.JobDB;

public class JobAdminController extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayJobs";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("displayJobs")) {
            url = displayJobs(request, response);
        } else if (action.equals("displayJob")) {
            url = displayJob(request, response);
        } else if (action.equals("addJob")) {
            url = "/job.jsp";
        } else if (action.equals("deleteJob")) {
            url = deleteJob(request, response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayJobs";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("updateJob")) {
            url = updateJob(request, response);
        } else if (action.equals("deleteJob")) {
            url = deleteJob(request, response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String displayJobs(HttpServletRequest request,
            HttpServletResponse response) {

        List<Job> jobs = JobDB.selectJobs();
        request.setAttribute("jobs", jobs);
        return "/jobs.jsp";
    }

    private String displayJob(HttpServletRequest request,
            HttpServletResponse response) {

        String jobID = request.getParameter("jobID");
        Job job;
        if (jobID == null || jobID.isEmpty()) {
            job = new Job();
        } else {
            job = JobDB.selectJob(jobID);
        }

        request.setAttribute("job", job);
        return "/job.jsp";
    }

    private String addJob(HttpServletRequest request,
            HttpServletResponse response) {

        return "/job.jsp";
    }

    private String updateJob(HttpServletRequest request,
            HttpServletResponse response) {

        int jobID;
        jobID = Integer.parseInt(request.getParameter("jobCode"));
        int clientID;
        clientID = Integer.parseInt(request.getParameter("ClientID"));
        int projID;
        projID = Integer.parseInt(request.getParameter("ProjectMangerID"));
        String jobProfit = (String) request.getParameter("description");
        String priceString = (String) request.getParameter("price");
 

        double price;
        try {
            price = Double.parseDouble(priceString);
        } catch (NumberFormatException e) {
            price = 0;
        }
        
        Job job = (Job) request.getAttribute("job");
        Client client = (Client) request.getAttribute("client");
        ProjectManager projman = (ProjectManager) request.getAttribute("projectmanager");
        if (job == null | client == null | projman == null) {
            job = new Job();
            client = new Client();
            projman = new ProjectManager();
        }
        job.setJobID(jobID);
        client.setClientID(clientID);
        projman.setProjID(projID);
        job.setJobProfit(jobProfit);
        request.setAttribute("job", job);
        request.setAttribute("client", client);


        String message = "";
        if (job.getJobID() <= 0) {
            message = "You must enter a Job ID number.";
        }
        if (client.getClientID() <= 0) {
            message = "You must enter a Client ID number.";
        }
        if (projman.getProjID() <= 0) {
            message = "You must enter a Project ID number.";
        }
        request.setAttribute("message", message);

        String url;
        if (message.isEmpty()) {
            if (JobDB.exists(job.getProjID())) {
                JobDB.updateJob(job, client, projman);
            } else {
                JobDB.insertJob(job, client, projman);
            }
            url = displayJobs(request, response);
        } else {
            url = "/job.jsp";
        }
        return url;
    }
    
    private String deleteJob(HttpServletRequest request,
            HttpServletResponse response) {

        String JobID = request.getParameter("jobCode");
        Job job = JobDB.selectJob(JobID);
        request.setAttribute("job", job);
        
        String url;
        String yesButton = request.getParameter("yesButton");
        if (yesButton != null) {
            JobDB.deleteJob(job);
            url = displayJobs(request, response);
        } else {
            url = "/confirm_job_delete.jsp";
        }
        return url;
    }    
}
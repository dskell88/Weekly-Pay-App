package skelly.cardinalapp;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import skelly.business.ProjectManager;
import skelly.data.ProjMgrDB;

public class ProjectAdminController extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayProjects";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("displayProjects")) {
            url = displayProjects(request, response);
        } else if (action.equals("displayProject")) {
            url = displayProject(request, response);
        } else if (action.equals("addProject")) {
            url = "/product.jsp";
        } else if (action.equals("deleteProject")) {
            url = deleteProject(request, response);
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
            action = "displayProjects";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("updateProject")) {
            url = updateProjectManager(request, response);
        } else if (action.equals("deleteProject")) {
            url = deleteProject(request, response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String displayProjects(HttpServletRequest request,
            HttpServletResponse response) {

        List<ProjectManager> projects = ProjMgrDB.selectProjectManagers();
        request.setAttribute("products", projects);
        return "/projmgrs.jsp";
    }

    private String displayProject(HttpServletRequest request,
            HttpServletResponse response) {

        String productCode = request.getParameter("productCode");
        ProjectManager project;
        if (productCode == null || productCode.isEmpty()) {
            project = new ProjectManager();
        } else {
            project = ProjMgrDB.selectProjectManager(productCode);
        }

        request.setAttribute("product", project);
        return "/projmgr.jsp";
    }

    private String addProjectManager(HttpServletRequest request,
            HttpServletResponse response) {

        return "/projmgr.jsp";
    }

    private String updateProjectManager(HttpServletRequest request,
            HttpServletResponse response) {

        int projid;
        projid = Integer.parseInt(request.getParameter("ProjectID"));
        String firstName = (String) request.getParameter("FirstName");
        String lastName = (String) request.getParameter("FirstName");
        String email = (String) request.getParameter("FirstName");
        String startdate = (String) request.getParameter("StartDate");
        double payplan; 
        payplan = Double.parseDouble(request.getParameter("PayPlan"));
        String priceString = (String) request.getParameter("price");
        double price;
        try {
            price = Double.parseDouble(priceString);
        } catch (NumberFormatException e) {
            price = 0;
        }
        

        ProjectManager project = (ProjectManager) request.getAttribute("projectmanager");
        if (project == null) {
            project = new ProjectManager();
        }
        project.setProjID(projid);
        project.setFirstName(firstName);
        project.setLastName(lastName);
        project.setEmail(email);
        project.setStartDate(startdate);
        project.setPayPlan(payplan);
        request.setAttribute("product", project);

       
        String message = "";
        if (project.getProjID() <=0)_ {
            message = "You must enter the Project Manager ID "
                    + "any currency symbols.";
        }
        if (project.getStartDate().isEmpty()) {
            message = "You must enter a description for the product.";
        }
        if (project.getPayPlan() <=0) {
            message = "You must enter a code for the product.";
        }
        request.setAttribute("message", message);

        String url;
        if (message.isEmpty()) {
            if (ProjMgrDB.exists(project.getProjID())) {
                ProjMgrDB.updateProjectManager(project);
            } else {
                ProjMgrDB.insertProjectManager(project);
            }
            url = displayProjects(request, response);
        } else {
            url = "/product.jsp";
        }
        return url;
    }
    
    private String deleteProject(HttpServletRequest request,
            HttpServletResponse response) {

        String productCode = request.getParameter("productCode");
        ProjectManager project = ProjMgrDB.selectProjectManager(productCode);
        request.setAttribute("product", project);
        
        String url;
        String yesButton = request.getParameter("yesButton");
        if (yesButton != null) {
            ProjMgrDB.deleteProjectManager(project);
            url = displayProjects(request, response);
        } else {
            url = "/confirm_product_delete.jsp";
        }
        return url;
    }    
}
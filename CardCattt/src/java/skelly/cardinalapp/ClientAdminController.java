package skelly.cardinalapp;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import skelly.data.ClientDB;

public class ClientAdminController extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "displayClients";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("displayClients")) {
            url = displayClients(request, response);
        } else if (action.equals("displayClient")) {
            url = displayClient(request, response);
        } else if (action.equals("addClient")) {
            url = "/client.jsp";
        } else if (action.equals("deleteClient")) {
            url = deleteClient(request, response);
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
            action = "displayClients";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("updateClient")) {
            url = updateClient(request, response);
        } else if (action.equals("deleteClient")) {
            url = deleteClient(request, response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String displayClients(HttpServletRequest request,
            HttpServletResponse response) {

        List<Client> clients = ClientDB.selectClients();
        request.setAttribute("clients", clients);
        return "/clients.jsp";
    }

    private String displayClient(HttpServletRequest request,
            HttpServletResponse response) {

        String clientCode = request.getParameter("clientCode");
        Client client;
        if (clientCode == null || clientCode.isEmpty()) {
            client = new Client();
        } else {
            client = ClientDB.selectClient(clientCode);
        }

        request.setAttribute("client", client);
        return "/client.jsp";
    }

    private String addClient(HttpServletRequest request,
            HttpServletResponse response) {

        return "/client.jsp";
    }

    private String updateClient(HttpServletRequest request,
            HttpServletResponse response) {

        int clientID;   
        clientID = Integer.parseInt(request.getParameter("ClientID"));
        String firstName = (String) request.getParameter("FirstName");
        String lastName = (String) request.getParameter("LastName");
        String email = (String) request.getParameter("Email");
        int insuranceCarrier;
        insuranceCarrier = Integer.parseInt(request.getParameter("InsuranceCarrier"));



        Client client = (Client) request.getAttribute("client");
        if (client == null) {
            client = new Client();
        }
        client.setClientID(clientID);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setInsuranceCarrier(insuranceCarrier);
        request.setAttribute("client", client);

        String message = "";
        if (client.getClientID() <= 0) {
            message = "You must enter a positive number for the price without "
                    + "any currency symbols.";
        }
        if (client.getFirstName().isEmpty()) {
            message = "You must enter a description for the client.";
        }
        if (client.getLastName().isEmpty()) {
            message = "You must enter a code for the client.";
        }
        request.setAttribute("message", message);

        String url;
        if (message.isEmpty()) {
            if (ClientDB.exists(client.getClientID())) {
                ClientDB.updateClient(client);
            } else {
                ClientDB.insertClient(client);
            }
            url = displayClients(request, response);
        } else {
            url = "/client.jsp";
        }
        return url;
    }
    
    private String deleteClient(HttpServletRequest request,
            HttpServletResponse response) {

        String clientCode = request.getParameter("clientCode");
        Client client = ClientDB.selectClient(clientCode);
        request.setAttribute("client", client);
        
        String url;
        String yesButton = request.getParameter("yesButton");
        if (yesButton != null) {
            ClientDB.deleteClient(client);
            url = displayClients(request, response);
        } else {
            url = "/confirm_client_delete.jsp";
        }
        return url;
    }    
}
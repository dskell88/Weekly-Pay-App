package skelly.data;

import skelly.cardinalapp.Client;
import java.sql.*;
import java.util.*;


public class ClientDB {

    //This method returns null if a client isn't found.
    public static Client selectClient(String startDate) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Client "
                + "WHERE startDate = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, startDate);
            rs = ps.executeQuery();
            if (rs.next()) {
                Client p = new Client();
                p.setClientID(rs.getInt("ClientID"));
                p.setInsuranceCarrier(rs.getInt("ClientCode"));
                p.setDepartment(rs.getInt("ClientInsuranceCarrier"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    //This method returns null if a client isn't found.
    public static Client selectClient(int clientID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Client "
                + "WHERE ClientID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, clientID);
            rs = ps.executeQuery();
            if (rs.next()) {
                Client p = new Client();
                p.setClientID(rs.getInt("ClientID"));
                p.setInsuranceCarrier(rs.getInt("ClientInsuranceCarrier"));
                p.setDepartment(rs.getInt("Department"));
                return p;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean exists(int ClientID) {
        Client p = selectClient(ClientID);
        if (p != null) return true;
        else return false;
    }    
    
    //This method returns null if a client isn't found.
    public static List<Client> selectClients() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Client";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Client> clients = new ArrayList<>();
            while (rs.next()) {
                Client cs = new Client();
                cs.setClientID(rs.getInt("ClientID"));
                cs.setFirstName(rs.getString("firstName"));
                cs.setLastName(rs.getString("firstName"));
                cs.setEmail(rs.getString("firstName"));
                cs.setPhoneNumber(rs.getString("firstName"));
                cs.setInsuranceCarrier(rs.getInt("ClientInsuranceCarrier"));
                cs.setDepartment(rs.getInt("Department"));
                clients.add(cs);
            }
            return clients;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void insertClient(Client client) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "INSERT INTO Client "
                + "(firstName, lastName, emailAddress, phoneNumber) "
                + "VALUES (?, ?, ?)";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, client.getClientID());
            ps.setInt(2, client.getInsuranceCarrier());
            ps.setDouble(3, client.getDepartment());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void updateClient(Client client) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE Client SET "
                + "ClientCode = ?, "
                + "ClientInsuranceCarrier = ?, "
                + "ClientPrice = ? "
                + "WHERE ClientCode = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, client.getClientID());
            ps.setInt(2, client.getInsuranceCarrier());
            ps.setInt(3, client.getDepartment());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void deleteClient(Client client) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "DELETE FROM Client WHERE ClientCode = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, client.getClientID());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}

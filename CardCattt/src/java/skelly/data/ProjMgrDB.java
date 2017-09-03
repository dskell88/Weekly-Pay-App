package skelly.data;

import skelly.business.ProjectManager;
import java.sql.*;
import java.util.*;


public class ProjMgrDB {

    //This method returns null if a project isn't found.
    public static ProjectManager selectProjectManager(String startDate) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM ProjectManager "
                + "WHERE ProjectManagerCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, startDate);
            rs = ps.executeQuery();
            if (rs.next()) {
                ProjectManager p = new ProjectManager();
                p.setProjID(rs.getInt("ProjectManagerID"));
                p.setStartDate(rs.getString("ProjectManagerStartDate"));
                p.setPayPlan(rs.getInt("ProjectManagerPayPlan"));
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

    //This method returns null if a project isn't found.
    public static ProjectManager selectProjectManager(long projectID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM ProjectManager "
                + "WHERE ProjectManagerID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setLong(1, projectID);
            rs = ps.executeQuery();
            if (rs.next()) {
                ProjectManager p = new ProjectManager();
                p.setProjID(rs.getInt("ProjectManagerID"));
                p.setStartDate(rs.getString("StartDate"));
                p.setPayPlan(rs.getDouble("PayPlan"));
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

    public static boolean exists(String projID) {
        ProjectManager p = selectProjectManager(projID);
        if (p != null) return true;
        else return false;
    }    
    
    //This method returns null if a project isn't found.
    public static List<ProjectManager> selectProjectManagers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM ProjectManager";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<ProjectManager> projects = new ArrayList<>();
            while (rs.next()) {
                ProjectManager pm = new ProjectManager();
                pm.setProjID(rs.getInt("ProjectManagerID"));
                pm.setStartDate(rs.getString("ProjectManagerStartDate"));
                pm.setPayPlan(rs.getDouble("PayPlan"));
                projects.add(pm);
            }
            return projects;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void insertProjectManager(ProjectManager project) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "INSERT INTO ProjectManager "
                + "(ProjectManagerCode, ProjectManagerStartDate, ProjectManagerPrice) "
                + "VALUES (?, ?, ?)";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, project.getProjID());
            ps.setString(2, project.getStartDate());
            ps.setDouble(3, project.getPayPlan());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void updateProjectManager(ProjectManager project) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE ProjectManager SET "
                + "ProjectManagerCode = ?, "
                + "ProjectManagerStartDate = ?, "
                + "ProjectManagerPrice = ? "
                + "WHERE ProjectManagerCode = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, project.getProjID());
            ps.setString(2, project.getStartDate());
            ps.setDouble(3, project.getPayPlan());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void deleteProjectManager(ProjectManager project) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "DELETE FROM ProjectManager WHERE ProjectManagerCode = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, project.getProjID());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}

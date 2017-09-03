package skelly.data;

import skelly.business.Job;
import skelly.cardinalapp.Client;
import skelly.business.ProjectManager;
import java.sql.*;
import java.util.*;


public class JobDB {

    //This method returns null if a job isn't found.
    public static Job selectJob(int JobID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Job "
                + "WHERE JobID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, JobID);
            rs = ps.executeQuery();
            if (rs.next()) {
                Job p = new Job();
                Client c = new Client();
                ProjectManager pm = new ProjectManager();
                p.setJobID(rs.getInt("JobID"));
                c.setClientID(rs.getInt("ClientID"));
                pm.setProjID(rs.getInt("JobDescription"));
                p.setJobProfit(rs.getString("JobProfit"));
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

    //This method returns null if a job isn't found.
    public static Job selectJob  (String jobProfit) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Job "
                + "WHERE JobID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, jobProfit);
            rs = ps.executeQuery();
            if (rs.next()) {
                Job p = new Job();
                Client c = new Client();
                ProjectManager pm = new ProjectManager();
                p.setJobID(rs.getInt("JobID"));
                c.setClientID(rs.getInt("ClientID"));
                pm.setProjID(rs.getInt("ProjectManagerID"));
                p.setJobProfit(rs.getString("JobProfit"));
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

    public static boolean exists(int JobID) {
        Job p = selectJob(JobID);
        if (p != null) return true;
        else return false;
    }    
    
    //This method returns null if a job isn't found.
    public static List<Job> selectJobs() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Job";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Job> jobs = new ArrayList<>();
            while (rs.next()) {
                Job p = new Job();
                Client c = new Client();
                ProjectManager pm = new ProjectManager();
                p.setJobID(rs.getInt("JobID"));
                c.setClientID(rs.getInt("ClientID"));
                pm.setProjID(rs.getInt("ProjectManagerID"));
                p.setJobProfit(rs.getString("JobProfit"));
                jobs.add(p);
            }
            return jobs;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void insertJob(Job job, Client client, ProjectManager pm) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "INSERT INTO Job "
                + "(jobID, clientID, projectManagerID, jobProfit) "
                + "VALUES (?, ?, ?, ?)";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, job.getJobID());
            ps.setInt(2, client.getClientID());
            ps.setInt(3, pm.getProjID());
            ps.setString(4, job.getJobProfit());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void updateJob(Job job, Client client, ProjectManager pm) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "UPDATE Job SET "
                + "jobID = ?, "
                + "clientID = ?, "
                + "jobProfit = ? "
                + "WHERE JobID = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, job.getJobID());
            ps.setInt(2, client.getClientID());
            ps.setInt(3, pm.getProjID());
            ps.setString(4, job.getJobProfit());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void deleteJob(Job job) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "DELETE FROM Job WHERE JobID = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, job.getJobID());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}

package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnect {

    private Connection conn = null;
    private Statement st = null;

    public MySQLConnect() {
        Connect();
    }

    private void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // conn = DriverManager.getConnection("jdbc:mysql://localhost/sieuthimini",
            // "root", "");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/new", "root", "");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void disConnect() {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException E) {
            System.out.println("Error: " + E.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void executeUpdate(String sql) {
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isConnect() {
        return conn != null;
    }

    public boolean isConnected() {
        try {
            return conn != null && !conn.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}

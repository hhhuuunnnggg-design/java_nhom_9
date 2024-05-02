/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHUONG ANH
 */
public class MySQLConnect {
    

    private String url="jdbc:mysql://localhost:3306/student_management?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String user="admin";
    private String password="1234";
    private Connection conn=null;
    private Statement st=null;
    
    public MySQLConnect(){};
    public void Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disConnect()
    { 
        try{
            st.close();
            conn.close();
        }catch (SQLException E){}
    }
    
    public ResultSet executeQuery(String sql)
    {
        ResultSet rs = null;
        try {
            Connect();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void executeUpdate(String sql)
    {
        try {
            Connect();
            st = conn.createStatement();
            st.executeUpdate(sql);
            disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection()
    {
        Connect();
        return conn;
    }
    public boolean isConnect()
    {
        return conn!=null?true:false;
    }
    public static void main(String[] args){
        new MySQLConnect();
    }
}

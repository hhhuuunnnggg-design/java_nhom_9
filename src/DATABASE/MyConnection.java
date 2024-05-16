package DATABASE;
//

import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {

    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/student_management?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        } catch (Exception e) {
            // TODO Auto-generated catch block
          System.out.println(e.getMessage());
        }
      return con;
    } 
}
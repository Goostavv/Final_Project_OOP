
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connector {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/patient?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]";
    static final String USER = "root";
    static final String PASS = ""; 
    public Connection Con;
    public Statement statement;
    



    public Connector(){
        try{
            Class.forName(JDBC_DRIVER);
            Con = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection success");
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    
}


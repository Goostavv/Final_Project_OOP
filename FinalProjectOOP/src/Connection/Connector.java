/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Menu.InputMedRec;
/**
 *
 * @author Gustav
 */
public class Connector {
    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/patient";
    String USER = "root";
    String PASS = ""; 
    String patient[][] = new String[500][5];
    public Connection Con;
    public Statement statement;
    InputMedRec in;
    



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
   public void insertData (String ID, String name, String age, String birth){
try {
String query = "INSERT INTO `patient` (`id`,`name`,`age`,`birth`)" + "VALUES('" + ID + "','" + name + "','" + age + "','" + birth + "')";
        statement = Con.createStatement();
        statement.executeUpdate(query);
        System.out.println("Input Success");
        JOptionPane.showMessageDialog(null, "Input Success");
}catch(Exception ex){
    System.out.println("Input Failed");
JOptionPane.showMessageDialog(null, ex.getMessage());}
}

public void updateData(String ID, String name, String age, String birth ){
        try {
            String query = "UPDATE `patient` SET `name` = '" 
                    + name + "', name = '" + age + 
                    "', birth = '" + birth + "' WHERE id = '" + ID + "'";
            statement = Con.createStatement();
            statement.executeUpdate(query);

            System.out.println("Update Success");
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception ex) {
            System.out.println("Update Failed : " + ex.getMessage());
        }
    }

public void login(String username, String password){
try {       ResultSet rs;
            String query = "SELECT * FROM login WHERE username='"+username+"' AND password='"+password+"'";
            statement = Con.createStatement();
            rs = statement.executeQuery(query);
            if(rs.next()){
                if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "login sucess");
                    InputMedRec input = new InputMedRec();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "wrong username or password ");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            
}

public String[][] readData(){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `patient`";
            statement = Con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){ //konversi tabel ke string
                patient[totalData][0] = resultSet.getString("ID");
                patient[totalData][1] = resultSet.getString("Name"); 
                patient[totalData][2] = resultSet.getString("Age"); 
                patient[totalData][3] = resultSet.getString("Birth");               
                totalData++; 
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        } finally {
            return patient;
        }
    }
    public void deleteData(String ID){
        try {
            String query = "DELETE FROM `patient` WHERE id='" + ID + "'";
            statement = Con.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete Successs");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
    }
}



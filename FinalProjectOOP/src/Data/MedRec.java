/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.ScrollPaneConstants;
    import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Connection.Connector;
import java.awt.HeadlessException;
/**
 *
 * @author Gustav
 */
public class MedRec {
    Connector Con = new Connector();
    //Statement statement = new Statement();
    public String[][] readContact(){
        try{
            int figures = 0;
            
            String data[][] = new String[getAmountData()][4]; 
            
            String query = "Select * from Patient"; 
            ResultSet resultSet = Con.statement.executeQuery(query);
            while (resultSet.next()){
                data[figures][0] = resultSet.getString("id"); 
                data[figures][1] = resultSet.getString("name");                
                data[figures][2] = resultSet.getString("age");
                data[figures][3] = resultSet.getString("birth");
                figures++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
     public int getAmountData(){
   
        try{
            int amntData = 0;
            //Statement = Con.createStatement();
            String query = "Select * from Patient";
            ResultSet resultSet = Con.statement.executeQuery(query);
            while (resultSet.next()){ 
                amntData++;
            }
            return amntData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
     
    public void insert(String ID, String name, String age, String birth){
        int no=0;
        try {
           String query = "Select * from Patient"; 
           ResultSet resultSet = Con.statement.executeQuery(query);
           
           while (resultSet.next()){ 
                no++;
            }
                query = "INSERT INTO MedRec VALUES('"+no+"','"+ID+"','"+name+"','"+age+"','"+birth+"')";
                
                Con.statement = (Statement) Con.Con.createStatement();
                Con.statement.executeUpdate(query); 
                JOptionPane.showMessageDialog(null, "Data Recorded Succesfully");
            }
         catch (HeadlessException | SQLException sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
       public void update(String ID, String name, String age, String birth){
        int no=0;
         try {
           String query = "Select * from Patient WHERE id=" + ID; 
           ResultSet resultSet = Con.statement.executeQuery(query);
           
           while (resultSet.next()){ 
                no++;
            }
           
             if (no==1) {
                query = "UPDATE Patient SET id='" + ID + "', name='" + name + "', age='" + age + "', birth='" + birth + "' WHERE id=" + ID;
                Con.statement = (Statement) Con.Con.createStatement();
                Con.statement.executeUpdate(query); //execute query
                System.out.println("Update Success");
                JOptionPane.showMessageDialog(null, "Update Failed");
             }
             else {
                 JOptionPane.showMessageDialog(null, "There is no data");
             }
           
        } catch (HeadlessException | SQLException sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    public void delete (String ID) {
        try{
            String query = "DELETE FROM Patient WHERE id = '"+ID+"'";
            Con.statement = Con.Con.createStatement();
            Con.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete Success");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}

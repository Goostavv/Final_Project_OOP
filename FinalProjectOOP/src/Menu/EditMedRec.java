/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import Connection.Connector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Gustav
 */

    public class EditMedRec extends JFrame {
     JLabel ltitle = new JLabel("Update Patient");
    
    Connector Connector = new Connector();
    JLabel lID = new JLabel("ID");
    public final JTextField fID = new JTextField(10);
    
    JLabel lname = new JLabel("Name");
    public final JTextField fname = new JTextField(10);
    
    public final JTextField fcheck = new JTextField(10);
    
    JLabel lage = new JLabel("Age");
    public final JTextField fage= new JTextField(10);
    
    JLabel lbirth = new JLabel("Birth");
    com.toedter.calendar.JDateChooser calendar = new com.toedter.calendar.JDateChooser();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    
    public JButton bupdate = new JButton("Update");
    public JButton bdelete = new JButton("Delete");
    
    public JButton bback = new JButton("back");
    
     public EditMedRec(String ID){
        setTitle("Update Patient");
        setSize(300,230);
        setLayout(null);
        add(ltitle);
//        add(lID);
//        add(fID);
        add(lname);
        add(fname);
        add(lage);
        add(fage);
        add(lbirth);
        add(calendar);  
        add(bupdate);
        add(bdelete); 
        add(bback);
        
        ltitle.setBounds(15,5,200,20);
//        lID.setBounds(15,30,120,20);
//        fID.setBounds(55,30,200,20);
        
        lname.setBounds(15,50,120,20);
        fname.setBounds(55,50,200,20);
        
        lage.setBounds(15,80,120,20);
        fage.setBounds(55,80,200,20);
        
        lbirth.setBounds(15,110,120,20);
        calendar.setBounds(55,110,200,20);
        
        bupdate.setBounds(55,130,90,20);
        bdelete.setBounds(155,130,90,20);
        bback.setBounds(15,165,250,20);
        
        bupdate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         try{   
               Connector.updateData(ID, getfname(), getfage(), getcalendar());
               dispose();
               ViewData view = new ViewData();
        }catch (Exception ex) {
            System.out.println("Update Failed : " + ex.getMessage());
        JOptionPane.showMessageDialog(null, "Update Failed");}
         
        }
    });
        bdelete.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
           try{ 
            fname.setText(null);
            fage.setText(null);
            calendar.setDate(null);
           }catch (Exception ex) {
               System.out.println("Delete Failed : " + ex.getMessage());
                       JOptionPane.showMessageDialog(null, "Delete Failed");
           }
        }
    });
        bback.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        dispose();
        Menu menu = new Menu();       
         
        }
    });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
    }
     
    public String getfID(){
        return fID.getText();
    }
    
    public String getfname(){
        return fname.getText();
    }
    
    public String getfage(){
        return fage.getText();
    }
    
    public String getcalendar(){
        String birth=""+calendar.getDate();
        return sdf.format(calendar.getDate());
    }
   }


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import Connection.Connector;

/**
 *
 * @author Gustav
 */
public class InputMedRec extends JFrame {
    Connector Connector = new Connector();
    
    JLabel ltitle = new JLabel("Input Patient");
    
    JLabel lID = new JLabel("ID");
    public final JTextField fID = new JTextField(10);
    
    JLabel lname = new JLabel("Name");
    public final JTextField fname = new JTextField(10);
    
    JLabel lage = new JLabel("Age");
    public final JTextField fage= new JTextField(10);
    
    JLabel lbirth = new JLabel("Birth");
    com.toedter.calendar.JDateChooser calendar = new com.toedter.calendar.JDateChooser();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
   
    
    public JButton bsubmit = new JButton("Submit");
    public JButton breset = new JButton("Reset");
    
    public JButton bback = new JButton("Back");
    
     public InputMedRec(){
        setTitle("Input Patient");
        setSize(300,230);
        setLayout(null);
        add(ltitle);
        add(lID);
        add(fID);
        add(lname);
        add(fname);
        add(lage);
        add(fage);
        add(lbirth);
        add(calendar);  
        add(bsubmit);
        add(breset); 
        add(bback);
        
        ltitle.setBounds(15,5,200,20);
        
        lID.setBounds(15,30,120,20);
        fID.setBounds(55,30,200,20);
        
        lname.setBounds(15,50,120,20);
        fname.setBounds(55,50,200,20);
        
        lage.setBounds(15,80,120,20);
        fage.setBounds(55,80,200,20);
        
        lbirth.setBounds(15,110,120,20);
        calendar.setBounds(55,110,200,20);
        
        bsubmit.setBounds(55,130,90,20);
        breset.setBounds(155,130,90,20);
        bback.setBounds(15,165,250,20);
        
        bsubmit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
               Connector.insertData(getfID(), getfname(), getfage(), getcalendar());
         
        }
    });
        breset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            fID.setText(null);
            fname.setText(null);
            fage.setText(null);
            calendar.setDate(null);
            
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

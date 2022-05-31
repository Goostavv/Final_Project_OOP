/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import Connection.Connector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustav
 */
public class ViewData extends JFrame {
    public String ID, name, age, birth;
    int totalData;
    Connector connector = new Connector();
    JFrame frame = new JFrame("JDBC");
    public JTable table;
    DefaultTableModel model;
    JScrollPane scrollPanel;
    String patient[][] = new String[500][4];
    public Object ColumnName[] = {"ID", "Name", "Age", "Birth"};
    
    public JButton bback = new JButton("back");
    
    
    public ViewData(){
        setTitle("Patient Data");
        setSize(750, 300);
        setLayout(null);
        add(bback);
        model = new DefaultTableModel(ColumnName, 0);
        table = new JTable(model);
        scrollPanel = new JScrollPane(table);
        
        scrollPanel = new JScrollPane(table);
        add(scrollPanel);
        
        scrollPanel.setBounds(15, 15, 700, 100);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        bback.setBounds(20, 200,700, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        
        bback.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
       
        Menu menu = new Menu();   
        dispose();
         
        }
    });
        showData();
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                
                String ID = table.getValueAt(row, 0).toString();
                System.out.println("data : " + ID);
                
                int input = JOptionPane.showConfirmDialog(null, 
                        "do you want to delete " + ID + "?", 
                        "Option...", 
                        JOptionPane.YES_NO_OPTION);
                
                if (input == 0){
                    // delete data
                    connector.deleteData(ID);
                    dispose();
                    ViewData view = new ViewData();
                } else {
                    // will not delete data
                    input = JOptionPane.showConfirmDialog(null, 
                        "do you want to update " + ID + "?", 
                        "Option...", 
                        JOptionPane.YES_NO_OPTION);
                    if (input == 0){
                         //go to update page/ui
                        dispose();
                        EditMedRec update = new EditMedRec(ID);
                        //Update update = new Update(ID);
                    }
                }
            }
        });
        
    }
    private void showData(){
        patient = connector.readData();
        table.setModel((new JTable(patient, ColumnName)).getModel());
    }
}


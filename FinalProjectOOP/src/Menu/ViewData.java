
package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import Connection.Connector;
import Main.Main;

public class ViewData extends JFrame {
    
    
    JFrame frame = new JFrame("JDBC");
    public JTable table;
    DefaultTableModel model;
    JScrollPane scrollPanel;
    String data[][] = new String[500][4];
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
    }
}

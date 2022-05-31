
package Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import main.*;


public class InputMedRec extends JFrame {
    JLabel ltitle = new JLabel("Input Patient");
    
    JLabel lname = new JLabel("Name");
    public final JTextField fname = new JTextField(10);
    
    JLabel lage = new JLabel("Age");
    public final JTextField fage= new JTextField(10);
    
    JLabel lbirth = new JLabel("Birth");
    public final JTextField fbirth = new JTextField(10);
    
    public JButton bsubmit = new JButton("Submit");
    public JButton breset = new JButton("Reset");
    
    public JButton bback = new JButton("Back");
    
     public InputMedRec(){
        setTitle("Input Patient");
        setSize(300,230);
        setLayout(null);
        add(ltitle);
        add(lname);
        add(fname);
        add(lage);
        add(fage);
        add(lbirth);
        add(fbirth);  
        add(bsubmit);
        add(breset); 
        add(bback);
        
        ltitle.setBounds(15,5,200,20);
        lname.setBounds(15,30,120,20);
        fname.setBounds(55,30,200,20);
        
        lage.setBounds(15,60,120,20);
        fage.setBounds(55,60,200,20);
        
        lbirth.setBounds(15,90,120,20);
        fbirth.setBounds(55,90,200,20);
        
        bsubmit.setBounds(55,130,90,20);
        breset.setBounds(155,130,90,20);
        bback.setBounds(15,165,250,20);
        
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
    }


    @Override
    public String getName(){
        return fname.getText();
    }
    
    public String getAge(){
        return fage.getText();
    }
    
    public String getBirth(){
        return fbirth.getText();
    }
}

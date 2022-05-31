package Menu;

import Panel.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import Data.MedRec;

public class Menu extends JFrame implements ActionListener{
    
    JLabel ltitle = new JLabel("Main Menu");
    
    JButton badd = new JButton("Add Patient");
    JButton bview = new JButton("View PAtient");
    
    
    @SuppressWarnings("LeakingThisInConstructor")
    public Menu(){
        setSize(155,120);
        setLayout(null);
        add(ltitle);
        add(badd);
        add(bview);
        
        ltitle.setBounds(70,5,200,20);
        
         
        badd.setBounds(0,30,200,20);
        bview.setBounds(0,60,200,20);
        
        
        badd.addActionListener(this);
        bview.addActionListener(this);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed (ActionEvent g){
        if(g.getSource() == badd){
           ViewData lh = new ViewData();
           lh.dispose();
           dispose();
           InputMedRec ik = new InputMedRec();
           EditMedRec ed = new EditMedRec();
           ed.dispose();
           MedRec md = new MedRec();
           Panel ct = new Panel(lh, md,ik,ed);
           
        }
        if(g.getSource() == bview){
           ViewData lh = new ViewData();
           InputMedRec ik = new InputMedRec();
           ik.dispose();
           EditMedRec ed = new EditMedRec();
           ed.dispose();
           MedRec md = new MedRec();
           Panel ct = new Panel(lh, md,ik,ed);
        }
    }
}  

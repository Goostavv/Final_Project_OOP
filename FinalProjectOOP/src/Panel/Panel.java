package Panel;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import Data.MedRec;
import Menu.*;

public class Panel {
    MedRec model;
    ViewData showView;
    InputMedRec input;
    EditMedRec edit;
    private Object bback;
    
    public Panel(ViewData tampilview, MedRec modell,InputMedRec inputk, EditMedRec editt){
        this.model = modell;
        this.showView = tampilview;
        this.input = inputk;
        this.edit = editt;
        
        if(model.getAmountData()!=0){
            String dataPatient[][] = model.readContact();
            showView.table.setModel((new JTable(dataPatient, showView.ColumnName)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Unavailable");
        }
        input.bsubmit.addActionListener((ActionEvent g) -> {
            String name = input.getName();
            String age = input.getAge();
            String birth =input.getBirth();
            model.insert(name, age, birth);
            
            String dataPatient[][] = model.readContact();
            showView.table.setModel((new JTable(dataPatient, showView.ColumnName)).getModel());
        });
         input.bback.addActionListener((ActionEvent g) -> {
             input.dispose();
             Menu m = new Menu();
        });
         
        input.breset.addActionListener((ActionEvent g) -> {
            input.fname.setText(null);
            input.fage.setText(null);
            input.fbirth.setText(null);
        });
        edit.bback.addActionListener((ActionEvent g) -> {
            edit.dispose();
        });
        showView.bback.addActionListener((ActionEvent g) -> {
            showView.dispose();
        });
        edit.bupdate.addActionListener((ActionEvent ae) -> {
            String name = edit.getName();
            String check = edit.getCheck();
            String age = edit.getAge();
            String birth =edit.getBirth();
            model.update(name,check, age, birth);
            edit.dispose();
        });
        edit.bdelete.addActionListener((ActionEvent ae) -> {
            String check = edit.getCheck();
            model.delete(check);
            edit.dispose();
        });
              showView.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int line = showView.table.getSelectedRow();
                
                String id = showView.table.getValueAt(line, 0).toString();
                String name = showView.table.getValueAt(line, 1).toString();
                String age = showView.table.getValueAt(line, 2).toString();
                String birth = showView.table.getValueAt(line, 3).toString();
                
                showView.dispose();
                EditMedRec ed = new EditMedRec();
                ed.fname.setText(name);
                ed.fcheck.setText(id);
                ed.fage.setText(age);
                ed.fbirth.setText(birth);
                ViewData lh = new ViewData();
                lh.dispose();
                InputMedRec ik = new InputMedRec();
                ik.dispose();
                MedRec md = new MedRec();
                Panel ct = new Panel(lh,md,ik,ed);
                System.out.println("");
                        
            }
        }
        );
    }
    
    
    
}

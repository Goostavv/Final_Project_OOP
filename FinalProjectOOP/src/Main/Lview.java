/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Gustav
 */
public class Lview extends JFrame{
    JPanel pane = new JPanel();
    JLabel ltitle = new JLabel("LOGIN");
    JLabel textatas = new JLabel("Welcome to Medical Record ");

    JLabel lusername = new JLabel("Username");
    JLabel lpassword = new JLabel("Password");

    JTextField tfusername = new JTextField();
    JPasswordField tfpassword = new JPasswordField();

    JButton btnlogin = new JButton("Login");
    JButton btnexit = new JButton("exit");
    JButton guest = new JButton("Login as Guest");

    Font fontTitle = new Font("SanSerif Bold", Font.PLAIN, 40);

    public Lview() {
        ltitle.setFont(new Font("Times New Roman",Font.BOLD,40));
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocation(400,100);
        setSize(450,500);

        pane.setBounds(0,0,450,525);
        pane.setVisible(true);
        pane.setLayout(null);
        add(pane);

        pane.add(ltitle);
        ltitle.setBounds(135,50,200,50);

        pane.add(textatas);
        textatas.setBounds(104,110,250,20);
        pane.add(lusername);
        lusername.setBounds(100,150,100,20);

        pane.add(tfusername);
        tfusername.setBounds(200,150,120,20);

        pane.add(lpassword);
        lpassword.setBounds(100,210,100,20);

        pane.add(tfpassword);
        tfpassword.setBounds(200,210,120,20);

        pane.add(btnlogin);
        btnlogin.setBounds(100,270,100,20);
        
        pane.add(guest);
        guest.setBounds(110, 310, 200, 20);

        pane.add(btnexit);
        btnexit.setBounds(220,270,100,20);
    }
    
    public String getUsername(){
        return tfusername.getText();
    }

    public String getPassword(){
        String passtext = new String(tfpassword.getPassword());
        return passtext;
    }
    
    public JTextField getUsername2(){
        return tfusername;
    }
}


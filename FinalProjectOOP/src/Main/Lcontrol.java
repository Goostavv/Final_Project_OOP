/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Connection.Connector;

/**
 *
 * @author Gustav
 */
public class Lcontrol {
    Lview lv;
    Connector connector = new Connector();

    public Lcontrol(Lview lv) {
        this.lv = lv;

        lv.btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String username, password;
                    username = lv.getUsername();
                    password = lv.getPassword();
                    connector.login(username, password);
                    Connector connector = new Connector();
                }
        });
                    
lv.btnexit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            System.exit(0);
                        }
                    });
    
//    lv.guest.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent ae) {
//                        Inputform2 input = new Inputform2();
//                        }
//                    });

    }
}


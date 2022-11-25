package main;

import java.awt.event.*;

public class Controller implements ActionListener {
    Dict list;
    Controller(Dict list){
        this.list = list;
    }
    public void actionPerformed(ActionEvent e) {
//        String src = e.getActionCommand();
        System.out.println("Hello");
    }
}

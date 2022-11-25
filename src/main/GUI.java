package main;

import javax.swing.*;

public class GUI {
    JFrame main;

    GUI(){
        main = new JFrame();
    }

    public void createAndShowGUI(){
        main.setTitle("Slang Dict");
        main.setSize(400, 600);

        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
}

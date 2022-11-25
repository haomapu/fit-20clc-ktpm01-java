package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GUI extends JFrame{
    Dict list;
    GUI() throws IOException{
        list = new Dict();

        this.init();
    }

    public void init() throws IOException {
        list.getData();
        createAndShowGUI();
    }
    public void createAndShowGUI(){
        this.setTitle("Slang Dict");
        this.setSize(800, 500);
        this.setLocation(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Controller ct = new Controller(list);

        JPanel buttons = new JPanel();
        JPanel temp = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
        temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
        JButton searchWordBtn = new JButton("Search Word");
        JButton searchDefBtn = new JButton("Search Definition");
        JButton history = new JButton("History");
        JButton addWord = new JButton("Add new word");
        JButton editWord = new JButton("Edit a word");
        JButton deleteWord = new JButton("Delete a word");

        buttons.add(searchWordBtn);
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(searchDefBtn);
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(history);
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(addWord);
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(editWord);
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(deleteWord);
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

        temp.add(buttons);

        //Bottom panel
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton resetBtn = new JButton("RESET");
        JButton cancelBtn = new JButton("Cancel");
        bottom.add(resetBtn);
        bottom.add(cancelBtn);

        this.setLayout(new BorderLayout());

        this.add(temp, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.PAGE_END);
        this.setVisible(true);
    }
}

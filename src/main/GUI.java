package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class GUI{
    JFrame mainUI;
    JFrame popUp;
    JFrame deletePopUp;
    JFrame editPopUp;
    JPanel buttons;
//    JPanel buttons;
    JPanel bottom;
    JPanel searchBox;
    JTextArea resSearch;
    JTextField inputSearch;
    JTextField inputAdd;
    JTextArea defAdd;
    JPanel addUI;
    JPanel menu;
    JPanel editUI;
    JPanel deleteUI;
    JPanel randomUI;
    JTextField inputDel;
    JTextField inputEdit;
    JTextArea editArea;
    JTextField inputEditTemp;
    JLabel randomWord;
    JLabel randomDef;


    Controller ct;
    Font f;

    Dict list;
    GUI() throws IOException{
        list = new Dict();

        mainUI = new JFrame();
        editPopUp = new JFrame();
        deletePopUp = new JFrame();
        menu = new JPanel();
        buttons = new JPanel();
        randomUI = new JPanel();
        bottom = new JPanel();
        searchBox = new JPanel();
        resSearch = new JTextArea(10,10);
        inputSearch = new JTextField(10);
        inputAdd = new JTextField(10);
        inputDel = new JTextField(20);
        inputEdit = new JTextField(20);
        inputEditTemp = new JTextField(20);
        editArea = new JTextArea(10, 10);
        defAdd = new JTextArea();
        ct = new Controller(this);
        popUp = new JFrame();
        addUI = new JPanel();
        editUI = new JPanel();
        deleteUI = new JPanel();
        randomWord = new JLabel("");
        randomDef = new JLabel("");
        f = new Font("Helvetica", Font.BOLD, 17);
        this.init();
    }

    public void init() throws IOException {
        mainUI.setTitle("Slang Dict");
        mainUI.setSize(800, 500);
        mainUI.setLocation(600, 300);
        mainUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        list.getData();
        createAndShowMainUI();
        createAddUI();
        createPopUp();
        createSearchUI();
        createEditWordUI();
        createDeletePopUp();
        createDeleteUI();
        createRandomUI();
        mainUI.setVisible(true);

    }
    public JButton addAButton(String x){
        JButton temp = new JButton(x);
        temp.addActionListener(ct);
        temp.setAlignmentX(Component.CENTER_ALIGNMENT);
        temp.setMaximumSize(new Dimension(200, 40));
        temp.setFont(f);
        return temp;
    }
    public void createAndShowMainUI(){
        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuLabel.setFont(new Font("Helvetica", Font.BOLD, 30));
        menuLabel.setForeground(Color.red);
        menu.add(menuLabel);
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        buttons.add(addAButton("Search Word"));
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(addAButton("Search Definition"));
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(addAButton("History"));
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(addAButton("Add New Word"));
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(addAButton("Edit A Word"));
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(addAButton("Delete A Word"));
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(addAButton("Random A Word"));
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(addAButton("Game 1"));
        buttons.add(Box.createRigidArea(new Dimension(5, 5)));
        buttons.add(addAButton("Game 2"));
        //Bottom panel
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton resetBtn = new JButton("Reset");
        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(ct);
        resetBtn.addActionListener(ct);
        backBtn.setFont(f);
        resetBtn.setFont(f);
        bottom.add(resetBtn);
        bottom.add(backBtn);

        mainUI.setLayout(new BorderLayout());

        mainUI.add(menu, BorderLayout.PAGE_START);
        mainUI.add(buttons, BorderLayout.CENTER);
        mainUI.add(bottom, BorderLayout.PAGE_END);
    }

    // Create searching UI
    public void createSearchUI(){
        searchBox.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel word = new JLabel("Word");
        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(ct);

        searchBox.add(word);
        searchBox.add(inputSearch);
        searchBox.add(searchBtn);
    }
    // Create pop ui UI
    public void createPopUp(){
        popUp.setTitle("Confirm");
        popUp.setSize(400, 200);
        popUp.setLocation(800, 400);
        popUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        popUp.setLayout(new BorderLayout());
        JPanel addTitle = new JPanel();
        JLabel popUpTitle = new JLabel("The word already exist");
        popUpTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        addTitle.add(popUpTitle);

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
        JButton cancelBtn = new JButton("Cancel");
        JButton overwriteBtn = new JButton("Overwrite");
        JButton duplicateBtn = new JButton("Duplicate");
        buttons.add(cancelBtn);
        buttons.add(overwriteBtn);
        buttons.add(duplicateBtn);
        cancelBtn.setFont(f);
        overwriteBtn.setFont(f);
        duplicateBtn.setFont(f);
        cancelBtn.addActionListener(ct);
        overwriteBtn.addActionListener(ct);
        duplicateBtn.addActionListener(ct);
        popUp.add(addTitle, BorderLayout.PAGE_START);
        popUp.add(buttons, BorderLayout.CENTER);
        popUp.setVisible(false);
    }


    //Create add new word UI
    public void createAddUI(){
        addUI.setLayout(new BoxLayout(addUI, BoxLayout.Y_AXIS));

        JLabel wordLabel = new JLabel("Word");
        JLabel defLabel = new JLabel("Definition");
        JButton addBtn = addAButton("Add");
        inputAdd.setMaximumSize( new Dimension( 500, 30) );
        defAdd.setMaximumSize(new Dimension(500, 300));
        defAdd.setMinimumSize(new Dimension(500, 300));

        defLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        wordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
        defAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
        addBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        addUI.add(wordLabel);
        addUI.add(inputAdd);
        addUI.add(defLabel);
        addUI.add(defAdd);
        addUI.add(Box.createRigidArea(new Dimension(0, 20)));
        addUI.add(addBtn);
    }

    public void createDeletePopUp(){
        deletePopUp.setTitle("Confirm");
        deletePopUp.setSize(400, 200);
        deletePopUp.setLocation(800, 400);
        deletePopUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        deletePopUp.setLayout(new BorderLayout());
        JPanel deleteTitle = new JPanel();
        JLabel popUpTitle = new JLabel("Do you want to delete it?");
        popUpTitle.setFont(f);
        popUpTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteTitle.add(popUpTitle);
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
        JButton yesBtn = new JButton("Yes");
        JButton noBtn = new JButton("No");
        buttons.add(yesBtn);
        buttons.add(noBtn);
        yesBtn.setFont(f);
        noBtn.setFont(f);
        yesBtn.addActionListener(ct);
        noBtn.addActionListener(ct);

        deletePopUp.add(deleteTitle, BorderLayout.PAGE_START);
        deletePopUp.add(buttons, BorderLayout.CENTER);

        deletePopUp.setVisible(false);
    }
    public void createEditWordUI(){
        editUI.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel word = new JLabel("Word");
        JButton searchBtn = new JButton("Search Edit");
        searchBtn.addActionListener(ct);


        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        JButton editBtn = addAButton("Edit");

        editBtn.addActionListener(ct);
        JLabel inputEditTempL = new JLabel("New word (if have)");
        inputEditTempL.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputEditTemp.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputEditTemp.setPreferredSize(new Dimension(300, 20));
        inputEditTemp.setMinimumSize(new Dimension(300, 20));
        inputEditTemp.setMaximumSize(new Dimension(300, 20));

        editArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(inputEditTempL);
        center.add(inputEditTemp);
        center.add(Box.createRigidArea(new Dimension(5, 10)));
        center.add(editArea);
        center.add(Box.createRigidArea(new Dimension(5, 10)));
        center.add(editBtn);
        center.add(Box.createRigidArea(new Dimension(5, 10)));


        top.add(word);
        top.add(inputEdit);
        top.add(searchBtn);

        editUI.add(top, BorderLayout.PAGE_START);
        editUI.add(center, BorderLayout.CENTER);
    }

    public void createRandomUI(){
        randomUI.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        JLabel title = new JLabel("Random Word");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        top.add(title);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        JPanel flow1 = new JPanel();
        flow1.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        JLabel word = new JLabel("Word:");
        word.setFont(f);
        randomWord.setFont(f);

        flow1.add(word);
        flow1.add(randomWord);

        JPanel flow2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 15));
        JLabel def = new JLabel("Definition");
        def.setFont(f);
        randomDef.setFont(f);
        flow2.add(def);
        flow2.add(randomDef);
        JButton randomBtn = addAButton("Random");

        center.add(flow1);
        center.add(flow2);
        center.add(randomBtn);
        randomUI.add(top, BorderLayout.PAGE_START);
        randomUI.add(center, BorderLayout.CENTER);
    }

    public void setRandomUI(){
        mainUI.remove(buttons);
        mainUI.remove(menu);
        mainUI.add(randomUI, BorderLayout.CENTER);
        mainUI.setVisible(false);
        mainUI.setVisible(true);
    }
    public void setEditUI(){
        mainUI.remove(buttons);
        mainUI.remove(menu);
        mainUI.add(editUI, BorderLayout.CENTER);
        mainUI.setVisible(false);
        mainUI.setVisible(true);
    }
    public void createDeleteUI(){
        deleteUI.setLayout(new BorderLayout());
        JPanel top = new JPanel();
        JLabel deleteTitle = new JLabel("Enter word you want to delete");
        deleteTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteTitle.setFont(f);
        top.add(deleteTitle);
        JPanel center = new JPanel();
        center.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setFont(f);
        deleteBtn.addActionListener(ct);
        inputDel.setMaximumSize(new Dimension(300, 35));
        inputDel.setMinimumSize(new Dimension(300, 35));
        inputDel.setPreferredSize(new Dimension(300, 35));
        center.add(inputDel);
        center.add(deleteBtn);
        deleteUI.add(top, BorderLayout.PAGE_START);
        deleteUI.add(center, BorderLayout.CENTER);
    }

    public void setDeleteUI(){
        mainUI.remove(buttons);
        mainUI.remove(menu);
        mainUI.add(deleteUI, BorderLayout.CENTER);
        mainUI.setVisible(false);
        mainUI.setVisible(true);
    }
    //Add new word UI to main UI and remove old UI from main UI
    public void setAddUI(){
        mainUI.remove(buttons);
        mainUI.remove(menu);
        mainUI.add(addUI, BorderLayout.CENTER);
        mainUI.setVisible(false);
        mainUI.setVisible(true);
    }

    //Searching UI
    public void searchUI(){
        mainUI.remove(buttons);
        mainUI.remove(menu);
        mainUI.add(searchBox, BorderLayout.PAGE_START );
        mainUI.add(resSearch, BorderLayout.CENTER);
        mainUI.setVisible(false);
        mainUI.setVisible(true);
    }

    // back to main UI
    public void backUI(){
        mainUI.remove(searchBox);
        mainUI.remove(resSearch);
        mainUI.remove(addUI);
        mainUI.remove(deleteUI);
        mainUI.remove(editUI);
        mainUI.remove(randomUI);
        mainUI.add(buttons, BorderLayout.CENTER);
        mainUI.add(menu, BorderLayout.PAGE_START);
        resSearch.setText("");
        inputSearch.setText("");
        mainUI.setVisible(false);
        mainUI.setVisible(true);
    }

    public void getSearchWord(){
        String word = inputSearch.getText();
        resSearch.setText(list.searchByWord(word)); // Chua chinh xuong dong voi nghia moi
        list.history(word);
    }

    public void getSearchDef(){
        String temp = "";
        for (String i : list.searchByDef(inputSearch.getText())){
            temp += i + '\n';
        }

        resSearch.setText(temp);
    }

    public boolean addWord(){
        String word = inputAdd.getText(); // chua lam nut cancel
        String def = defAdd.getText();
        return list.addNewWord(word, def);
    }

}

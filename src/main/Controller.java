package main;

import java.awt.event.*;
import java.io.IOError;
import java.io.IOException;

public class Controller implements ActionListener {
    GUI list;
    int type;
    boolean check;
    Controller(GUI list){
        this.list = list;
        type = 0;
        check = true;
    }
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Search Word")){
            type = 1;
            list.searchUI();
        } else if (src.equals("Search Definition")){
            type = 2;
            list.searchUI();
        } else if (src.equals("Add New Word")) {
            list.setAddUI();
        } else if (src.equals("Back")) {
            list.backUI();
        } else if (src.equals("Search") && type == 1){
            list.getSearchWord();
        } else if (src.equals("Search") && type == 2){
            list.getSearchDef();
        } else if (src.equals("Add")){
            check = list.addWord();
            if (!check){
                list.popUp.setVisible(true);
            }
        } else if(src.equals("Delete A Word")) {
            list.setDeleteUI();
        } else if (src.equals("Overwrite")) {
            String word = list.inputAdd.getText();
            String def = list.defAdd.getText();
            list.list.updateDef(word, def);
            list.popUp.setVisible(false);
        } else if (src.equals("Duplicate")) {
            String word = list.inputAdd.getText();
            String def = list.defAdd.getText();
            list.list.duplicateWord(word, def);
            list.popUp.setVisible(false);
        } else if (src.equals("Reset")) {
            try {
                list.list.getData();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (src.equals("Yes")) {
            list.list.removeWord(list.inputDel.getText());
            list.deletePopUp.setVisible(false);
        } else if (src.equals("No")) {
            list.deletePopUp.setVisible(false);
        } else if (src.equals("Delete")) {
            list.deletePopUp.setVisible(true);
        } else if (src.equals("Edit A Word")) {
            list.setEditUI();
        } else if (src.equals("Edit")){
            String str = list.inputEdit.getText();
            String temp = list.inputEditTemp.getText();
            if (temp != ""){
                list.list.updateWord(str, temp);
            }
            String def = list.editArea.getText();
//            if (list.editArea.getText().contains('\n')){
//
//            }
            list.list.updateDef(str, list.editArea.getText());
        } else if (src.equals("Search Edit")) {
            list.editArea.setText(list.list.searchByWord(list.inputEdit.getText())); // Chinh popup thong bao successful
        } else if (src.equals("Random A Word")) {
            list.setRandomUI();
        } else if (src.equals("Random")){
            String str = list.list.randomWord();
            list.randomWord.setText(str);
            list.randomDef.setText(list.list.searchByWord(str));
        }


    }
}

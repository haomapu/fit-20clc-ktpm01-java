package main;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Controller implements ActionListener {
    GUI list;
    int type;
    boolean check;
    String resQ;
    String resW;
    String temp;

    Controller(GUI list){
        this.list = list;
        type = 0;
        temp = "";
        resQ = "";
        resW = "";
        check = true;
    }
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        JButton srcV = (JButton)e.getSource();
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
        } else if (src.equals("Quiz 1") || srcV.equals(list.answer1) || srcV.equals(list.answer2) || srcV.equals(list.answer3)|| srcV.equals(list.answer4)) {
            ArrayList<String> multipleChoice = new ArrayList<>();
            Random random = new Random();
            HashMap<String, String> mulShuf = new HashMap<>();
            if (src.equals("Quiz 1")){
                resW = list.list.randomWord();
                list.setQuiz1UI();
                multipleChoice.add(resW);
                multipleChoice.add(list.list.randomWord());
                multipleChoice.add(list.list.randomWord());
                multipleChoice.add(list.list.randomWord());

                mulShuf.put("A", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("A"));
                mulShuf.put("B", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("B"));
                mulShuf.put("C", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("C"));
                mulShuf.put("D", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("D"));
                list.randomWordQuiz.setText(resW);
                list.answer1.setText(list.list.searchByWord(mulShuf.get("A")));
                list.answer2.setText(list.list.searchByWord(mulShuf.get("B")));
                list.answer3.setText(list.list.searchByWord(mulShuf.get("C")));
                list.answer4.setText(list.list.searchByWord(mulShuf.get("D")));
            } else if (src.equals(list.list.searchByWord(resW))){
                resW = list.list.randomWord();
                JOptionPane.showMessageDialog(null, "Congratulation");
                multipleChoice.add(resW);
                multipleChoice.add(list.list.randomWord());
                multipleChoice.add(list.list.randomWord());
                multipleChoice.add(list.list.randomWord());

                mulShuf.put("A", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("A"));
                mulShuf.put("B", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("B"));
                mulShuf.put("C", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("C"));
                mulShuf.put("D", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("D"));
                list.randomWordQuiz.setText(resW);
                list.answer1.setText(list.list.searchByWord(mulShuf.get("A")));
                list.answer2.setText(list.list.searchByWord(mulShuf.get("B")));
                list.answer3.setText(list.list.searchByWord(mulShuf.get("C")));
                list.answer4.setText(list.list.searchByWord(mulShuf.get("D")));
            }
            else {
                JOptionPane.showMessageDialog(null, "Wrong");

            }

        }
        else if (src.equals("Quiz 2") || srcV.equals(list.answer12) || srcV.equals(list.answer22) || srcV.equals(list.answer32)|| srcV.equals(list.answer42)) {
            ArrayList<String> multipleChoice = new ArrayList<>();
            Random random = new Random();
            HashMap<String, String> mulShuf = new HashMap<>();

            if (src.equals("Quiz 2")){
                resQ = list.list.randomWord();
                list.setQuiz2UI();
                multipleChoice.add(resQ);
                multipleChoice.add(list.list.randomWord());
                multipleChoice.add(list.list.randomWord());
                multipleChoice.add(list.list.randomWord());

                mulShuf.put("A", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("A"));
                mulShuf.put("B", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("B"));
                mulShuf.put("C", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("C"));
                mulShuf.put("D", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("D"));
                list.randomDefQuiz.setText(list.list.searchByWord(resQ));
                list.answer12.setText(mulShuf.get("A"));
                list.answer22.setText(mulShuf.get("B"));
                list.answer32.setText(mulShuf.get("C"));
                list.answer42.setText(mulShuf.get("D"));
            } else if (src.equals(resQ)){
                resQ = list.list.randomWord();
                JOptionPane.showMessageDialog(null, "Congratulation");
                multipleChoice.add(resQ);
                multipleChoice.add(list.list.randomWord());
                multipleChoice.add(list.list.randomWord());
                multipleChoice.add(list.list.randomWord());

                mulShuf.put("A", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("A"));
                mulShuf.put("B", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("B"));
                mulShuf.put("C", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("C"));
                mulShuf.put("D", multipleChoice.get(random.nextInt(multipleChoice.size())));
                multipleChoice.remove(mulShuf.get("D"));
                list.randomDefQuiz.setText(list.list.searchByWord(resQ));
                list.answer12.setText(mulShuf.get("A"));
                list.answer22.setText(mulShuf.get("B"));
                list.answer32.setText(mulShuf.get("C"));
                list.answer42.setText(mulShuf.get("D"));
            }
            else {
                JOptionPane.showMessageDialog(null, "Wrong");

            }
        } else if (src.equals("History")) {
            for (String i : list.list.his){
                temp += i +  '\n';
            }
            list.historyOut.setText(temp);
            list.setHistoryUI();
            temp = "";
        } else if (src.equals("Cancel")){
            list.popUp.setVisible(false);
        }


    }
}

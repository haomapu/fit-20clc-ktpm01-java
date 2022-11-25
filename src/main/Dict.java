package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Dict {
    HashMap<String, String> list;
    ArrayList<String> his;
    Dict(){
        list = new HashMap<>();
        his = new ArrayList<>();
    }

    public int getSize(){
        return list.size();
    }
    public void getData()throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("slang.txt"));
        String str;
        String prev = "";
        while (true)
        {
            str = br.readLine();
            if (str==null)
                break;
            String[] arrOfStr = str.split("`");
            if ( arrOfStr.length == 1){
                continue;
            }else if(arrOfStr[0] == prev){
                list.put(prev, "/" + arrOfStr[1]);
            }else{
                list.put(arrOfStr[0], arrOfStr[1]);

            }
            prev = arrOfStr[0];
        }
    }

    public String searchByWord(String word){
        if (list.get(word) == null) {
            return "1";
        }
        return list.get(word);
    }

    public void searchByDef(String def){
        list.forEach((key, value) -> {
            if(value.contains(def)) {
                System.out.println(key);
            }
        });
    }

    public void updateWord(String word, String newWord){
        String temp = list.get(word);
        list.remove(word);
        list.put(newWord, temp);
    }

    public void updateDef(String word, String newDef){
        list.put(word, newDef);
    }

    public boolean addNewWord(String word, String def){
        if (list.get(word) == null){
            list.put(word, def);
            return true;
        }
        return false;
    }

    public void duplicateWord(String word, String def){
        list.put(word, "/" + def);
    }

    public void removeWord(String word){
        list.remove(word);
    }
    public String randomWord(){
        Random random = new Random();
        List<String> keys = new ArrayList<>(list.keySet());
        String randomKey = keys.get(random.nextInt(keys.size()));
        return randomKey;
    }

    public void history(String word){
        for (String i : his){
            if (word == i){
                list.remove(i);
            }
        }
        his.add(0, word);
    }
}

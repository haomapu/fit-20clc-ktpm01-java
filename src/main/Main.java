package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean game1(Dict list){
        String res = list.randomWord();
        ArrayList<String> multipleChoice = new ArrayList<>();
        multipleChoice.add(res);
        multipleChoice.add(list.randomWord());
        multipleChoice.add(list.randomWord());
        multipleChoice.add(list.randomWord());
        Random random = new Random();
        HashMap<String, String> mulShuf = new HashMap<>();
        mulShuf.put("A", multipleChoice.get(random.nextInt(multipleChoice.size())));
        multipleChoice.remove(mulShuf.get("A"));
        mulShuf.put("B", multipleChoice.get(random.nextInt(multipleChoice.size())));
        multipleChoice.remove(mulShuf.get("B"));
        mulShuf.put("C", multipleChoice.get(random.nextInt(multipleChoice.size())));
        multipleChoice.remove(mulShuf.get("C"));
        mulShuf.put("D", multipleChoice.get(random.nextInt(multipleChoice.size())));
        multipleChoice.remove(mulShuf.get("D"));
        System.out.println(res);
        System.out.println(list.searchByWord(mulShuf.get("A")));
        System.out.println(list.searchByWord(mulShuf.get("B")));
        System.out.println(list.searchByWord(mulShuf.get("C")));
        System.out.println(list.searchByWord(mulShuf.get("D")));
        System.out.println("Enter answer: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (res == mulShuf.get(str)){
            return true;
        }
        return false;
    }

    public static boolean game2(Dict list){
        String res = list.randomWord();
        ArrayList<String> multipleChoice = new ArrayList<>();
        multipleChoice.add(res);
        multipleChoice.add(list.randomWord());
        multipleChoice.add(list.randomWord());
        multipleChoice.add(list.randomWord());
        Random random = new Random();
        HashMap<String, String> mulShuf = new HashMap<>();
        mulShuf.put("A", multipleChoice.get(random.nextInt(multipleChoice.size())));
        multipleChoice.remove(mulShuf.get("A"));
        mulShuf.put("B", multipleChoice.get(random.nextInt(multipleChoice.size())));
        multipleChoice.remove(mulShuf.get("B"));
        mulShuf.put("C", multipleChoice.get(random.nextInt(multipleChoice.size())));
        multipleChoice.remove(mulShuf.get("C"));
        mulShuf.put("D", multipleChoice.get(random.nextInt(multipleChoice.size())));
        multipleChoice.remove(mulShuf.get("D"));
        System.out.println(res);
        System.out.println(mulShuf.get("A"));
        System.out.println(mulShuf.get("B"));
        System.out.println(mulShuf.get("C"));
        System.out.println(mulShuf.get("D"));
        System.out.println("Enter answer: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (res == mulShuf.get(str)){
            return true;
        }
        return false;
    }
    public static void main(String[] args)throws IOException {
//        System.out.println(game1(list));
//        list.searchByWord("AMA");
//        list.searchByDef("Angel");
        GUI ui = new GUI();
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static HashMap<String, String> getData()throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("slang.txt"));
        String str;
        HashMap<String, String> res = new HashMap<>();
        while (true)
        {
            str = br.readLine();
            if (str==null)
                break;
            String[] arrOfStr = str.split("`");
            if ( arrOfStr.length == 1){
                continue;
            }else{
                res.put(arrOfStr[0], arrOfStr[1]);
            }
        }
        return res;
    }
    public static void main(String[] args)throws IOException {
        HashMap<String, String> list = getData();
        System.out.println(list.size());
    }
}
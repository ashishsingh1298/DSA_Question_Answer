import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        int mf = 0;
        char mfc = 'a';
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length();i++){
            char ch  = str.charAt(i);
            if(map.containsKey(ch) == true){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch,1);
            }
            
            if(map.get(ch) > mf){
                mf = map.get(ch);
                mfc = ch;
            }
        }
        System.out.println(mfc);
    }

}
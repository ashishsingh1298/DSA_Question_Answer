import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    printKPC(str, "");
    
    }
    
    static String[]  keys = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void printKPC(String str, String asf) {
            
         if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        
        char ch = str.charAt(0);
        String ros = str.substring(1);
        
        String code = keys[ch-'0'];
        
        for (int i = 0; i < code.length(); i++){
            
            char c = code.charAt(i);
            printKPC(ros, asf + c);
    
        }
                
    }

}
// find distinct dates in a string.

import java.util.*;
public class Main{
    public static void main(String[] args){
        String str = "my name is 12-04-2020 why you do thiss 13-11-2012 asf asefwe 12-09-2020 pras wcsa 23-12-2015";
        HashMap<String,Integer> map  = new HashMap<>();
        String[] arrOfStr = str.split(" ", -1);
        for(int i = 0; i < arrOfStr.length;i++){
            String s = arrOfStr[i];
            if(Character.isDigit(s.charAt(0)) == true){
                String sub = s.substring(6,s.length());
                map.put(sub,1);
            }
        }
        System.out.println(map.size());
    }
}
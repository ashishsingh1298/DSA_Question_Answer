// 1. You are given a string str of digits. (will never start with a 0)
// 2. You are required to encode the str as per following rules
//     1 -> a
//     2 -> b
//     3 -> c
//     ..
//     25 -> y
//     26 -> z
// 3. You are required to calculate and print the count of encodings for the string str.

//      For 123 -> there are 3 encodings. abc, aw, lc
//      For 993 -> there is 1 encoding. iic 
//      For 013 -> This is an invalid input. A string starting with 0 will not be passed.
//      For 103 -> there is 1 encoding. jc
//      For 303 -> there are 0 encodings. But such a string maybe passed. In this case 
//      print 0.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        System.out.println(ceR(str,0)); //Recursive call
    }
    public static int ceR(String str, int idx){
        if(idx == str.length()){
            return 1;
        }
        if(str.charAt(idx) == '0'){
            return 0;
        }
        
        int f1 = ceR(str, idx + 1);
        int f2 = 0;
        if(idx + 1 < str.length()){
            int chi = str.charAt(idx) - '0';
            int chip1 = str.charAt(idx + 1) - '0';
            if(chi * 10 + chip1 <= 26){
                f2 =ceR(str, idx + 2);
            }
        }
        return f1 + f2;
    }
}
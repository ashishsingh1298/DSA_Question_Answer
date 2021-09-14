import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<Integer> s1 = new Stack<>();
    Stack<String> s2 = new Stack<>(); //infix
    Stack<String> s3 = new Stack<>(); // postfix
    
    for(int i = exp.length() - 1; i >= 0 ; i--){
        char ch = exp.charAt(i);
        
        if(ch >= '0' && ch <= '9'){
            s1.push(ch - '0');
            s2.push(ch +"");
            s3.push(ch +"");
        }else {
            int v1 = s1.pop();
            int v2 = s1.pop();
            s1.push(solver(v1,v2,ch));
            
            String c1 = s2.pop();
            String c2 = s2.pop();
            s2.push("(" + c1 + ch + c2 + ")");
            
            String p1 = s3.pop();
            String p2 = s3.pop();
            s3.push(p1 + p2 + ch);
        }
    }
    System.out.println(s1.pop());
    System.out.println(s2.pop());
    System.out.println(s3.pop());
    
 }
 public static int solver(int v1, int v2, char ch){
     if(ch == '+'){
         return v1 + v2;
     }else if(ch == '-'){
         return v1 - v2;
     }else if(ch == '*'){
         return v1 * v2;
     }else {
         return v1 / v2;
     }
 }
}
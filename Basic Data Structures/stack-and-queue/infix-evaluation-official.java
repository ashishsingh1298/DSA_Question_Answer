import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    
    Stack<Character> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    for( int i = 0; i < str.length();i++){
        char ch = str.charAt(i);
        if(ch == '('){
            s1.push(ch);
        }else if(Character.isDigit(ch)){
            s2.push(ch - '0');
        }else if(ch == ')'){
            while(s1.peek() != '('){
                char oprt = s1.pop();
                int v2 = s2.pop();
                int v1 = s2.pop();
                
                int opn = cal(v1,v2,oprt);
                s2.push(opn);
            }
            s1.pop();
        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(s1.size() > 0 && s1.peek() != '(' && precedence(ch) <= precedence(s1.peek())){
                char oprt = s1.pop();
                int v2 = s2.pop();
                int v1 = s2.pop();
                
                int opn = cal(v1,v2,oprt);
                s2.push(opn);
            }
            s1.push(ch);
        }
        
    
    }
    while( s1.size() != 0 ){
        char oprt = s1.pop();
        int v2 = s2.pop();
        int v1 = s2.pop();
        
        int opn = cal(v1,v2,oprt);
        s2.push(opn);
    }
     System.out.println(s2.peek());
 }
 public static int precedence(char optr){
     if(optr == '+'){
         return 1;
     }else if(optr == '-'){
        return 1;
     }else if(optr == '*'){
         return 2;
     }else{
         return 2;
     }
 }
 public static int cal(int v1, int v2, char optr){
     if(optr == '+'){
         return v1 + v2;
     }else if(optr == '-'){
        return v1 - v2;
     }else if(optr == '*'){
         return v1 * v2;
     }else{
         return v1 / v2;
     }
 }
}
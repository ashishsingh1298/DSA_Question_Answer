import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pi(n);
    }

    public static void pi(int n){
        if(n==0){
            return;
        }
        pi(n-1);
        System.out.println(n);
        
    }

}
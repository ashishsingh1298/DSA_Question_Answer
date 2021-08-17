import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] dp =  new int[n + 1];
    System.out.println(fib(n, dp));
 }
public static int fib(int n, int[] dp){
    if(n == 0 || n == 1){
        return n;
    }
    if(dp[n] != 0){
        return dp[n];
    }
    int fnm1 = fib(n - 1, dp);
    int fnm2 = fib(n - 2, dp);
    
    int fn = fnm1 + fnm2;
    dp[n] = fn;
    return fn;
}
}
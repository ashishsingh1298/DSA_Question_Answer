import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    
    // System.out.println(tmR(n,m)); // this is memorization with recurssion
    
    int[] dp = new int[n + 1];
    // Lets take a example, If 5 X 4 floor size area we have to cover so we     //  only have one choice bcoz tile can be used at 5 X 1.
    // if n == m then 5 X 5 can be done n two ways whether horizontally o vertically.
    for(int i = 1; i <= n; i++){
        if(i < m){
            dp[i] = 1;
        }else if(i == m){
            dp[i] = 2;
        }
        else{
            dp[i] = dp[i - 1] + dp[i - m];
        }
    }
    System.out.println(dp[n]);
    }
    // public static int tmR(int n, int m){
    //     if(n < m){
    //         return 1;
    //     }
    //     int ans = tmR(n - 1,m) + tmR(n - m, m);
    //     return ans;
    // }
}
// 1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
// 2. You've an infinite supply of 2 * 1 tiles.
// 3. You are required to calculate and print the number of ways floor can be tiled using tiles.
// Input Format
// A number n
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int [] dp = new int[n +1];
        // System.out.println(tr(n)); // This is recursion call
        // System.out.println(trdp(n, dp)); // this is for memorization
        
        // tabulation
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
    // public static int trdp(int n,int [] dp){
    //     if(n == 1){
    //         return 1;
    //     }
    //     if(n == 2){
    //         return 2;
    //     }
    //     if(dp[n] >0){
    //         return dp[n];
    //     }
    //     int ans = trdp(n-1,dp) + trdp(n -2,dp);
    //     dp[n] = ans;
    //     return ans;
    // }
    // public static int tr(int n){
    //     if(n == 1){
    //         return 1;
    //     }
    //     if(n == 2){
    //         return 2;
    //     }
    //     int ans = tr(n-1) + tr(n -2);
    //     return ans;
    // }
    
}

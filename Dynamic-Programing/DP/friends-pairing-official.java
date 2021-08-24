import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // System.out.println(fpairUP(n));
        // tabulation solution
        int dp [] = new int[n +1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i -1] + (i-1)*dp[i - 2];
        }
        System.out.println(dp[n]);
    }
    // public static int fpairUP(int n){
    //     if(n == 0){
    //         return 1; 
    //     }
    //     if(n < 0){
    //         return 0; 
    //     }
    //     int f1 = fpairUP(n - 1); 
    //     int f2 = (n - 1)*fpairUP(n - 2);
    //     int ans = f1+f2;
    //     return ans;
    // }
}
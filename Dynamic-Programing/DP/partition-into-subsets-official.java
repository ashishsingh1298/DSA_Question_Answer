import java.io.*;
import java.util.*;

public class Main {
        
    // public static long partitionKSubset(int n, int k) {
    //     // Now with tabulation
        
    //     int dp[][] = new int[n + 1][k + 1];
        
        
     // }
    public static long partitionKSubset(int n, int k,long[][] dp){
        if(n == k){
            return 1; 
        }
        if(k == 0){
            return 0; 
        }
        if(dp[n][k] > 0){
            return dp[n][k];
        }
        long f1 = partitionKSubset(n - 1,k - 1,dp); 
        long f2 = k*partitionKSubset(n - 1,k,dp);
        long ans = f1+f2;
        dp[n][k] = ans;
        return ans;  
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        // long res = partitionKSubset(n, k);
        
        long dp[][] = new long[n + 1][k + 1];
        long res = partitionKSubset(n, k, dp);
        System.out.println(res);
    }

}
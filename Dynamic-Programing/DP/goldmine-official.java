import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        // System.out.println(goldmine(arr));
        int ans =0;
        int[][] dp = new int[n][m];
        for(int i = 0; i < arr.length; i++){
            ans = Math.max(ans, goldmineR(arr, i , 0, dp));
        }
        System.out.println(ans);
    }
    public static int goldmineR(int[][] arr, int sr, int sc, int[][] dp){
        if(sr < 0 || sr >= arr.length){
            return Integer.MIN_VALUE;
        }
        
        if(sc == arr[0].length - 1){
            return arr[sr][sc];
        }
        if(dp[sr][sc] > 0){
            return dp[sr][sc];
        }
        int f1 = goldmineR(arr, sr - 1, sc + 1,dp);
        int f2 = goldmineR(arr, sr, sc + 1,dp);
        int f3 = goldmineR(arr, sr + 1, sc + 1,dp);
        int ans = arr[sr][sc] + Math.max(f1, Math.max(f2, f3));
        dp[sr][sc] = ans;
        return ans;
        
    }
    
    public static int goldmine(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int j = dp[0].length - 1; j >= 0; j--){
            for(int i = 0; i < dp.length; i++){
                
                if(j == dp[0].length - 1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                }
                else if(i == arr.length - 1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                }
                else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < dp.length; i++){
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
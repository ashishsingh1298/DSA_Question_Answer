import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        // System.out.println(minCostMaze(arr ,0 ,0 ,dp));
        System.out.println(minCostMazeTab(arr));
        
    }
    public static int minCostMazeTab(int [][]arr){
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int i = dp.length - 1; i >=0; i--){
            
            for(int j = dp[0].length - 1; j >=0; j--){
                
                if(i == dp.length - 1 && j == dp[0].length - 1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == dp.length - 1){
                    dp[i][j] = arr[i][j] + dp[i][j + 1];
                }
                else if(j == dp[0].length -1){
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                }
                else{
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
        
    }
    // public static int minCostMaze(int[][] arr, int sr, int sc, int[][] dp){
        
    //     if(sr >= arr.length || sc >= arr[0].length){
    //         return Integer.MAX_VALUE;
    //     }
        
    //     if(sr == arr.length -1 && sc == arr[0].length -1){
    //         return arr[sr][sc];
    //     }
        
    //     if(dp[sr][sc] > 0){
    //         return dp[sr][sc];
    //     }
    //     int x = minCostMaze(arr, sr ,sc + 1, dp);
    //     int y = minCostMaze(arr, sr + 1,sc, dp);
        
    //     int ans = Math.min(x, y) + arr[sr][sc]; 
    //     dp[sr][sc] = ans;
    //     return ans;
    // }
}



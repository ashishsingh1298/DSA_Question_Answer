import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int[][] arr = new int[n][k];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int [][] dp = new int[n][k];
        
        // This operation will take T.c O(n^3)
        
        // for(int i = 0; i < k; i++){
        //     dp[0][i] = arr[0][i];
        // }
        
        // for(int i = 1; i < n; i++){
        //      for(int j = 0; j < k; j++){
            
        //         int min = Integer.MAX_VALUE;
        //         for(int m = 0; m < k; m++){
        //             if(j != m){
        //                 min = Math.min(min,dp[i - 1][m]);
        //             }
        //         }
                
        //         dp[i][j] = arr[i][j] + min;
        //     }
        // }
        
        // This operation will take T.c O(n^2)
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            dp[0][i] = arr[0][i];
            
            if(arr[0][i] <= least){
                sleast = least;
                least = arr[0][i];
            }else if(arr[0][i] <= sleast){
                sleast = arr[0][i];
            }
        }
        
        for(int i = 1; i < n; i++){
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            
            for(int j = 0; j < k; j++){
                if(least == dp[i - 1][j]){
                    dp[i][j] = sleast + arr[i][j];
                }else {
                    dp[i][j] = least + arr[i][j];
                }
                
                if(dp[i][j] <= nleast){
                nsleast = nleast;
                nleast = dp[i][j];
                }  else if(dp[i][j] <= nsleast){
                        nsleast = dp[i][j];
                }
                
            }
            least = nleast;
            sleast = nsleast;
        }
        
        int min = Integer.MAX_VALUE;
        for(int m = 0; m < k; m++){
            min = Math.min(min,dp[n - 1][m]);
        }        
        System.out.println(min);
    }
}
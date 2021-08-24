import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        
        int[][] dp = new int[k + 1][n];
        
        for(int i = 1; i < dp.length; i++){
            int max = dp[i - 1][0] - arr[0];
            for(int j = 1; j < dp[0].length;j++){
                dp[i][j] = Math.max(dp[i][j -1],max + arr[j]);
                max = Math.max(max, dp[i - 1][j] - arr[j]);
            }
        }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }

}
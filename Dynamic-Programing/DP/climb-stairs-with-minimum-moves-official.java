import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--){
            int min = Integer.MAX_VALUE - 1;
            for(int j = 1; j <= arr[i] && i + j < n; j++){
                min = Math.min(min,dp[i + j]);
            }
            dp[i] = min +1;
        }
        System.out.println(dp[0]);
    }

}
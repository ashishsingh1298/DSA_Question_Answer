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
        
        int numb = scn.nextInt();
        
        int[] dp = new int[numb + 1];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            dp = coinChange(dp, arr[i]);
        }
        System.out.println(dp[numb]);
    }
    
    public static int[] coinChange(int[] dp, int coin){
       
       for(int i = coin; i < dp.length; i++){
           dp[i] += dp[i - coin];
       }
        return dp;
    }
}
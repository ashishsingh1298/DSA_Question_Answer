import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int [] item = new int[n];
        for(int i = 0; i < n; i++){
            item[i] = scn.nextInt();
        }
        int [] weg = new int[n];
        for(int i = 0; i < n; i++){
            weg[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        
        int [][] dp = new int[n + 1][cap + 1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int f2 = Integer.MIN_VALUE;
                int f1 =  dp[i - 1][j];
                if(j - weg[i - 1] >=0){
                    f2 = item[i - 1] + dp[i - 1][j - weg[i - 1]];
                }

                dp[i][j] = Math.max(f1, f2);
            }
        }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }
}
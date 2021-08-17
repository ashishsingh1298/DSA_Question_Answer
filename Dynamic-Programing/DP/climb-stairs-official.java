import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // System.out.println(climbStairs(n));
        
        // System.out.println(climbStairsDp(n,new int[n + 1]));
        
        System.out.println(climbStairsDpTab(n));
    }
    public static int climbStairs(int n){
       
        if(n < 0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }
        int x = climbStairs(n - 1);
        int y = climbStairs(n - 2);
        int z = climbStairs(n - 3);
        int asf = x + y + z;
        return asf;
    }
    public static int climbStairsDp(int n, int[]dp){
        if(n < 0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }
        if(dp[n] > 0){
            return dp[n];
        }
        int x = climbStairs(n - 1);
        int y = climbStairs(n - 2);
        int z = climbStairs(n - 3);
        int asf = x + y + z;
        
        dp[n] = asf;
        return asf;
        
    }
    
    public static int climbStairsDpTab(int n){
        int[] tab = new int[n + 1];
        
        tab[0] = 1;
        
        for(int i = 1; i <=n; i++){
            if(i == 1){
                tab[i] = tab[i - 1] + tab[i];
            }
            else if(i == 2){
                tab[i] = tab[i - 2] + tab[i - 1];
            }
            else{
                tab[i] = tab[i - 2] + tab[i - 1] + tab[i - 3];   
            }
        }
        return tab[n];
    }
}

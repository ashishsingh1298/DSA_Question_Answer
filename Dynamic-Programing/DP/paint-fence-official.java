// 1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
// 2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.
// https://classroom.pepcoding.com/myClassroom/the-placement-program-pitampura-jun-21-2021/dynamic-programming/paint-fence-official/ojquestion
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int k  = scn.nextInt();
        
    //     int[] dp1 = new int[n + 1]; // last two fences are painted with                                          same color
    //     int[] dp2 = new int[n + 1]; // last two fences are painted with                                          Different color
        
    //     dp2[1] = k;
        
    //     for(int i = 2; i <= n; i++){
    //         dp1[i] = dp2[i - 1];
    //         dp2[i] = (dp1[i - 1] + dp2[i - 1]) * (k - 1);
    //     }
    //   System.out.println(dp1[n]  + dp2[n]); 
       System.out.println(pfr(n,k));
    }
    public static int pfr(int n, int k){
        
        if(n == 1){
            return k;
        }
        if(n== 2){
            return k*k;
        }
        int ans = (pfr(n-1, k) + pfr(n - 2,k)) * (k - 1);
        return ans;
    }
}
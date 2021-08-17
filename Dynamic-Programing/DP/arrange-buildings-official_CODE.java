import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int[] dp1 = new int[n + 1];
    int[] dp2 = new int[n + 1];
    
    dp1[1] = 1;
    dp2[1] = 1;
    
    for (int i = 2; i <= n; i++){
        dp1[i] = dp2[i - 1];
        dp2[i] = dp1[i - 1] + dp2[i -1];
    }
    long ans = dp1[n] + dp2[n];
    System.out.println(ans * ans);
 }

}
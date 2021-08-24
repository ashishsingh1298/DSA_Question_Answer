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
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        int mxsf = arr[n - 1];
        int mnsf = arr[0];
        
        // Maximum profit by doing at most one transacton till ith index
        for(int i = 1; i < n; i++){
            mnsf = Math.min(mnsf, arr[i]);
            dp2[i] = Math.max(arr[i] - mnsf, dp2[i - 1]);
        }
        
        // Maximum profit by doing at most one transacton from ith index
        for(int i = n - 2; i >=0; i--){
            mxsf = Math.max(mxsf, arr[i]);
            dp1[i] = Math.max(mxsf - arr[i], dp1[i + 1]);
        }
        
        
        
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max,dp1[i] + dp2[i]);
        }
        System.out.println(max);
    }

}
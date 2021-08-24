import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        // 1. approach
        // int maxProfit = 0;
        // for(int i = 1; i < n; i++){
        //     if(arr[i - 1] <= arr[i]){
        //         maxProfit += arr[i] - arr[i - 1];
        //     }
        // }
        // System.out.println(maxProfit);
        
        // 2. approach
        
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = 0 - arr[0];
        sell[0] = 0;
        for(int i = 1; i < n; i++){
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - arr[i]);
            sell[i] = Math.max(sell[i -1], buy[i - 1] + arr[i]);
        }
        System.out.println(sell[n - 1]);
    }

}
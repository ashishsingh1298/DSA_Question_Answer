import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = 0 - arr[0];
        sell[0] = 0;
        for(int i = 1; i < n; i++){
            if(i == 1){
                buy[i] = Math.max(buy[0], -arr[i]);
            }
            else{
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - arr[i]);   
            }
            sell[i] = Math.max(sell[i -1], buy[i - 1] + arr[i]);
        }
        System.out.println(sell[n - 1]);
    }

}
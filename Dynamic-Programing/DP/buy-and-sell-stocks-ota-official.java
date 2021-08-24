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
        
    System.out.println(buySell(arr,n));
    }
    public static int buySell(int[] arr,int n){
    
        int max = 0;
        int[] maxsf = new int[n];
        
        maxsf[n - 1] = arr[n - 1];
        
        for(int i = n - 2; i >= 0; i--){
            maxsf[i] = Math.max(arr[i],maxsf[i + 1]);
        }
        
        for(int i = 0; i < n; i++){
            max = Math.max(max, maxsf[i]- arr[i]);
        }
        
        return max;
    }
}
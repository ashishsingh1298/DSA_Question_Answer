import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        System.out.println(maxOfArray(arr,0));
    }

    public static int maxOfArray(int[] arr, int idx){
        
        if(idx == arr.length){
            return Integer.MIN_VALUE;
        }
        
        int f1 = maxOfArray(arr, idx+1);
        int max = Math.max(f1, arr[idx] );
        return max;
    }

}
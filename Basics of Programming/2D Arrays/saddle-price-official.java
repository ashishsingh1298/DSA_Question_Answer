import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn  = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] arr = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        int min;
        for (int i = 0; i < arr.length; i++){
            min = arr[i][0];
            int colno = 0;
            for (int j = 1; j < arr[0].length; j++){
               
               if (min > arr[i][j]){
                   min = arr[i][j];
                   colno = j;
               } 
            }
        
            // Verification
            
            boolean ans = true;
            
            for (int row = 0; row < n; row++){
                if (arr[row][colno] > min){
                    ans = false;
                    break;
                }
            }
            
            if (ans == true){
                System.out.println(min);
                return;
            }
        }
        
       System.out.println("Invalid input"); 
    }

}
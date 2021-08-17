import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] arr = new int[n][n];
        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int data = scn.nextInt();
        int i = n-1;
        int j = 0;
        
        while ( i >= 0 && j < n){
            if (arr[i][j] == data){
                System.out.println(i);
                System.out.println(j);
                return ;
            }
            else if (arr[i][j] < data){
                j++;
            }
            else{
                i--;
            }
        }
        
        
        System.out.println("Not Found");
    }

}
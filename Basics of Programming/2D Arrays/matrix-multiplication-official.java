import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int m1 = scn.nextInt();

    int[][] arr1 = new int[n1][m1];
    for(int i = 0; i < n1; i++){
        for(int j = 0; j < m1; j++){
            arr1[i][j] = scn.nextInt();
        }
    }
    
    int n2 = scn.nextInt();
    int m2 = scn.nextInt();

    int[][] arr2 = new int[n2][m2];
    for(int i = 0; i < n2; i++){
        for(int j = 0; j < m2; j++){
            arr2[i][j] = scn.nextInt();
        }
    }
    
    // System.out.println(m1 + " " + n2);
    if (m1 != n2){
        System.out.println("Invalid input");
    }
    
    else{
    int[][] arr3 = new int[n1][m2];
    for(int i = 0; i < n1; i++){
        for(int j = 0; j < m2; j++){
            arr3[i][j] = 0;
            
            for(int k = 0; k < n2; k++){
            arr3[i][j] += arr1[i][k]*arr2[k][j];
            }
        }
    }
    
    for(int i = 0; i < arr3.length; i++){
        for(int j = 0; j < arr3[0].length; j++){
            System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }        
    }

}

}
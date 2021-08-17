import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] arr = new int[n][m];
        
       for(int i = 0; i < n; i++){
           for(int j = 0; j < m; j++){
               arr[i][j] = scn.nextInt();
           }
       }
        
        maze(arr);
    }
    
    public static void maze( int[][] arr){
        int dir = 0;
        int row = 0, col = 0;
        while(true){
            dir = dir + arr[row][col];
            dir = dir % 4;
            
            if(dir == 0){
                col++;
            }
            else if(dir == 1){
                row++;
            }
            else if(dir == 2){
                col--;
            }
            else {
                row--;
            }
            
            if (row < 0){
                row++;
                break;
            }
            else if(row == arr.length){
                row--;
                break;
            }
            else if(col < 0){
                col++;
                break;
            }
            else if(col == arr[0].length){
                col--;
                break;
            }
        }
        System.out.println(row);
        System.out.println(col);
    }

}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] arr = new boolean[n][n];
        printNQueens(arr, "", 0);
    }

    public static void printNQueens(boolean[][] chess, String asf, int row) {
        
        if ( row == chess.length){
            System.out.println(asf + ".");
            return;
        }
        
        for (int col = 0; col < chess.length; col++){
            
            if (isSafe(chess, row, col) == true){
                chess[row][col] = true;
                printNQueens(chess, asf + row + "-" + col + ", " , row + 1);
                chess[row][col] = false;
            }
                
        }
        
        
    }
    public static boolean isSafe(boolean[][] chess, int row, int col){
        
        // check for column
        for (int i = row - 1; i >=0; i-- ){
            if (chess[i][col] == true){
                return false;
            }
        }
        // check for diagonal 1
        for ( int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++){
            if (chess[i][j] == true){
                return false;
            }
        }
        // check for diagonal 2
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j--){
            if (chess[i][j] == true){
                return false;
            }
        }
        return true;
    }
}
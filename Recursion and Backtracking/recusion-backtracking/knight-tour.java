import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int row = scn.nextInt();
    int col = scn.nextInt();
    int[][] chess = new int[n][n];
    printKnightsTour(chess, row ,col , 1);
  }

  public static void printKnightsTour(int[][] chess, int r, int c, int stepno) {
    
    
    if (r < 0 || r >= chess.length || c < 0 || c >= chess.length || chess[r][c] > 0){
        return;
    }
    if ( stepno == chess.length * chess.length ){
        
        chess[r][c] = 25; 
        displayBoard(chess);
        chess[r][c] = 0; 
        return;
    }
    
    chess[r][c] = stepno;
    printKnightsTour(chess,r - 2, c + 1, stepno + 1 );
    printKnightsTour(chess,r - 1, c + 2, stepno + 1 );
    printKnightsTour(chess,r + 1, c + 2, stepno + 1 );
    printKnightsTour(chess,r + 2, c + 1, stepno + 1 );
    printKnightsTour(chess,r + 2, c - 1, stepno + 1 );
    printKnightsTour(chess,r + 1, c - 2, stepno + 1 );
    printKnightsTour(chess,r - 1, c - 2, stepno + 1 );
    printKnightsTour(chess,r - 2, c - 1, stepno + 1 );
    chess[r][c] = 0;
    return;
  }

  public static void displayBoard(int[][] chess) {
    for (int i = 0; i < chess.length; i++) {
      for (int j = 0; j < chess[0].length; j++) {
        System.out.print(chess[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println();
  }
}
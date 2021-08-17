import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < arr.length; i++) {
      arr[i]  = scn.nextInt();
    }

    int data = scn.nextInt();
    bs(arr, data);
  }

  public static void bs(int[] arr, int data) {
    int fidx = -1;
    int lidx = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == data) {
        fidx = i;
        break;
      }
    }
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] == data) {
        lidx = i;
        break;
      }
    }

    System.out.println(fidx);
    System.out.println(lidx);
  }

}
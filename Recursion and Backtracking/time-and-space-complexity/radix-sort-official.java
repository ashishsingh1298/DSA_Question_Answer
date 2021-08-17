import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
   int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }
    
    // hear loop is basically no of digits or exp
    
    int loop = 0;
    while (max != 0) {
      max = max / 10;
      countSort(arr,(int)Math.pow(10,loop));
      loop++;
    }
    
  }

  public static void countSort(int[] arr, int exp) {
    
    int[] farr = new int[10];
    
    //  this is 1st array for farr storing count 
    
    for(int i = 0; i < arr.length; i++){
        farr[(arr[i] / exp) % 10]++; 
    }
    
    // this is farr to sumof number
    
    for(int i =1; i < farr.length; i++){
        farr[i] = farr[i - 1] + farr[i];
    }
    
    // final for answer
    int[] ans = new int[arr.length];
    for(int i = arr.length - 1; i >=0; i--){
        int pos = farr[(arr[i] / exp) % 10];
        ans[pos - 1] = arr[i];
        farr[(arr[i] / exp) % 10]--;
    }
    
    for (int i = 0; i < arr.length; i++) {
      arr[i] = ans[i];
    }

    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}
import java.io.*;
import java.util.*;

public class Main {

  public static void targetSumPair(int[] arr, int target){
    
    int[] sortedArr = mergeSort(arr, 0, arr.length - 1);
    int i = 0;
    int j = sortedArr.length -1;
    
    while(i < j){
        if(sortedArr[i] + sortedArr[j] > target){
            j--;
        }else if(sortedArr[i] + sortedArr[j] < target){
            i++;
        }else{
            System.out.println(sortedArr[i] +", "+ sortedArr[j]);
            i++;
            j--;
        }
    }
  }
  
  public static int[] mergeSort(int[] arr, int lo, int hi) {
    //write your code here
    if (lo == hi){
        int[] bans = new int[1];
        bans[0] = arr[lo];
        return bans;
    }
    int mid = (lo + hi)/2;
    int [] fhs = mergeSort(arr, lo, mid);
    int [] shs = mergeSort(arr,  mid + 1, hi);
    int [] ans = mergeTwoSortedArrays(fhs,shs);
    
    return ans;
  }
  //used for merging two sorted arrays
  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    int i = 0, j =0, k = 0;
    int[] ans = new int[a.length + b.length];
    while(i < a.length && j < b.length){
        if(a[i] <= b[j]){
          ans[k] = a[i];
          i++;
          k++;
        }else{
          ans[k] = b[j];
          j++;
          k++;
        }
    }

    while(i < a.length){
      ans[k] = a[i];
      k++;
      i++;
    }

    while(j < b.length){
      ans[k] = b[j];
      k++;
      j++;
    }
    
    return ans;
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}
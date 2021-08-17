import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    // System.out.println(csRr(arr, 0));
    // int[] dp = new int[n + 1];
    // System.out.println(csDp(arr, dp, 0));


    int[] dp = new int[n + 1];

    dp[n] = 1;

    for(int i = n - 1; i >= 0; i--){
        for(int j = 0; j <= arr[i] && i + j < dp.length;j++){
            dp[i] += dp[i + j];
        }
    }
    System.out.println(dp[0]);
  }

  // public static int csRr(int[] arr, int idx){
  //     if(idx == arr.length){
  //         return 1;
  //     }
  //     if(idx > arr.length){
  //         return 0;
  //     }

  //     int ans = 0;
  //     for(int jump = 1; jump <= arr[idx]; jump++){
  //         ans += csRr(arr, idx + jump);
  //     }
  //     return ans;
  // }

//   public static int csDp(int[] arr, int[] dp, int idx) {
//     if (idx == arr.length) {
//       return 1;
//     }
//     if (idx > arr.length) {
//       return 0;
//     }
//     if (dp[idx] > 0) {
//       return dp[idx];
//     }
//     int ans = 0;
//     for (int jump = 1; jump <= arr[idx]; jump++) {
//       ans += csDp(arr, dp, idx + jump);
//     }
//     dp[idx] = ans;
//     return dp[idx];
//   }


}
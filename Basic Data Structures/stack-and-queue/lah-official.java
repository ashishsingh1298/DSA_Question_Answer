import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }
    int[] NSL = nsl(a);
    int[] NSR = nsr(a);
    int max = 0;
    for (int i = 0; i < n; i++) {
        max = Math.max(max, a[i]*(NSR[i] - NSL[i] - 1));
    }
    System.out.println(max);
  }
  
//   next smallest element at left  
  public static int[] nsl(int[] arr) {
    int [] ans = new int[arr.length];
    Stack <Integer> st = new Stack<> ();
//   st.push(arr[arr.length - 1]);

    for (int i = 0; i < arr.length; i++) {
//   pop all Greater element
      while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
        st.pop();
      }
// update ans
      if (st.size() == 0) {
        ans[i] = -1;
      }
      else {
        ans[i] = st.peek();
      }
// push current element in stack
      st.push(i);
    }
    return ans;
  }
  
//   next smallest element from right
  public static int[] nsr(int[] arr) {
    int [] ans = new int[arr.length];
    Stack <Integer> st = new Stack<> ();
//   st.push(arr[arr.length - 1]);

    for (int i = arr.length - 1; i >= 0; i--) {
//   pop all greater element
      while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
        st.pop();
      }
// update ans
      if (st.size() == 0) {
        ans[i] = arr.length;
      }
      else {
        ans[i] = st.peek();
      }
// push current element in stack
      st.push(i);
    }
    return ans;
  }
}
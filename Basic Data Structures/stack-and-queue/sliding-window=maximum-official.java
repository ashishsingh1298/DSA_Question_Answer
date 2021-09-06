import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    Deque<Integer> dq = new ArrayDeque<>();
    for(int i = 0; i < k; i++){
        while(dq.size() > 0 && arr[dq.getLast()] < arr[i]){
            dq.removeLast();
        }
        dq.addLast(i);
    }
    System.out.println(arr[dq.peek()]);
    for(int i = k; i < arr.length; i++){
        while(dq.size() > 0 && arr[dq.getLast()] < arr[i]){
            dq.removeLast();
        }
        dq.addLast(i);
        if(dq.peek() <= i - k){
            dq.removeFirst();
        }
        System.out.println(arr[dq.peek()]);
    }
  }
}
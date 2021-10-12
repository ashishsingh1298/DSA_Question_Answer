import java.io.*;
import java.util.*;

public class Main {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }

    public void add(int val) {
     if(left.size() == 0 && right.size() == 0){
          left.add(val);
      }
      else if(left.size() == 0){
          if(right.peek() > val){
              left.add(val);
          }else{
              right.add(val);
          }
      }
      else{
          if(left.peek() > val){
              left.add(val);
          }else{
              right.add(val);
          }
      }
      
      int diff = Math.abs(left.size() - right.size());
      if(diff > 1){
          if(left.size() > right.size()){
              right.add(left.remove());
          }else{
              left.add(right.remove());
          }
      }
    }

    public int remove() {
        if(left.size() + right.size() == 0){
            System.out.println("Underflow");
            return -1;
        }
     else if(left.size() < right.size()){
          return right.remove();
      }else{
          return left.remove();
      }
    }

    public int peek() {
        if(left.size() == 0 && right.size() == 0){
            System.out.println("Underflow");
            return -1;
        }
      else if(left.size() < right.size()){
          return right.peek();
      }else{
          return left.peek();
      }
    }

    public int size() {
      return left.size() + right.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
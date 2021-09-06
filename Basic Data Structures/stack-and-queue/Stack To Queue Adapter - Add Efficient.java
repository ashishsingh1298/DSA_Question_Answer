import java.io.*;
import java.util.*;

public class Main {

  public static class StackToQueueAdapter {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public StackToQueueAdapter() {
      s1 = new Stack<>();
      s2 = new Stack<>();
    }

    int size() {
        return s1.size();
    }

    void add(int val) {
        s1.push(val);
    }

    int remove() {
        if(s1.size() == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        while(s1.size() != 1 ){
            s2.push(s1.pop());
        }
        int poped = s1.pop();
        while(s2.size() != 0 ){
            s1.push(s2.pop());
        }
        return poped;
    }

    int peek() {
        if(s1.size() == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        while(s1.size() != 1 ){
            s2.push(s1.pop());
        }
        int peeked = s1.peek();
        while(s2.size() != 0 ){
            s1.push(s2.pop());
        }
        return peeked;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StackToQueueAdapter qu = new StackToQueueAdapter();

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
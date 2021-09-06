import java.io.*;
import java.util.*;

public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public QueueToStackAdapter() {
      q1 = new ArrayDeque<>();
      q2 = new ArrayDeque<>();
    }

    int size() {
        return q1.size();
    }

    void push(int val) {
        while(q1.size() != 0){
            q2.add(q1.remove());
        }
        q1.add(val);
        while(q2.size() != 0){
            q1.add(q2.remove());
        }
    }

    int pop() {
        if(q1.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        return q1.remove();
    }

    int top() {
        if(q1.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
        return q1.peek();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}
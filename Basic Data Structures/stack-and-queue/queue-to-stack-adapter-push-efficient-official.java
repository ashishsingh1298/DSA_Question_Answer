import java.io.*;
import java.util.*;

public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public QueueToStackAdapter() {
      q1 = new ArrayDeque<>(); // main queue
      q2 = new ArrayDeque<>(); // helper queue
    }

    int size() {
      return q1.size();
    }

    void push(int val) {
        q1.add(val);
    }

    int pop() {
      if(q1.size() == 0){
            System.out.println("Stack underflow");
            return -1;
      }
      else{
            while(q1.size() > 1){
                q2.add(q1.remove());
            }
            int a =  q1.remove();
            q1 = q2;
            q2 = new ArrayDeque<>();
            return a;
      }
    }

    int top() {
       if(q1.size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }
      else{
            while(q1.size() > 1){
                q2.add(q1.remove());
            }
            int a =  q1.remove();
            q2.add(a);
            q1 = q2;
            q2 = new ArrayDeque<>();
            return a;
            }
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
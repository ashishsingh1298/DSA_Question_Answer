import java.io.*;
import java.util.*;

public class Main {

  public static class LLToStackAdapter {
    LinkedList<Integer> LL;

    public LLToStackAdapter() {
      LL = new LinkedList<>();
    }


    int size() {
        return LL.size();
    }

    void push(int val) {
        LL.addFirst(val);
    }

    int pop() {
      if (LL.size() == 0) {
        System.out.println("List is empty");
        return -1;
      }
      int data = LL.removeFirst();
      return data;
    }

    int top() {
    if (LL.size() == 0) {
        System.out.println("List is empty");
        return -1;
      }
      int data = LL.getFirst();
      return data;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LLToStackAdapter st = new LLToStackAdapter();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}
import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      data.add(val);
      upheapipy(data.size() - 1);
    }
    
    public void upheapipy(int ci){
        
        int pi = (ci - 1) / 2;
        if(data.get(pi) > data.get(ci)){
            swap(ci, pi);
            upheapipy(pi);
        }
    }
    
    public void swap(int i, int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i , jth);
        data.set(j , ith);
    }

    public int remove() {
        if(data.size() == 0){
            System.out.println("Underflow");
            return -1;
        }
        swap(0,data.size() - 1);
        int rv = data.remove(data.size() - 1);
        
        downheapipy(0);
        return rv;
    }
    public void downheapipy(int pi){
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        
        int minidx = pi;
        
        if(lci < data.size() && data.get(lci) < data.get(minidx)){
            minidx = lci;
        }
        if(rci < data.size() && data.get(rci) < data.get(minidx)){
            minidx = rci;
        }
        
        if(minidx != pi){
            swap(pi, minidx);
            downheapipy(minidx);
        }
    }
    public int peek() {
      if(data.size() == 0){
        System.out.println("Underflow");
        return -1;
      }else{
          return data.get(0);
      }
      
    }

    public int size() {
        return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

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
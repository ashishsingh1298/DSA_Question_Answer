import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }
  
  private static class Pair {
    int dia;
    int ht;
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  
  static int diameter;
  
  public static int height(Node node){
      
      int maxh = -1;
      int smaxh = -1;
      
      for(Node child : node.children){
          int ch = height(child);
          if(ch > maxh){
              smaxh = maxh;
              maxh = ch;
              
          }else if(ch >smaxh){
              smaxh = ch;
          }
      }
      diameter = Math.max(diameter, maxh + smaxh + 2);
      return maxh + 1;
  }

  public static Pair diameter(Node node){
      
      int mxht = -1;
      int smxht = -1;
      int dia = 0;
      for(Node child : node.children){
          
          Pair cp = diameter(child);
          
          if(cp.ht > mxht){
              smxht = mxht;
              mxht = cp.ht;
          }else if(cp.ht > smxht){
              smxht = cp.ht;
          }
          dia = Math.max(dia, cp.dia);
      }
      
      Pair mp = new Pair();
      mp.ht = mxht + 1;
      mp.dia = Math.max(dia, mxht +smxht + 2);
      return mp;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    // height(root);
    // System.out.println(diameter);
    Pair ap = diameter(root);
    System.out.println(ap.dia);
  }

}
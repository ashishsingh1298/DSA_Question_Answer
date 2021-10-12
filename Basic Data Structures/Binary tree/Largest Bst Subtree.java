import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
  public static class subBstPair{
      int min;
      int max;
      int lar;
      Node rNode;
      boolean isBst;
  } 
  public static subBstPair nBst(Node node){
      if(node == null){
        subBstPair bp = new subBstPair();
        bp.min = Integer.MAX_VALUE;
        bp.max = Integer.MIN_VALUE;
        bp.lar = 0;
        bp.isBst = true;
        return bp;  
      }
      
      subBstPair lp = nBst(node.left);
      subBstPair rp = nBst(node.right);
      
      subBstPair mp = new subBstPair();
      mp.min = Math.min(node.data, Math.min(lp.min,rp.min));
      mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
      
      if(lp.isBst == true && rp.isBst == true && lp.max < node.data && rp.min > node.data){
          mp.isBst = true;
          mp.rNode = node;
          mp.lar = lp.lar + rp.lar + 1;
      }else{
          if(lp.lar >= rp.lar){
            mp.rNode = lp.rNode;
            mp.lar = lp.lar;
          }else{
            mp.rNode = rp.rNode;
            mp.lar = rp.lar;
          }
      }
      return mp;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    subBstPair ansb = nBst(root);
    System.out.println(ansb.rNode.data +"@"+ansb.lar);
    // write your code here
  }

}
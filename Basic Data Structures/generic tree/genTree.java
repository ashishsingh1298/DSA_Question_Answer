import java.util.*;

public class Main{
    
    public static class Node{
        int data;
        ArrayList<Node> children;
        
        public Node(int data){
            this.data = data;
            children = new ArrayList<>();
        }
    }
    
    //root of the generic tree
    public static Node construct(int[] arr){
        Stack<Node> st = new Stack<>();
        Node root = new Node(arr[0]);
        st.push(root);
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node n = new Node(arr[i]);
                st.peek().children.add(n);
                st.push(n);
            }
        }
        return root;
    }
    
    public static void display(Node node){
        
        String str = node.data + " -> ";
        for(Node child : node.children){
            str += child.data + ", ";
        }
        str += '.';
        System.out.println(str);
        
        for(Node child : node.children){
            display(child);
        }
        
        // for(int i = 0 ; i < node.children.size(); i++){
        //     Node child = node.children.get(i);
        //     disply(child);
        // }
    }
    
    public static void main(String[] args){
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = construct(arr);
        display(root);
    }
}
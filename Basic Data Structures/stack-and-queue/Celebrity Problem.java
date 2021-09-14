import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
    
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < arr.length; i++){
            st.push(i);
        }
        
        while(st.size() != 1){
            int n2 = st.pop();
            int n1 = st.pop();
            st.push(elemanate(n1,n2,arr));
        }
        int ans = st.pop();
        int flag = 0;
        for (int i = 0; i < arr.length; i++){
            
            if(i != ans){
                if(arr[ans][i] == 0 && arr[i][ans] == 1) {
                    flag = 1;
                }else{
                    flag = 0;
                }
            }
        }
        if(flag == 1){
            System.out.println(ans);
        }else{
            System.out.println("none");
        }
        
    }
public static int elemanate(int n1, int n2,int[][] arr){
    if(arr[n1][n2] == 1){
        return n2;
    }else{
        return n1; 
    }
}
}
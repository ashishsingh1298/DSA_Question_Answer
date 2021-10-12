import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    HashMap<Integer,Integer> map = new HashMap<>();
    int n1 = scn.nextInt();
    
    int[] a1 = new int[n1];
    for(int i = 0; i < n1; i++){
        a1[i] = scn.nextInt();
        
        // if(map.contains()){
            
        // }else{
        //     map.put(a1[i],1);
        // }
        map.put(a1[i], map.getOrDefault(a1[i] , 0) + 1);
    }
    int n2 = scn.nextInt();
    int[] a2 = new int[n2];
    for(int i = 0; i < n2; i++){
        a2[i] = scn.nextInt();
        if(map.containsKey(a2[i]) == true){
            System.out.println(a2[i]);
            map.put(a2[i], map.get(a2[i]) - 1);
            if(map.get(a2[i]) == 0){
                map.remove(a2[i]);
            } 
        }
    }
    
 }

}
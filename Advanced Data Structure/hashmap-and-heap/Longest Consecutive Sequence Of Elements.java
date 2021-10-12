import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    
    HashMap<Integer,Boolean> map = new HashMap<>();
    // 1. consirder all element as valid subsequence point
    for(int i = 0; i < n; i++){
        a[i] = scn.nextInt();
        map.put(a[i], true);
    }
    
    // 2. Discard all invalid points
    for(int i = 0; i < n; i++){
        if(map.containsKey(a[i] - 1) == true){
            map.put(a[i],false);
        }
    }
    
    // 3. 
    int sp = 0;
    int maxLen = 0;
    for(int i = 0; i < n; i++){
        if(map.get(a[i]) == true){
            int curr = a[i];
            int len = 1;
            while(map.containsKey(curr + 1) == true){
                curr++;
                len++;
            }
            if(len > maxLen){
                maxLen = len;
                sp = a[i];
            }
        }
    }
    for(int i = 0; i < maxLen; i++){
        System.out.println(sp + i);
    }
 }

}
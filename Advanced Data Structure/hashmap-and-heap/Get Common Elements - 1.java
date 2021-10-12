import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    HashSet<Integer> set = new HashSet<>();
    int n1 = scn.nextInt();
    
    int[] a1 = new int[n1];
    for(int i = 0; i < n1; i++){
        a1[i] = scn.nextInt();
        set.add(a1[i]);
    }
    int n2 = scn.nextInt();
    int[] a2 = new int[n2];
    for(int i = 0; i < n2; i++){
        a2[i] = scn.nextInt();
        if(set.contains(a2[i]) == true){
            System.out.println(a2[i]);
            set.remove(a2[i]);
        }
    }
    
 }

}
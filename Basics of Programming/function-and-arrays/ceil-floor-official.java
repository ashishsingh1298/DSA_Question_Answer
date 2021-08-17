import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
   Scanner scn = new Scanner(System.in);
   int n = scn.nextInt();
   
   int[] ar = new int[n];
   for (int i = 0; i < ar.length; i++){
       ar[i] = scn.nextInt();
   }
   
   int num = scn.nextInt();
    bs(ar,num);
    // for (int j = 0; j < ar.length-1; j++){
    //     if (ar[j] == num){
    //         System.out.println(num);
    //         break;
    //     }
    //     else if(ar[j] < num && ar[j+1] > num){
    //         System.out.println(ar[j+1]);
    //         System.out.print(ar[j]);
    //         break;
    //     }
    // } 
}

public static void bs(int[] arr, int data){
    int left = 0;
    int right = arr.length-1;
    int ceil = -1;
    int floor = -1;
    
    while(left <= right){
        int mid = (left + right)/2;
        
        if(arr[mid] == data){
            ceil = data;
            floor = data;
            break;
        }
        else if(arr[mid] > data){
            ceil = arr[mid];
            right = mid - 1;
            
        }
        else{
            floor = arr[mid];
            left = mid + 1;
        }
    }
    System.out.println(ceil);
    System.out.println(floor);
}
}






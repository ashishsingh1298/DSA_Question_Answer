// Q1: Find Unique Character B/W Two Strings

// Find the unique characters between the two given strings.

// The expectation is that you will write a method that will take two strings as inputs and print out the unique characters between the two strings

// For Example, let's say the two strings are:

// 	S1 = LOS ANGELESO

// 	S2 = LAS VEGASV 

// 	The output = O, V, N


// You will need to do this with O(n) time complexity & O(n) Space complexity.

// Any code / algorithm that takes O(nlogn) or O(n-square) time complexity will be rejected.

// Bonus Points, If you can solve with O(n) space complexity as well.

/* package whatever; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
        String str = "LOS ANGELESO";
        String str1 = "LAS VEGASV";
 
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length();i++){
            char ch  = str.charAt(i);
            map.put(ch,1);
        }
 
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(int i = 0; i < str1.length();i++){
            char ch  = str1.charAt(i);
            map1.put(ch,1);
        }
        // for(int i = 0; i < str1.length();i++){
        //     char ch  = str1.charAt(i);
        //     if(map.containsKey(ch) == true){
        //         map.remove(ch);
        //     }else{
        //         map.put(ch,1);
        //     }
 
        // }
        if(map.size() > map1.size()){
        	for (Character ch: map.keySet()) {
    			if(map1.containsKey(ch) == true){
                	map1.remove(ch);
	            }else{
	                map1.put(ch,1);
	            }
			}
 
			for (Character ch: map1.keySet()) {
    			System.out.print(ch+", ");
			}
        }else{
        	for (Character ch: map1.keySet()) {
    			if(map.containsKey(ch) == true){
                	map.remove(ch);
	            }else{
	                map.put(ch,1);
	            }
			}
			for (Character ch: map.keySet()) {
    			System.out.print(ch+", ");
			}
        }
 
  //      for (Character ch: map.keySet()) {
  //  		System.out.print(ch+", ");
		// }
 
	}
}


// My output

// V, N, O, 
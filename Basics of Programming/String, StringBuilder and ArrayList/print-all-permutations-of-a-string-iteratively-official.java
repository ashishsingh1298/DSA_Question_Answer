import java.io.*;
import java.util.*;

public class Main {
    
    public static int tnp(int n){
        int ans = 1;
        for ( int i = n; i > 0; i--){
            ans *= i;
        }
        return ans;
    }

	public static void solution(String str){
		
		int fact = tnp(str.length());
		
		for (int i = 0; i < fact; i++){
		
		    StringBuilder sb = new StringBuilder(str);
    		 int div = str.length();
    		 int dvd = i;
    		 while(div > 0){
    		     int r = dvd % div;
    		     System.out.print(sb.charAt(r));
    		     sb.deleteCharAt(r);
    		     dvd = dvd / div;
    		     div--;
    		 }
    	System.out.println();	 
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}
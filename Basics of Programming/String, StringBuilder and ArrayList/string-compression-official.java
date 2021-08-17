import java.io.*;
import java.util.*;

public class Main {

    
    
	public static String compression1(String str){
		String ans = "";
		ans += str.charAt(0);
		
		for (int i = 1; i < str.length(); i++){
		    if ( str.charAt(i) != ans.charAt(ans.length()-1)){
		        ans += str.charAt(i);
		    }
		}
    
		return ans;
	}

	public static String compression2(String str){
		String ans = "";
		ans += str.charAt(0);
		int count = 1;
		for( int i = 1; i < str.length(); i++){
		    if ( str.charAt(i) == ans.charAt(ans.length()-1)){
		        count++;
		    }
		    else{
		        if (count > 1){
		        ans += count;
		        }
		        ans += str.charAt(i);
		        count = 1;
		    }
		    
		}
		if (count > 1){
		        ans +=count;
		    }
		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}
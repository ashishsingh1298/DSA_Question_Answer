import java.io.*;
import java.util.*;

public class Main {

	public static String solution(String str){
	    StringBuilder sb = new StringBuilder();
	    sb.append(str.charAt(0));
	    for (int i = 0; i < str.length() - 1; i++){
	        char ch1 = str.charAt(i);
	        char ch2 = str.charAt(i + 1);
	        sb.append(ch2 - ch1);
	        sb.append(ch2);
	    }
	    
	    return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
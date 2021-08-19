import java.util.*;

public class Main{

public static void main(String[] args) {
  // write your code here 
  Scanner scn = new Scanner(System.in);
   int n = scn.nextInt();
	  int x =0;
	  int m =1;
	  while(n>0){
	      int temp = n%10;
	      int d=m;
	      int p=temp;
	      
	      x=x+d*(int)Math.pow(10,p-1);
	      n=n/10;
	      m++;
	      
	  }
	  System.out.println(x);
 }
}
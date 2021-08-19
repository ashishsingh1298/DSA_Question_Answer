import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		    int x = sc.nextInt();
		    int n = x;
		    int cout =0;
		    while(n>0){
		        int temp = n%10;
		        cout++;
		        n=n/10;
		    }
		    System.out.println(cout); 
   }
  }
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
       
       int t = scn.nextInt();
       
       for(int i=1; i<=t; i++){
        
       int n = scn.nextInt();
       int factor = 0;
       for(int div = 2;div*div<=n;div++){
            if(n % div ==0){
                factor++;
                break;
            }
       }
    if(factor==0){
        System.out.println("prime");
    }
    else{
        System.out.println("not prime");
    }
       
       }
      }
  }
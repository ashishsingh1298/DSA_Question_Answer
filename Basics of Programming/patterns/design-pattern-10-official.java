import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n = scn.nextInt();
     
     int stars = 1;
     int spaces = n/2;
     
     for(int i = 1; i <= n; i++){
        for (int j = 1; j <= spaces; j++){
            System.out.print("\t");
        }
        for (int k = 1; k<= stars; k++){
            if(k == stars || k == 1 ){
            System.out.print("*\t");
            }
            else{
                System.out.print("\t");
            }
        }
        System.out.println();
        
        if(i<=n/2){
            spaces--;
            stars +=2;
        }
        else{
            spaces++;
            stars -=2;
        }
     }

 }
}
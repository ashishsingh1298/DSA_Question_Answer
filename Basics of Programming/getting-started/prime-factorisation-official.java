import java.util.*;

public class Main{

public static void main(String[] args) {
  // write your code here  
   Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  for(int i=2;i<n;i++){
		      while(n%i==0){
		          System.out.print(i+" ");
		          n=n/i;
		      }
		  }
		  if(n>2){
		      System.out.print(n);
		  }
// // 2nd approach
// 	for(int div = 2; div*div <= n; div++){
//       while(n % div == 0){
//           n = n / div;
//           System.out.print(div +" ");
//       }
//   }
// //   THis is the case where the number is prime number.
//   if(n != 1){
//       System.out.print(n);
//   }
 }
}
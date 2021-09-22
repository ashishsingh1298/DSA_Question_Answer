import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	     int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(gcd(n,m));
			System.out.println(lcm(n,m));
	     }
     
         static int gcd(int a,int b) {
			if(b==0) {
				return a;
			}
			return gcd(b,a%b);
		}
		
		static int lcm(int a,int b) {
			return (a*b)/gcd(a,b);
		}
// Approach 2 
		//  int div = n1;
        // int dvd = n2;
        
        // while(dvd % div != 0){
        //    int r = dvd % div;
        //     dvd = div;
        //     div = r;
        // }
        // System.out.println(div);
        // System.out.println((n1*n2)/div);
}
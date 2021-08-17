import java.io.*;
import java.util.*;

public class Main {

  public static String toggleCase(String str) {
    
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < str.length(); i++) {
      if ( str.charAt(i) >= 'a' && str.charAt(i) <= 'z' ) {
        sb.append((char)(str.charAt(i) - 'a' + 'A'));
      }
      else {
        sb.append((char)(str.charAt(i) - 'A' + 'a'));
      }
      
    }
    return sb.toString();
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.next();
    System.out.println(toggleCase(str));
  }

}
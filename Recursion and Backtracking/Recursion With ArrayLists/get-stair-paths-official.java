import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n == 0){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }
        if(n<0){
            ArrayList<String> bans = new ArrayList<>();
            return bans;
        }
        
        
        ArrayList<String> rr1 = getStairPaths(n-1);
        ArrayList<String> rr2 = getStairPaths(n-2);
        ArrayList<String> rr3 = getStairPaths(n-3);
        
        ArrayList<String> mr = new ArrayList<>();
        
        for(int i =0; i< rr1.size(); i++){
            mr.add("1" + rr1.get(i));
        }
        for(int i =0; i< rr2.size(); i++){
            mr.add("2" + rr2.get(i));
        }
        for(int i =0; i< rr3.size(); i++){
            mr.add("3" + rr3.get(i));
        }
            
        return mr;
    }

}
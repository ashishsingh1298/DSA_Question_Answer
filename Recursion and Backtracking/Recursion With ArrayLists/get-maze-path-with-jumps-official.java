import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        System.out.println(getMazePaths(0,0,n-1,m-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc){
            ArrayList<String> bans = new ArrayList<>();
            bans.add("");
            return bans;
        }
        ArrayList<String> mr = new ArrayList<>();
        for(int jump = 1; jump  <= dc - sc; jump++){
            ArrayList<String> rr = getMazePaths(sr,sc + jump, dr, dc);
            
            for(int i = 0; i < rr.size(); i++){
                mr.add("h" + jump + rr.get(i));
            }
        }
        for(int jump = 1; jump  <= dr - sr; jump++){
            ArrayList<String> rr = getMazePaths(sr + jump, sc, dr, dc);
            
            for(int i = 0; i < rr.size(); i++){
                mr.add("v" + jump + rr.get(i));
            }
        }
        for(int jump = 1; jump  <= dc - sc && jump <= dr - sr; jump++){
            ArrayList<String> rr = getMazePaths(sr + jump ,sc + jump, dr, dc);
            
            for(int i = 0; i < rr.size(); i++){
                mr.add("d" + jump + rr.get(i));
            }
        }
        
        return mr;
    }

}
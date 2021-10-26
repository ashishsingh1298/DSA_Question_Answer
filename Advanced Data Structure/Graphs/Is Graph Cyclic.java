import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
    static class Pair {
        int vtx;
        String psf;
        public Pair(int vtx, String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }
    
    boolean visited[] = new boolean[graph.length];
    for(int i = 0; i < graph.length; i++){
        if(visited[i] == false){
            boolean compans = isCompatible(graph, visited, i);
            if(compans == true){
                System.out.println(true);
                return;
            }
        }
    }
    System.out.println(false);
   }
   public static boolean isCompatible(ArrayList<Edge>[] graph, boolean[] visited, int src){
       
      Queue<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src, "" + src));
      
        while(q.size() != 0){
            Pair rp = q.remove();
            
            if(visited[rp.vtx] == false){
                visited[rp.vtx] = true;
                for(Edge e : graph[rp.vtx]){
                    int nbr = e.nbr;
                    if(visited[nbr] == false){
                        q.add(new Pair(nbr, rp.psf + nbr));
                    }
                }
            }else{
                return true;
            }
        }
        return false;
      
   }
}
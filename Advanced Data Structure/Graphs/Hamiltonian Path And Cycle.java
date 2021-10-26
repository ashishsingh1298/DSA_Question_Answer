import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
    //   boolean[] visited = new boolean[vtces];
    fun(graph, src, src, new boolean[graph.length], "" + src, 0);
   }

    public static void fun(ArrayList<Edge>[] graph, int src, int osrc, boolean[] visited, String asf, int vvsf){
        if(vvsf == graph.length - 1){
            System.out.print(asf);
            boolean isHc = false;
            for(Edge e : graph[osrc]){
                int nbr = e.nbr;
                if(nbr == src){
                    isHc = true;
                    break;
                }
            }
            if(isHc == true){
                System.out.println("*");
            }else{
                System.out.println(".");
            }
            return;
        }
        
        visited[src] = true;
        for(Edge e : graph[src]){
            int nbr = e.nbr;
            if(visited[nbr] == false){
                fun(graph, nbr, osrc,visited, asf + nbr,vvsf + 1);
            }
        }
        visited[src] = false;
    }
}
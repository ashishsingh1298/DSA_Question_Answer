import java.io.*;
import java.util.*;

public class Main {
    public static class Pair implements Comparable<Pair>{
        int vtx;
        String psf;
        int wsf;
        Pair(int vtx, String psf, int wsf){
            this.psf = psf;
            this.vtx = vtx;
            this.wsf = wsf;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
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
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      boolean[] visited = new boolean[graph.length];
      pq.add(new Pair(src, "" + src, 0));
      
      while(pq.size() > 0){
          
          Pair rp = pq.remove();
          
          if(visited[rp.vtx] == false){
              visited[rp.vtx] = true;
              System.out.println(rp.vtx + " via " + rp.psf + " @ " + rp.wsf);
              for(Edge e : graph[rp.vtx]){
                  int nbr = e.nbr;
                  if(visited[nbr] == false){
                    //   String st = ""+ rp.vtx + nbr;
                      pq.add(new Pair(nbr,rp.psf + nbr, rp.wsf + e.wt));
                  }
              }
          }
      }
   }
}
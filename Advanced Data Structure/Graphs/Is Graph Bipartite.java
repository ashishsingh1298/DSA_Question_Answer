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
   public static class Pair{
       int vtx;
       int level;
       
      public Pair(int vtx, int level){
          this.vtx = vtx;
          this.level = level;
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

     boolean[] visited = new boolean[vtces];
     for(int i = 0; i < graph.length; i++){
         if(visited[i] == false){
             boolean isCompBi = isBipartite(graph, visited, i);
             if(isCompBi == false){
                 System.out.println(false);
                 return;
             }
         }
     }
     System.out.println(true);
   }
   
   public static boolean isBipartite(ArrayList<Edge> [] graph, boolean[] visited, int src){
       
       Queue<Pair> q = new ArrayDeque<>();
       q.add(new Pair(src, 0));
       HashMap<Integer, Integer> map = new HashMap<>();
       
       while(q.size() > 0){
           Pair rp = q.remove();
           if(visited[rp.vtx] == true){
            //   This is already visied that means cycle present
                if(rp.level != map.get(rp.vtx)){
                    return false;
                }
           }else{
               visited[rp.vtx] = true;
               map.put(rp.vtx ,rp.level);
               for(Edge e : graph[rp.vtx]){
                   int nbr = e.nbr;
                   if(visited[nbr] == false){
                       q.add(new Pair(nbr,rp.level + 1));
                   }
               }
               
           }
       }
     return true;
   }
}
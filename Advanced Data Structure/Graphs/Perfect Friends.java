import java.io.*;
import java.util.*;

public class Main {
    static class Edge{
       int src;
       int nbr;
       Edge(int src, int nbr){
           this.nbr = nbr;
           this.src = src;
       }
   }

   public static void main(String[] args) throws Exception {
    //   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner scn = new Scanner(System.in);
    //   int n = Integer.parseInt(br.readLine());
    //   int k = Integer.parseInt(br.readLine());
      int n = scn.nextInt();
      int k = scn.nextInt();
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int i = 0; i < n; i++){
          graph[i] = new ArrayList<>();
      }
      for(int i = 0; i < k; i++){
        //   int a = Integer.parseInt(br.readLine());
        //   int b = Integer.parseInt(br.readLine());
            int a = scn.nextInt();
            int b = scn.nextInt();
          graph[b].add(new Edge(b,a));
          graph[a].add(new Edge(a,b));
      }
      
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean[] visited = new boolean[n];
      for(int i = 0; i < visited.length; i++){
          if(visited[i] == false){
              ArrayList<Integer> comp = new ArrayList<>();
              gcc(graph, i, visited, comp);
              comps.add(comp);
          }
      }
      int ans = 0;
      for(int i = 0; i < comps.size() - 1; i++){
          for(int j = i + 1; j < comps.size(); j++){
              ans += comps.get(i).size() * comps.get(j).size();
          }
      }
      System.out.println(ans);
   }
   
public static void gcc(ArrayList<Edge>[] graph,int src, boolean[] visited, ArrayList<Integer> comp){
    
    visited[src] = true;
    comp.add(src);
    for(Edge e : graph[src]){
        int nbr = e.nbr;
        if(visited[nbr] == false){
            gcc(graph, nbr, visited, comp);
        }
    }
    
}
}
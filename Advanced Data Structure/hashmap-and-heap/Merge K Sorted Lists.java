import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair implements Comparable<Pair> {
        int data;
        int li;
        int di;
    
        public Pair(int data, int li, int di){
            this.data = data;
            this.li = li;
            this.di = di;
        }
        
        public int compareTo(Pair o){
            return this.data - o.data;
        }
        
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> ans = new ArrayList<>();
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      
      for(int i = 0; i < lists.size(); i++){
        ArrayList<Integer> list = lists.get(i);
        pq.add(new Pair(list.get(0), i , 0));
      }
      
      while(pq.size() != 0){
          Pair rp = pq.remove();
          ans.add(rp.data);
          if(rp.di + 1 < lists.get(rp.li).size()){
            pq.add(new Pair(lists.get(rp.li).get(rp.di + 1),rp.li,rp.di + 1));
          }
      } 

      return ans;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
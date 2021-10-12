import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) {
      int bi = hashFunction(key);
      int di = findWithInbucket(key, bi);
      if(di == -1){
        //   key not exist
        buckets[bi].add(new HMNode(key, value));
        size++;
      }else{
          buckets[bi].get(di).value = value;
      }
      
      double lambda = (double)size / (double)buckets.length;
      if(lambda > 2.0){
          resize();
      }
    }
    public void resize(){
        LinkedList<HMNode>[] ob = buckets; 
        buckets = new LinkedList[2 * ob.length];
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }
        
        size = 0;
        for(int bi = 0; bi < ob.length; bi++){
            LinkedList<HMNode> ll = ob[bi];
            for(int i = 0; i < ll.size(); i++){
                put(ll.get(i).key, ll.get(i).value);
            }
        }
    }

    // return bucket index - > 0 to bucket.length -1
    
    public int hashFunction(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }
    
    // return data index
    public int findWithInbucket(K key, int bi){
        
        for(int i = 0; i < buckets[bi].size(); i++){
            if(buckets[bi].get(i).key.equals(key)){
                return i;
            }
        }
        return -1;
    }
    
    public V get(K key) {
      int bi = hashFunction(key);
      int di = findWithInbucket(key, bi);
      if(di == -1){
        return null;
      }else{
         return buckets[bi].get(di).value;
      }
    }

    public boolean containsKey(K key) {
      int bi = hashFunction(key);
      int di = findWithInbucket(key, bi);
      if(di == -1){
        return false;
      }else{
          return true;
      }
      
    }

    public V remove(K key) {
      int bi = hashFunction(key);
      int di = findWithInbucket(key, bi);
      if(di == -1){
        return null;
      }else{
          V rm = buckets[bi].get(di).value;
          buckets[bi].remove(di);
          size--;
          return rm;
      }
    }

    public ArrayList<K> keyset() {
      ArrayList<K> keys = new ArrayList<>();
      for(int bi = 0; bi < buckets.length; bi++){
          LinkedList<HMNode> ll = buckets[bi];
          for(int i = 0; i < ll.size(); i++){
              keys.add(ll.get(i).key);
          }
      }
      return keys;
    }

    public int size() {
        return this.size();
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
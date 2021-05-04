
package greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class PrimesMST {
    
    public static class Edge{
        int v;
        int nbr;
        int cost;
        
        Edge(int v,int nbr,int cost){
            this.v=v;
            this.nbr=nbr;
            this.cost=cost;
        }
        
        @Override
        public String toString(){
            return v+"->"+nbr+" Cost:"+cost;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int v;
        int av;
        int wt;

        public Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair t) {
            return this.wt-t.wt;
        }
        
      
    }
    
    public static void main(String args[]){
        Scanner in  = new Scanner(System.in);
        System.out.println("No of Vertuces:");
        int n=in.nextInt()+1;
        ArrayList<Edge>graph[]=new ArrayList[n];
        for(int i=1;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        System.out.println("No of Edges:");
        int edges = in.nextInt();
        
       for(int i=0;i<edges;i++){
           int src=in.nextInt();
           int dest=in.nextInt();
           int cost=in.nextInt();
           graph[src].add(new Edge(src,dest,cost));
           graph[dest].add(new Edge(dest,src,cost));
       }
        
//        Edge min=new Edge(-1,-1,Integer.MAX_VALUE);
//        
//        
//        for(int i=1;i<n;i++){
//            for(Edge e:graph[i]){
//                if(e.cost<min.cost){
//                    min =e;
//                }
//            }
//        }
//        System.out.println(min);
//        
        
          PriorityQueue<Pair>pq = new PriorityQueue<>();
          pq.add(new Pair(1,0,0));
          boolean vis[]=new boolean[n];
          
          while(!pq.isEmpty()){
              Pair rem = pq.poll();
              if(vis[rem.v])continue;
              vis[rem.v]=true;
              if(rem.av!=0)
                System.out.println(rem.av+"->"+rem.v+" @ "+rem.wt);
              for(Edge e:graph[rem.v]){
                  if(!vis[e.nbr]){
                      pq.add(new Pair(e.nbr,rem.v,e.cost));
                  }
              }
          }
        
        
    }
    
    
   
    
}


package Graphs;


import java.util.ArrayList;
import java.util.Scanner;


public class DFS {
    
    static class Edge{
        int src,nbr,wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
        
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int v=7;
        ArrayList<Edge>graph []= new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }
        
        graph[0].add(new Edge(0,3,40));
       graph[0].add(new Edge(0,1,10));
       
       graph[1].add(new Edge(1,0,10));
       graph[1].add(new Edge(1,2,10));
       
       graph[2].add(new Edge(2,3,10));
       graph[2].add(new Edge(2,1,10));
       
       graph[3].add(new Edge(3,0,40));
       graph[3].add(new Edge(3,2,10));
       graph[3].add(new Edge(3,4,2));
       
       graph[4].add(new Edge(4,3,2));
       graph[4].add(new Edge(4,5,3));
       graph[4].add(new Edge(4,6,3));
       
       graph[5].add(new Edge(5,4,3));
       graph[5].add(new Edge(5,6,3));
       
       graph[6].add(new Edge(6,5,3));
       graph[6].add(new Edge(6,4,8));
       boolean visited[]=new boolean[7];
        System.out.println(hasPath(graph, 0, 1,visited));
       
       
       
    }
    
    public static boolean hasPath(ArrayList<Edge>graph[],int src,int dest,boolean visited[]){
        if(src == dest)return true;
        
        visited[src]=true;
       
         for(Edge e : graph[src]){
              if(visited[e.nbr]==false){
                  boolean hasNbrPath = hasPath(graph, e.nbr, dest, visited);
                  if(hasNbrPath)return true;
              }
        }
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphs;

import java.util.ArrayList;



public class printPathsDFS {

  
    static class Edge{
        int src,nbr,wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
        
    }
    public static void main(String args[]){
      
       int vertices=7;
       ArrayList<Edge>graph[] = new ArrayList[vertices];
       for(int i=0;i<vertices;i++){
           graph[i] = new ArrayList<>();
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
       
       boolean visited[]=new boolean[10];
       
       
       printAllPaths(graph,0,3,visited,"");
       
    }
    
    public static void printAllPaths(ArrayList<Edge>[] graph,int src,int dest,boolean visited[],String psf){
        if(src == dest){
            System.out.print(psf+"\n");
            return;
        }
        visited[src]=true;
        for(Edge edge : graph[src]){
            if(visited[src]==false){
                printAllPaths(graph, edge.nbr, dest, visited, psf+edge.nbr);
            }
            
        }
        visited[src]=false;
    }
}

package Graphs;

import java.util.ArrayList;

public class ConnectedComponents {

    static class Edge {

        int wt, src, nbr;

        public Edge(int src, int nbr, int wt) {
            this.wt = wt;
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String args[]) {
        ArrayList<Edge> graph[] = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[4].add(new Edge(4, 5, 10));
        graph[5].add(new Edge(5, 6, 10));
        graph[4].add(new Edge(4, 6, 10));

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean visited[] = new boolean[7];
        for (int i = 0; i < 7; i++) {
            if (visited[i] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                getConnectedComponents(graph, i, comp, visited);
                comps.add(comp);
            }
        }
        System.out.println(comps);
    }

    public static void getConnectedComponents(ArrayList<Edge> graph[], int src, ArrayList<Integer> comp, boolean visited[]) {
        visited[src]=true;
        comp.add(src);
        for(Edge e:graph[src]){
            if(!visited[e.nbr]){
                getConnectedComponents(graph, e.nbr, comp, visited);
            }
        }
    }
}

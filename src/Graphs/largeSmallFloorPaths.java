package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class largeSmallFloorPaths {

    static class Pair implements Comparable<Pair> {

        int wsf;
        String psf;

        public Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }

    }

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

        graph[0].add(new Edge(0, 3, 40));
        graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 1, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

        boolean v[] = new boolean[10];
        multisolver(graph, 0, 6, v, 42, 3,"", 0);
        
        System.out.println("Smallest Path ="+spath+"@"+spathwt);
        System.out.println("Largest Path ="+lpath+"@"+lpathwt);
        System.out.println("Just largest Path ="+cpath+"@"+cpathwt);
        System.out.println("Just Smallest Path ="+fpath+"@"+fpathwt);
        System.out.println("3rd Smallest Path ="+pq.peek().psf+"@"+pq.peek().wsf);
        
        

    }
    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void multisolver(ArrayList<Edge> graph[], int src, int dest, boolean visited[], int criteria, int k, String psf, int wsf) {
        if (src == dest) {
            if (wsf < spathwt) {
                spathwt = wsf;
                spath = psf;
            }
            if (wsf > lpathwt) {
                lpathwt = wsf;
                lpath = psf;
            }
            if (wsf > criteria && wsf < cpathwt) {
                cpathwt = wsf;
                cpath = psf;
            }
            if (wsf < criteria && wsf > fpathwt) {
                fpathwt = wsf;
                fpath = psf;
            }

            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if (wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }
            return;
        }

        visited[src] = true;
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                multisolver(graph, e.nbr, dest, visited, criteria, k, psf + e.nbr, wsf + e.wt);
            }
        }
        visited[src] = false;
    }
}

package com.nirmal.grpahs;

public class Djikstra {
    private int vertices;
    private int graph[][];
    private int dist[];
    private boolean shortestDist[];
    Djikstra(int size) {
        vertices = size;
        dist = new int[size];
        graph = new int[size][size];
        shortestDist = new boolean[vertices];
        for (int i = 0; i < size; i++) {
            dist[i] = Integer.MAX_VALUE;
            shortestDist[i] = false;
        }
    }

    public void addEdge(int src, int dest, int weight) {
        graph[src][dest] = weight;
    }

    private int minDistance(int[] dist, boolean[] shortestDist) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < vertices; i++) {
            if(shortestDist[i] == false && dist[i] <= min)
            {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void djikstra(int startNode) {
        dist[startNode] = 0;

        for (int i = 0; i < vertices - 1; i++) {

            int u = minDistance(dist,shortestDist);
            shortestDist[u] = true;
            for (int v = 0; v < vertices; v++) {
                if(!shortestDist[v] && graph[u][v] != 0 &&  dist[u] != Integer.MAX_VALUE
                && dist[v] > dist[u] +  graph[u][v]) {
                    dist[v] = dist[u] +  graph[u][v];
                }
            }
        }
    }

    private void printSol() {
        for (int i = 0; i < vertices; i++) {
            System.out.println(dist[i]);
        }
    }
    public static void main(String[] args) {
        Djikstra g = new Djikstra(9);
        g.addEdge( 0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge( 1, 7, 11);
        g.addEdge( 2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge( 6, 8, 6);
        g.addEdge( 7, 8, 7);
        g.djikstra(0);
        g.printSol();
    }
}

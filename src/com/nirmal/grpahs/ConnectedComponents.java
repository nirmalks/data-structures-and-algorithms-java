package com.nirmal.grpahs;


import java.util.Iterator;
import java.util.LinkedList;

public class ConnectedComponents {
    static class Graph {
        int vertices;
        boolean visited[];
        LinkedList<Integer> adjList[];
        Graph(int vertices) {
            this.vertices = vertices;
            visited = new boolean[vertices];
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }


        private void connectedComponents() {
            boolean[] visited = new boolean[vertices];
            int numCC = 0;
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    DFSUtil(i,visited);
                    System.out.println();
                    numCC++;
                }
            }
            System.out.println("numcc" + numCC);
        }
        private void DFSUtil(int currentNode, boolean[] visited) {
                Iterator<Integer> iterator = adjList[currentNode].listIterator();
                while (iterator.hasNext()) {
                    int next = iterator.next();

                    if (!visited[next]) {
                        visited[next] = true;
                        System.out.print(next);

                        DFSUtil(next,visited);
                    }
                }
        }

        private void addEdge(int v, int w) {
            this.adjList[v].add(w);
            this.adjList[w].add(v);
        }
    }


    public static void main(String[] args) {
        ConnectedComponents cc = new ConnectedComponents();
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.connectedComponents();
    }
}

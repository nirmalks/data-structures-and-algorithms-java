package com.nirmal.grpahs;

import java.util.LinkedList;

public class BFSAdjMatrix {
    private int vertices;
    private int adjMatrix[][];

    BFSAdjMatrix(int size) {
        vertices = size;
        adjMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    private void BFS(int startNode) {
        boolean visited[] = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[startNode] = true;
        queue.add(startNode);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.println(currentNode);
            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[currentNode][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private void addEdge(int v , int w) {
        adjMatrix[v][w] = 1;
    }

    public static void main(String[] args) {
        BFSAdjMatrix g = new BFSAdjMatrix(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Adj Matrix Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
}

package com.nirmal.grpahs;

public class DFSAdjMatrixRecursive {
    private int vertices;
    private int adjMatrix[][];

    DFSAdjMatrixRecursive(int size) {
        vertices = size;
        adjMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = 0;
            }
        }

    }

    private void addEdge(int v, int w) {
        adjMatrix[v][w] = 1;
    }

    private void explore(int currentNode, boolean[] visited) {
        System.out.println(currentNode);
        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[currentNode][i] != 0 &&
                !visited[i]) {
                visited[i] = true;
                explore(i,visited);
            }
        }
    }

    private void DFS(int startNode) {
        boolean visited[] = new boolean[vertices];
        visited[startNode] = true;
        explore(startNode,visited);
    }
    public static void main(String[] args) {
        DFSAdjMatrixRecursive g = new DFSAdjMatrixRecursive(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        System.out.println("Following is Adj Matrix Recursive " +
                "Depth First Traversal "+
                "(starting from vertex 0)");

        g.DFS(2);
    }
}

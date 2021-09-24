package com.nirmal.grpahs;

import java.util.LinkedList;
import java.util.Stack;

public class DFSAdjMatrixIterative {
    private int vertices;
    private int adjMatrix[][];

    DFSAdjMatrixIterative(int size) {
        vertices = size;
        adjMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    private void DFS(int startNode) {
        boolean visited[] = new boolean[vertices];
        visited[startNode] = true;
        Stack<Integer> stack = new Stack();
        stack.add(startNode);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            System.out.println(currentNode);
            for (int i = 0; i < vertices; i++) {
                if(adjMatrix[currentNode][i] != 0) {
                    int nextNode = i;
                    if(!visited[nextNode]) {
                        stack.add(nextNode);
                        visited[nextNode] = true;
                    }
                }
            }
        }
    }

    private void addEdge(int v, int w) {
        adjMatrix[v][w] = 1;
    }

    public static void main(String[] args) {
        DFSAdjMatrixIterative g = new DFSAdjMatrixIterative(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        System.out.println("Following is Adj Matrix Depth First Traversal "+
                "(starting from vertex 0)");

        g.DFS(2);
    }
}

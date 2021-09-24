package com.nirmal.grpahs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSAdjListRecursive {
    private LinkedList<Integer> adjList[];
    int vertices;

    DFSAdjListRecursive(int size) {
        vertices = size;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < size; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }

    private void explore(int currentNode, boolean visited[]) {
        System.out.println(currentNode);
        Iterator<Integer> adjIterator = adjList[currentNode].listIterator();
        while (adjIterator.hasNext()) {
            int nextNode = adjIterator.next();
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                explore(nextNode,visited);
            }
        }
    }

    private void DFS(int startNode) {
        boolean visited[] = new boolean[vertices];
        visited[startNode] = true;
        explore(startNode,visited);
    }

    private void addEdge(int v, int w) {
        this.adjList[v].add(w);
    }

    public static void main(String[] args) {
        DFSAdjListRecursive g = new DFSAdjListRecursive(5);
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

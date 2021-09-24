package com.nirmal.grpahs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSAdjList {
    private int vertices;

    private LinkedList<Integer> adj[];

    BFSAdjList(int size) {
        vertices = size;
        adj = new LinkedList[vertices];
        for (int i = 0; i < size; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int v,int weight) {
        this.adj[v].add(weight);
    }

    private void BFS(int startNode) {
        boolean visited[] = new boolean[vertices];
        visited[startNode] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.println("node " + currentNode);
            Iterator<Integer> adjListIterator = this.adj[currentNode].listIterator();
            while (adjListIterator.hasNext()) {
                int nextNode = adjListIterator.next();
                if (!visited[nextNode]) {
                    queue.add(nextNode);

                    visited[nextNode] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        BFSAdjList g = new BFSAdjList(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
}

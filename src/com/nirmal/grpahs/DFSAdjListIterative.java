package com.nirmal.grpahs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSAdjListIterative {
    private LinkedList<Integer> adjList[];
    int vertices;

    DFSAdjListIterative(int size) {
        vertices = size;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < size; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }

    private void DFS(int startNode) {
        boolean visited[] = new boolean[vertices];
        Stack<Integer> stack = new Stack();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            if (!visited[currentNode]) {
                System.out.println(currentNode);
                visited[currentNode] = true;
            }
            Iterator<Integer> adjIterator = adjList[currentNode].listIterator();
            while (adjIterator.hasNext()) {
                int nextNode = adjIterator.next();
                if (!visited[nextNode]) {
                    stack.push(nextNode);
                }
            }
        }
    }

    private void addEdge(int v, int w) {
        this.adjList[v].add(w);
    }

    public static void main(String[] args) {
        DFSAdjListIterative g = new DFSAdjListIterative(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        System.out.println("Following is Adj Matrix Depth First Traversal "+
                "(starting from vertex 0)");

        g.DFS(0);
    }
}

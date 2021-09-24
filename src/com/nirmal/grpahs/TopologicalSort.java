package com.nirmal.grpahs;

import java.util.*;

public class TopologicalSort {
    private LinkedList<Integer> adjList[];
    int vertices;
    int preVisit[];
    int postVisit[];
    int clock = 0;
    TopologicalSort(int size) {
        vertices = size;
        adjList = new LinkedList[vertices];
        preVisit = new int[vertices];
        postVisit = new int[vertices];
        for (int i = 0; i < size; i++) {
            this.adjList[i] = new LinkedList<>();
            preVisit[i] = 0;
            postVisit[i] = 0;
        }
    }

    private void explore(int currentNode, boolean visited[], Stack<Integer> postVisitStack) {
        Iterator<Integer> adjIterator = adjList[currentNode].listIterator();
        while (adjIterator.hasNext()) {
            int nextNode = adjIterator.next();
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                explore(nextNode,visited,postVisitStack);
            }
        }
        postVisitStack.push(currentNode);
        clock++;
        postVisit[currentNode] = clock;
    }

    private boolean isCyclic() {
        boolean visited[] = new boolean[vertices];
        boolean recursionStack[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
            recursionStack[i] = false;
        }

        for (int i = 0; i < vertices; i++) {
            if (isCycleUtil(i, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCycleUtil(int vertex, boolean[] visited, boolean[] recursionStack) {
        if (!visited[vertex]) {
            visited[vertex] = true;
            recursionStack[vertex] = true;
        }
        Iterator<Integer> listIterator = adjList[vertex].iterator();
        while (listIterator.hasNext()) {
            int next = listIterator.next();
            if (!visited[next] && isCycleUtil(next,visited,recursionStack)) {
                return true;
            } else if (recursionStack[next]) {
                return true;
            }
        }
        recursionStack[vertex] = false;
        return false;
    }

    private void DFS() {
        Stack<Integer> postVistStack = new Stack<>();
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                visited[i] = true;
                clock++;
                preVisit[i] = clock;
                explore(i, visited, postVistStack);
            }
        }

        while (!postVistStack.isEmpty()) {
            while(postVistStack.elements().asIterator().hasNext()) {
                System.out.println("top sort" + postVistStack.pop());
            }
        }
//        for (int i = 0; i < postVisit.length; i++) {
//            Collections.reverse(Arrays.asList(postVisit));
//            System.out.println(postVisit[i]);
//        }
    }

    private void addEdge(int v, int w) {
        this.adjList[v].add(w);
    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 5);
        g.addEdge(3, 1);

        System.out.println("has cycle" + g.isCyclic());
        System.out.println("Following is Adj Matrix Depth First Traversal "+
                "(starting from vertex 0)");

        g.DFS();
    }
}

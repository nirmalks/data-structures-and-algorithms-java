package com.nirmal.grpahs;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedComponents {
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


        private void getSCC() {
            boolean[] visited = new boolean[vertices];
            Stack stack = new Stack();
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                   fillStackOrder(i,visited,stack);
                }
            }
            Graph reverseGraph = reverseGraph();
            for (int i = 0; i < vertices; i++) {
                visited[i] = false;
            }

            while (!stack.isEmpty()) {
                int v = (int)stack.pop();
                if (!visited[v]) {
                    reverseGraph.DFSUtil(v,visited);
                    System.out.println();
                }
            }
        }
        private void DFSUtil(int currentNode, boolean[] visited) {
            visited[currentNode] = true;
            System.out.print(currentNode + " ");
            Iterator<Integer> iterator = adjList[currentNode].listIterator();
            while (iterator.hasNext()) {
                int next = iterator.next();

                if (!visited[next]) {
                    visited[next] = true;

                    DFSUtil(next,visited);
                }
            }
        }

        private void fillStackOrder(int index, boolean[] visited, Stack stack) {
            visited[index] = true;
            Iterator<Integer> iterator = adjList[index].iterator();
            while(iterator.hasNext()) {
                int next = iterator.next();
                if(!visited[next]) {
                    fillStackOrder(next,visited,stack);
                }
            }
            stack.push(new Integer(index));
        }

        private Graph reverseGraph() {
            Graph g = new Graph(vertices);
            for (int i = 0; i < vertices; i++) {
                Iterator<Integer> iterator = adjList[i].iterator();
                while (iterator.hasNext()) {
                    int currentNode = iterator.next();
                    g.adjList[currentNode].add(i);
                }
            }
            return g;
        }

        private void addEdge(int v, int w) {
            this.adjList[v].add(w);
        }
    }


    public static void main(String[] args) {
        StronglyConnectedComponents cc = new StronglyConnectedComponents();
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.getSCC();
    }
}

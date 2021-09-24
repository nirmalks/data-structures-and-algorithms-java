package com.nirmal.grpahs;

import java.math.BigDecimal;
import java.util.LinkedList;

public class BipartiteGraph {
    private int vertices;
    private int adjMatrix[][];
    private int color[];

    BipartiteGraph(int size) {
        vertices = size;
        color = new int[vertices];
        adjMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = 0;
            }
        }

        for (int i = 0; i < vertices; i++) {
            color[i] = -1;
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

    private boolean isBipartite(int srcNode) {
        color[srcNode] = 1;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(srcNode);

        while (!q.isEmpty()) {
            int currentNode = q.poll();

            //return false is self loop is present
            if (adjMatrix[currentNode][currentNode] == 1) {
                return false;
            }
            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[currentNode][i] == 1 && color[i] == -1) {
                    color[i] = 1 - color[currentNode];
                    q.add(i);
                } else if(adjMatrix[currentNode][i] == 1 &&
                        color[i] == color[currentNode]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        BipartiteGraph bg = new BipartiteGraph(5);
        bg.addEdge(0,1);
        bg.addEdge(0,3);
        bg.addEdge(1,0);
        bg.addEdge(1,2);
        bg.addEdge(2,1);
        bg.addEdge(2,3);
        bg.addEdge(3,2);
        bg.addEdge(3,0);
        System.out.println(bg.isBipartite(0));
    }
}

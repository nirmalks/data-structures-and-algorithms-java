package com.nirmal.grpahs;

public class UnionFindCC {
    static class Edge {
        int src;
        int dest;
    }
    int parentArray[];
    int sizeArray[];
    Edge edges[];
    UnionFindCC(int size) {
        parentArray = new int[size];
        sizeArray = new int[size];
        edges = new Edge[size];
        for (int i = 0; i < size; i++) {
            parentArray[i] = i;
            sizeArray[i] = 1;
            edges[i] = new Edge();
        }
    }

    private int root(int parentArray[] , int i) {
        while (parentArray[i] != i) {
//            parentArray[i] = parentArray[parentArray[i]];

            i = parentArray[i];
        }
        return i;
    }

    private int connectedComponents() {
        int numCC = sizeArray.length;
        for (int i = 0; i < this.parentArray.length  ; i++) {
           int x = edges[i].src;
           int y = edges[i].dest;
           int xRoot = root(parentArray,x);
           int yRoot = root(parentArray,y);

           if (xRoot != yRoot) {
               numCC--;
               union(parentArray,x,y);
               parentArray[xRoot] = yRoot;
           }

        }
        System.out.println("numcc" + numCC);
        return numCC;
    }

    private void union(int parentArray[], int a , int b) {
        int parentA = parentArray[a];
        int parentB = parentArray[b];
        parentArray[parentA] = parentB;
//        sizeArray[a]++;
    }

    private boolean find(int a, int b) {
        return parentArray[a] == parentArray[b];
    }

    private void addEdge(int src, int dest) {
        edges[src].src = src;
        edges[src].dest = dest;
    }

    public static void main(String[] args) {
        UnionFindCC graph = new UnionFindCC(3);
        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;

        // add edge 1-2
        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;

        // add edge 0-2
        graph.edges[2].src = 0;
        graph.edges[2].dest = 2;
        graph.connectedComponents();
    }
}

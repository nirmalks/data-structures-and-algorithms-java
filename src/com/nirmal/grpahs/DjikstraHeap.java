package com.nirmal.grpahs;

import java.util.LinkedList;

public class DjikstraHeap {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source , int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class HeapNode {
        int vertex;
        int distance;
    }

    static class Graph {
        int vertices;
        LinkedList[] adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest, int weight) {
            Edge edge = new Edge(src,dest,weight);
            adjList[src].add(edge);
            adjList[dest].addFirst(edge); // undirected graph
        }

         public void dijkstra(int startNode) {
             int INFINITY = Integer.MAX_VALUE;
             boolean spt[] = new boolean[vertices];
             HeapNode[] heapNodes = new HeapNode[vertices];
             for (int i = 0; i < vertices ; i++) {
                    heapNodes[i] = new HeapNode();
                    heapNodes[i].vertex = i ;
                    heapNodes[i].distance = INFINITY;
                }
                heapNodes[startNode].distance = 0;
                MinHeap minHeap = new MinHeap(vertices);

                for (int j = 0; j < vertices; j++) {
                    minHeap.insert(heapNodes[j]);
                }

                while (minHeap.currentSize != 0) {
                    //extract min
                    HeapNode currentNode = minHeap.extractMin();
                    int currentVertex = currentNode.vertex;
                    spt[currentVertex] = true;

                    LinkedList<Edge> list = adjList[currentVertex];
                    for (int j = 0; j < list.size(); j++) {
                        Edge edge = list.get(j);
                        int destination = edge.destination;

                        if (!spt[destination]) {
                            ///check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance
                            int newKey = heapNodes[currentVertex].distance + edge.weight;
                            int currentKey = heapNodes[destination].distance;
                            if (currentKey > newKey) {
                                decreaseKey(minHeap,newKey,destination);
                                heapNodes[destination].distance = newKey;
                            }
                        }
                    }
                }
                 printDjikstra(heapNodes,startNode);
            }
        public void decreaseKey(MinHeap minHeap, int newKey, int vertex){

            //get the index  which distance's needs a decrease;
            int index = minHeap.indexes[vertex];

            //get the node and update its value
            HeapNode node = minHeap.minHeap[index];
            node.distance = newKey;
            minHeap.siftUp(index);
        }

        void printDjikstra(HeapNode[] heapNodes, int sourceVertex) {
            for (int i = 0; i < vertices; i++) {
                System.out.println("Src v" + sourceVertex + "to " + heapNodes[i].distance);
            }
        }
    }

    static class  MinHeap {
        int capacity;
        int currentSize;
        DjikstraHeap.HeapNode[] minHeap;
        int[] indexes;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            minHeap = new DjikstraHeap.HeapNode[capacity + 1];
            indexes = new int[capacity];
            minHeap[0] = new DjikstraHeap.HeapNode();
            minHeap[0].distance = Integer.MIN_VALUE;
            minHeap[0].vertex = -1;
            currentSize = 0;
        }

        public void insert(DjikstraHeap.HeapNode el) {
            if (currentSize == capacity) {
                System.out.println("Cannot insert arr capacity is full");
                return;
            }

            // at the end
            currentSize++;
            int idx = currentSize;
            minHeap[idx] = el;
            indexes[el.vertex] = idx;
            siftUp(idx);
        }

        public void siftUp(int currentIndex) {
            int parentIndex = currentIndex / 2;
            while (currentIndex > 0 && minHeap[parentIndex].distance > minHeap[currentIndex].distance) {
                DjikstraHeap.HeapNode currentNode = minHeap[currentIndex];
                DjikstraHeap.HeapNode parentNode = minHeap[parentIndex];
                indexes[currentNode.vertex] = parentIndex;
                indexes[parentNode.vertex] = currentIndex;
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
                parentIndex = parentIndex / 2;
            }
        }

        public void swap(int a, int b) {
            DjikstraHeap.HeapNode temp = minHeap[a];
            minHeap[a] = minHeap[b];
            minHeap[b] = temp;
        }

        public void siftDown(int i) {
            int minIndex = i;
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            if (leftIndex < currentSize && minHeap[leftIndex].distance < minHeap[minIndex].distance) {
                minIndex = leftIndex;
            } else if (rightIndex < currentSize && minHeap[rightIndex].distance < minHeap[minIndex].distance) {
                minIndex = rightIndex;
            }
            if (i != minIndex) {
                DjikstraHeap.HeapNode smallestNode = minHeap[minIndex];
                DjikstraHeap.HeapNode currentNode = minHeap[i];
                indexes[smallestNode.vertex] = i;
                indexes[currentNode.vertex] = minIndex;
                swap(i, minIndex);
                siftDown(minIndex);
            }
        }

        public DjikstraHeap.HeapNode extractMin() {
            DjikstraHeap.HeapNode min = minHeap[1];
            DjikstraHeap.HeapNode lastNode = minHeap[currentSize];
            indexes[lastNode.vertex] = 1;
            minHeap[1] = lastNode;
            minHeap[currentSize] = null;
            siftDown(1);
            currentSize--;
            return min;
        }

    }
    public static void main(String[] args) {
        DjikstraHeap.Graph g = new DjikstraHeap.Graph(9);
        g.addEdge( 0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge( 1, 7, 11);
        g.addEdge( 2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge( 6, 8, 6);
        g.addEdge( 7, 8, 7);
        g.dijkstra(0);
    }
}

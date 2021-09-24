package com.nirmal.BinaryHeap;

public class BinaryHeap {
    int size;
    int capacity ;
    int heightArray[];

    BinaryHeap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.heightArray = new int[capacity];
    }

    public void heapify() {

    }

    public void insert(int el) {
        if (size == capacity) {
            System.out.println("Cannot insert arr capacity is full");
            return;
        }

        // at the end
        size++;
        heightArray[size - 1] = el;

        int i = size - 1;
        siftUp(i,heightArray);
    }

    public int parent(int i ) {
        return (i - 1) / 2;
    }

    public int leftChlld(int i) {
        return 2 * i + 1;
    }

    public int rightChlld(int i) {
        return 2 * i + 2;
    }

    public void siftUp(int i , int[] heightArray) {
        // i not root and
        while(i != 0 && heightArray[parent(i)] < heightArray[i]) {
            int temp = heightArray[parent(i)];
            heightArray[parent(i)] = heightArray[i];
            heightArray[i] = temp;
            i = parent(i);
        }
    }

    public void printArray() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(heightArray[i]);
        }
    }

    // returns the maximum
    public int getMax() {
        return heightArray[0];
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int extractMax() {
        int root = heightArray[0];
        heightArray[0] = heightArray[size - 1];
        this.size--;
        siftDown(0,heightArray);
        return root;
    }

    public void siftDown(int i, int[] heightArray) {
        int maxIndex = i;
        int leftIndex = leftChlld(i);
        int rightIndex = rightChlld(i);
        if (leftIndex < size && heightArray[leftIndex] > heightArray[maxIndex]) {
            maxIndex = leftIndex;
        } else if(rightIndex < size && heightArray[rightIndex] > heightArray[maxIndex]) {
            maxIndex = rightIndex;
        }
        if(i != maxIndex) {
            int temp = heightArray[i];
            heightArray[i] = heightArray[maxIndex];
            heightArray[maxIndex] = temp;
            siftDown(maxIndex,heightArray);
        }
    }

    public void remove(int index) {
        heightArray[index] = Integer.MAX_VALUE;
        siftUp(index, heightArray);
        extractMax();
    }

    public void buildHeap(int[] arr) {
        int size = arr.length - 1;
        for (int i = 1 / 2; i > 0; i--) {
            siftDown(i, arr);
        }
    }
    public void heaapify(int[] arr) {

    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        BinaryHeap bh = new BinaryHeap(5);
        bh.insert(1);
        bh.insert(2);
        bh.insert(3);
        bh.printArray();
        System.out.println("get max" + bh.getMax());
        System.out.println("get size" + bh.getSize());
        System.out.println("is empty" + bh.isEmpty());
        System.out.println("extract max" + bh.extractMax());
        bh.printArray();
        bh.insert(5);
        bh.printArray();
        System.out.println("remove el at index 1" );
        bh.remove(1);
        bh.printArray();
    }
}

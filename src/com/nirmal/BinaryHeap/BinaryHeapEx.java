package com.nirmal.BinaryHeap;

public class BinaryHeapEx {
    int size;
    int capacity;
    int heapArray[];

    BinaryHeapEx(int size) {
        this.size = 0;
        this.capacity = size;
        heapArray = new int[size];
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(heapArray[i]);
        }
    }

    public static void main(String[] args) {
        BinaryHeapEx bh = new BinaryHeapEx(5);
        bh.insert(5);
        bh.insert(4);
        bh.insert(3);
        bh.printArray();
        System.out.println("get min" + bh.getMin());
        System.out.println("get size" + bh.getSize());
        System.out.println("is empty" + bh.isEmpty());
        System.out.println("extract min" + bh.extractMin());
        bh.printArray();
        bh.insert(2);
        System.out.println("get min" + bh.getMin());
        bh.printArray();
        System.out.println("remove el at index 1" );
        bh.remove(1);
        bh.printArray();
        System.out.println("insert 5");
        bh.insert(5);
        bh.printArray();
        System.out.println("change key at index to 1");
        bh.decreaseKey(2,1);
        bh.printArray();
    }
    private int extractMin() {
        int root = heapArray[0];
        heapArray[0] = heapArray[size - 1];
        size--;
        siftDown(size);
        return root;
    }

    private void remove(int i) {
        heapArray[i] = heapArray[size - 1];
        size--;
        siftDown(size);
    }

    private void insert(int i) {
        size++;
        heapArray[size - 1] = i;
        siftUp(size - 1);
    }

    private void siftUp(int i) {
        int parent = i / 2;
        while(i != 0 && heapArray[parent] > heapArray[i]) {
            int temp  = heapArray[parent];
            heapArray[parent] = heapArray[i];
            heapArray[i] = temp;
            i = parent;
            parent = parent / 2;
        }
    }

    private void siftDown(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIndex = i;
        if (left < size && heapArray[left] < heapArray[i]) {
            minIndex = left;
        }
        else if(right < size && heapArray[right] < heapArray[i]) {
            minIndex = right;
        }
        if (minIndex != i) {
            int temp = heapArray[minIndex];
            heapArray[minIndex] = heapArray[i];
            heapArray[i] = temp;
            siftDown(i);
        }
    }

    private void decreaseKey(int index, int newVal) {
        heapArray[index] = newVal;
        siftUp(index);
    }

    private boolean isEmpty() {
        return heapArray.length == 0;
    }

    private int getSize() {
        return size;
    }

    private int getMin() {
        return heapArray[0];
    }
}

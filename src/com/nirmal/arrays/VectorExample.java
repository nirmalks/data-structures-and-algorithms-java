package com.nirmal.arrays;

import java.util.Arrays;

public class VectorExample {
    public static void main(String[] args) {
        VectorImpl vector = new VectorImpl();
        vector.push(100);
        vector.insert(20,3);
        vector.insert(20,5);
        vector.prepend(1);
        System.out.println("popped data " + vector.pop());
        System.out.println("find 1 " + vector.find(1));
        System.out.println("find 1000 " + vector.find(1000));
        vector.remove(20);
        vector.printData();
        vector.delete(3);
        vector.printData();
        System.out.println(vector.at(0));
        System.out.println(vector.capacity());
        System.out.println(vector.isEmpty());
        System.out.println(vector.size());
    }
}

class VectorImpl {
    private Object[] data;
    private int elementCount;
    private int capacity;
    private int capacityIncrement;

    VectorImpl(int size) {
        this.capacity = size;
        this.data = new Object[capacity];
    }

    VectorImpl() {
        this.capacity = 10;
        this.data = new Object[capacity];
    }

    int size() {
       return elementCount;
    }

    int capacity() {
        return data.length;
    }

    boolean isEmpty() {
        return elementCount == 0;
    }

    Object at(int index) {
        return data[index];
    }

    void push(Object value) {
        growSize();
        // add the item at end of array (capacity - 1)
        data[capacity-1] = value;
        this.elementCount++;

    }

    void insert(Object value, int index) {
        growSize();
        data[index] = value;
        this.elementCount++;
    }

    void prepend(Object value) {
        insert(value, 0);
    }

    Object pop() {
        Object value = data[capacity-1];
        //set last item to null
        data[capacity-1] = null;
        elementCount--;
        trimSize();
        return value;
    }

    //returns the index of value
    int find(Object value) {
        for (int i = 0; i < capacity; i++) {
            if (value == data[i]) {
                return i;
            }
        }
        return -1;
    }

    void remove(Object value) {
        for (int i = 0; i < capacity; i++) {
            if (value == data[i]) {
                data[i] = null;
                elementCount--;
            }
        }
        trimSize();
    }

    Object delete(int index) {
        Object oldValue = data[index];
        /*
        srcArray - data
        srcIndex - index + 1  (index from which copying starts)
        dstArray - data
        dstIndex - index  (index from copied elements are placed in dest array)
        length of new array - capacity - index - 1 (number of elements to be copied)

        eg: 1,2,3,4,5 delete(1)  - index is 1
        src index - 2
        dest index - 1
        capacity - 10
        length of new array - 8

        elements from index 2 (total of 8 elements from there) will be copied to dst array
        at index 1
        So (3,4,5) will be placed from index 1 (after 1) 1 (3,4,5)
        => 1,3,4,5
         */
        if (index > 0)
            System.arraycopy(data, index+1, data, index, capacity - index - 1);
        elementCount--;
        trimSize();
        return oldValue;
    }

    void printData() {
        for (Object o:
             data) {
            System.out.println(o);
        }
    }

    private void growSize() {
        // if size == capacity , double the array size
        if (elementCount == capacity) {
            setSize(capacity * 2);
        }
    }

    private void trimSize() {
        // if size is 25% of capacity then trim
        int percentage = (elementCount * 100) / capacity;
        if (percentage < 25) {
            setSize(capacity / 2);
        }
    }

    private void setSize(int size) {
        this.capacity = size;
        data = Arrays.copyOf(data, size);
    }
}
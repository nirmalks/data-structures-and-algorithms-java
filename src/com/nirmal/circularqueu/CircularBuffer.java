package com.nirmal.circularqueu;

public class CircularBuffer {
    /*
    Same idea as queeue
    Except in queue even if queue has empty space in the array we cannot insert when its full
    In circular buffer we can

    In enequee we use the rear pointer to insert
    During deequee we use the front pointer to remove
     */
    private int capacity;
    private int front;
    private int rear;
    private int queueArray[];

    CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.front = this.rear = -1;
        this.queueArray = new int[capacity];
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
//        cb.printList();
        System.out.println("Dequeued item " + cb.dequeue());
        System.out.println("Dequeued item " + cb.dequeue());
        cb.enqueue(2);
        cb.printList();
    }

    private boolean isEmpty() {
        return this.front == -1 ;
    }

    private boolean isFull() {
        return (this.rear == capacity - 1 && this.front == 0) ||
                (rear == (front - 1) % (capacity - 1));
    }

    private int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int result = queueArray[front];

        // Condition for only one element
        if (front == rear) {
            front = rear = -1;
        }
        // if front is at end of the queue, then move front to the beginning
        else if (front == capacity - 1) {
            front = 0;
        } else {
            this.front ++;
        }
        return result;
    }

    private void enqueue(int i) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        // condition for empty queue.
        if (front == -1) {
            front = rear = 0;
        }
        // rear is at the end and if front is not at 0
        // ie there are emtpy spaces in the front of the quue
        // then set rear = 0
        else if (rear == capacity - 1 && front != 0) {
            this.rear = 0;
        } else {
            this.rear++;
        }
        this.queueArray[rear] = i;
    }

    public void printList() {
        for(int i = 0 ; i < this.capacity ; i++) {
            System.out.println("\n" + queueArray[i]);
        }
    }
}

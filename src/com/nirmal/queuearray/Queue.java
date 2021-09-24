package com.nirmal.queuearray;

/**
 * Created by nirmal on 29/8/17.
 */
public class Queue {

    private int capacity = 10;
    private int front , rear = 0;
    private int size = 0;

    private int queueArray[];
    public boolean empty(){
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean full() {
        if(size == capacity) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(int value) {
        if(full()){
            return ;
        } else {
            this.rear = (this.rear + 1) % this.capacity;
            queueArray[this.rear] = value;
            System.out.print("rear value" + this.rear);
            this.size ++;
        }
    }

    public int dequeue() {
        if(empty()){
            return 0;
        } else {
            int temp = queueArray[this.front];
            this.front = (this.front + 1) % this.capacity;
            this.size --;
            return temp;
        }
    }

    public Queue() {
        this.front = 0;
        this.queueArray = new int[capacity];
        this.rear = this.capacity - 1;
    }

    public void printList() {
        for(int i = 0 ; i < this.capacity ; i++) {
            System.out.println("\n" + queueArray[i]);
        }
    }

    public static void main(String[] args) {
        Queue queueImpl = new Queue();
        queueImpl.enqueue(1);
        queueImpl.enqueue(2);
        queueImpl.enqueue(3);
        queueImpl.printList();
        System.out.println("Dequeued item " + queueImpl.dequeue());
        queueImpl.printList();
    }

}

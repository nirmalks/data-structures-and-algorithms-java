package com.nirmal.queuell;

public class QueueLinkedList {
   LinkededListNode head , tail;

    public QueueLinkedList() {
        this.head = null;
        this.tail = null;
    }

    private void enqueue(Object value) {
        LinkededListNode newNode = new LinkededListNode(value);
        if(empty()) {
            this.head = this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;
    }

    private Object dequeue() {
        if(this.head == null) {
            return null;
        }
        LinkededListNode temp = this.head;
        this.head = this.head.next;
        if(this.head == null) {
            this.tail = null;
        }
        return temp.data;
    }

    private boolean empty() {
        return this.tail == null;
    }

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(10);
        q.enqueue(20);
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println(q.dequeue());
    }
}

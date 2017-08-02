package com.nirmal.linkedlist;

/**
 * Created by Nirmal on 7/28/2017.
 */
public class LinkedListMain {
    LinkedListNode head;

    public int getSize() {
        return size;
    }

    private int size;
    public LinkedListMain(){
        this.head = null;
    }

    public LinkedListMain(LinkedListNode node) {
        this.head = node;
    }

    public void printList() {
        LinkedListNode node = this.head;
        while( node != null ) {
            System.out.println(node.item);
            this.size++;
            node = node.next;
        }
    }

    public boolean isEmpty() {
        if(this.getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Object front() {
        LinkedListNode firstNode = this.head;
        Object data = firstNode.item;
        return data;
    }

    public void push_front(int value) {
        LinkedListNode newNode = new LinkedListNode(value);
        newNode.next = head;
        this.head = newNode;
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(1);
        LinkedListNode second = new LinkedListNode(2);
        LinkedListNode third = new LinkedListNode(3);
        LinkedListMain list = new LinkedListMain(first);
        list.head.next = second;
        second.next = third;

        list.printList();
        System.out.println("Size of the list " + list.size);
        System.out.println("Is the list empty " + list.isEmpty());
        System.out.println("value of first item " + list.front());
        list.push_front(10);
        System.out.println("value of first item " + list.front());
        list.printList();
    }
}

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

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(1);
        LinkedListNode second = new LinkedListNode(2);
        LinkedListNode third = new LinkedListNode(3);
        LinkedListMain list = new LinkedListMain(first);
        list.head.next = second;
        second.next = third;

        list.printList();
        System.out.println("Size of the list " + list.size);
    }
}

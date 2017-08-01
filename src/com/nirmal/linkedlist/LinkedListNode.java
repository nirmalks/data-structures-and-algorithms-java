package com.nirmal.linkedlist;

/**
 * Created by Nirmal on 7/28/2017.
 */
public class LinkedListNode {

    int item;
    LinkedListNode next;

    public LinkedListNode(int item , LinkedListNode next){
        this.item = item;
        this.next = next;
    }

    public LinkedListNode(int item) {
        this(item, null);
    }
}

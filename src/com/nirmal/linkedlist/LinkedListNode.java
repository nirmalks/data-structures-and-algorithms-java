package com.nirmal.linkedlist;

/**
 * Created by Nirmal on 7/28/2017.
 */
public class LinkedListNode {

    Object item;
    LinkedListNode next;

    public LinkedListNode(Object item , LinkedListNode next){
        this.item = item;
        this.next = next;
    }

    public LinkedListNode(Object item) {
        this(item, null);
    }
}

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
        System.out.println("The contents of the list are ");
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

    public Object back() {
        LinkedListNode lastNode = this.head;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        return lastNode.item;
    }


    public Object popFront() {
        LinkedListNode head = this.head;
        this.head = this.head.next;
        return head.item;
    }

    public Object popBack() {
        LinkedListNode last = this.head;
        LinkedListNode prevNode = null;
        while(last.next != null) {
            if(last.next.next == null){
                prevNode = last;
            }
            last = last.next;
        }

        Object lastItem = last.item;
        last = null;
        prevNode.next = null;
        return lastItem;
    }

    public void insert(int index , Object value) {
        LinkedListNode newNode = new LinkedListNode(value);
        LinkedListNode currentNode = this.head;
        for(int i = 0 ; i < index; i++) {
            LinkedListNode prevNode = currentNode;
            currentNode = currentNode.next;
            System.out.println(currentNode.item);
            System.out.println(currentNode.next);
            if( i + 1 == index) {
                newNode.next = currentNode.next;
                System.out.println("last element");
                currentNode = newNode;
                prevNode.next = newNode;
                System.out.println(currentNode.item);
                return;
            }
        }
    }

    public void pushFront(Object value) {
        LinkedListNode newNode = new LinkedListNode(value);
        newNode.next = head;
        this.head = newNode;
    }

    public void pushBack(Object value) {
        LinkedListNode head = this.head;
        LinkedListNode newNode = new LinkedListNode(value);
        LinkedListNode lastNode = head;

        if(this.isEmpty()) {
            head = newNode;
            return;
        }


            while( head.next != null) {
                lastNode = head.next;
            }
            System.out.println(lastNode);

        lastNode.next = newNode;

    }

    public Object valueAt(int index) {
        LinkedListNode currentNode = this.head;
        for(int i = 0 ; i < index; i++) {
            currentNode = currentNode.next;
            if( i + 1 == index) {
                return currentNode.item;
            }
        }
        return null;
    }

    public Object getValueOfNthItemFromEnd(int index){
        LinkedListNode headNode = this.head;
        int totalSize = this.getSize();
        for(int i = 0 ; i < totalSize - index - 1 ; i++) {
            if(headNode.next != null) {
                headNode = headNode.next;
            }
        }
        return headNode.item ;
    }

    public void eraseNode(int index) {
        LinkedListNode currentNode = this.head;
        LinkedListNode prevNode = null;
        for(int i = 0; i < this.getSize() ; i++) {
            prevNode = currentNode;
            if(currentNode.next != null) {
                currentNode = currentNode.next;

                if (i + 1 == index) {
                    prevNode.next = currentNode.next;
                    currentNode = prevNode;
                }
            }
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
        System.out.println("Is the list empty " + list.isEmpty());
        System.out.println("value of first item " + list.front());
        list.pushFront(10);
        System.out.println("value of first item " + list.front());
        list.printList();
        list.popFront();
        list.printList();
        list.pushBack(20);
        list.printList();
        list.popBack();
        list.printList();
        System.out.println("Value of the last item " + list.back());
        list.insert(1,100);
        list.printList();
        System.out.println("Value of the item at index 2 " + list.valueAt(2));
        list.printList();
        System.out.println("Value of the item from back at index 2 " + list.getValueOfNthItemFromEnd(2));
        list.printList();
        list.eraseNode(1);
        list.printList();
    }
}

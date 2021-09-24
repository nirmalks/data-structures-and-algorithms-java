package com.nirmal.lru;

import java.util.Deque;
import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LruCache {
    int cacheSize;
    HashMap<Integer, Node> cache = new HashMap<>();
    Node head = null;
    Node tail = null;

    LruCache(int capacity) {
        this.cacheSize = capacity;
    }

    public void refer(int key) {

    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            return n.value;
        } else {
            return -1;
        }
    }

    /*This method will delete node*/
    public void delete(Node node){
        if (node.prev != null) {
           node.prev.next = node.next;
        } else {
            head = node.next;
        }


        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

    }

    /*This method will make passed node as head*/
    public void setHead(Node node){
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            n.value = value;
            delete(n);
            setHead(n);
        } else {
            Node newNode = new Node(key,value);
            if (cache.size() >= cacheSize ) {
                cache.remove(tail.key);
                delete(tail);
                setHead(newNode);
            } else {
                setHead(newNode);
            }
            cache.put(key,newNode);
        }
    }
    public static void main(String[] args) {
        LruCache lrucache = new LruCache(4);
        lrucache.set(1, 100);
        lrucache.set(10, 99);
        lrucache.set(15, 98);
        lrucache.set(10, 97);
        lrucache.set(12, 96);
        lrucache.set(18, 95);
        lrucache.set(1, 94);

        System.out.println(lrucache.get(1));
        System.out.println(lrucache.get(10));
        System.out.println(lrucache.get(15));
    }
}

package com.nirmal.HashTableExample;

/**
 * Created by nirmal on 13/1/18.
 * Hash table with linear probing
 */
public class HashTableDemo {
    public static int size = 100;
    public static HashTableEntry hashTable[] = new HashTableEntry[size];
    public static void main(String[] args){
        HashTableDemo hashDemo = new HashTableDemo();
        HashTableEntry hashTableEntry1 = new HashTableEntry(1,10);
        HashTableEntry hashTableEntry2 = new HashTableEntry(2,20);
        hashDemo.add(hashTableEntry1.getKey() , (int)hashTableEntry1.getValue());
        printTable();
        System.out.println(hashDemo.exists(1));
        System.out.println(hashDemo.exists(5));
        System.out.println(hashDemo.get(5));
        System.out.println(hashDemo.get(1));
        hashDemo.remove(1);
        printTable();
    }


    public static int hash(int key , int size) {
        return key % size;
    }

    public static void add(Object key , int value) {
        int index = hash((int)key,size);
        // this is linear probing
        //Search for an unused slot and if the index will exceed the hashTableSize then roll back
        // if key is same then update that is skip while
        while(hashTable[index ] != null && hashTable[index].getKey() != key ) {
            index  = (index  + 1) % size;
        }
        hashTable[index] = new HashTableEntry(key,value);
    }

    public static boolean exists(int key) {
        int index = hash(key,size);
        while(hashTable[index] != null && (int)hashTable[index].getKey() == key ) {
            return true;
        }
        return false;
    }

    public static Object get(int key) {
        int index = hash(key,size);
        //Search for an unused slot and if the index will exceed the hashTableSize then roll back
        while(hashTable[index] != null && (int)hashTable[index].getKey() != key) {
            index = (index + 1) % size;

        }
        if ((int)hashTable[index].getKey() == key) {
            return hashTable[index].getValue();
        } else {
            return -1;
        }
    }

    public static void remove(Object key) {
        if(exists((int)key)) {
            int hash = hash((int)key,size);
            hashTable[hash] = null;
        }
    }

    public static void printTable(){
        for (HashTableEntry obj: hashTable) {
            if(obj != null) {
                System.out.println("key " + obj.getKey() + " value " + obj.getValue());
            }
        }
    }
}
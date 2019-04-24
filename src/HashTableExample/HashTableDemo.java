package HashTableExample;
import HashTableExample.HashTableEntry;

/**
 * Created by nirmal on 13/1/18.
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
//        System.out.println(hashDemo.get(5));
//        System.out.println(hashDemo.get(1));
        hashDemo.remove(1);
        printTable();
    }


    public static int hash(int key , int size) {
        return key % size;
    }

    public static void add(Object key , int value) {
        int hash = hash((int)key,size);
        while(hashTable[hash] != null && hashTable[hash].getKey() != key ) {
            hash = (hash + 1 ) % 97;
        }
        hashTable[hash] = new HashTableEntry(key,value);
    }

    public static boolean exists(int key) {
        int hash = hash(key,size);
        while(hashTable[hash] != null && (int)hashTable[hash].getKey() == key ) {
            return true;
        }
        return false;
    }

    public static int get(int key) {
        int hash = hash((int)key,size);
        while(hashTable[hash] != null) {
            return (int)hashTable[hash].getValue();
        }
        return -1;
    }

    public static void remove(Object key) {
        if(exists((int)key)) {
            int hash = hash((int)key,size);
            hashTable[hash] = null;
        }
    }

    public static void printTable(){
        for (HashTableEntry obj:
             hashTable) {
            if(obj != null) {
                System.out.println("key " + obj.getKey() + " value " + obj.getValue());
            }
        }
    }
}
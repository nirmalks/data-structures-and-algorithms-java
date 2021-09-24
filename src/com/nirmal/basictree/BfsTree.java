package com.nirmal.basictree;


import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public  Node(int item) {
        this.data = item;
        this.left = this.right = null;
    }
}

public class BfsTree {
    Node root;

    BfsTree() {

    }

    void printBFSOrder() {
        Queue<Node> queue= new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll( );
            System.out.println(tempNode.data);

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

        }
    }

    public static void main(String[] args) {
        BfsTree binaryTree = new BfsTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.printBFSOrder();
    }

}

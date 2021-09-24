package com.nirmal.basictree;

import java.util.LinkedList;
import java.util.Queue;



public class DFSTree {
    Node root;

    void printInOrder(Node node) {
        if(node == null) {
            return;
        }

        if (node.left != null) {
            printInOrder(node.left);
        }

        System.out.println("node" + node.data);

        if (node.right != null) {
            printInOrder(node.right);
        }
    }

    void printPostOrder(Node node) {
        if(node == null) {
            return;
        }

        if (node.left != null) {
            printPostOrder(node.left);
        }

        if (node.right != null) {
            printPostOrder(node.right);
        }

        System.out.println("node" + node.data);
    }

    void printPreOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println("node" + node.data);

        if (node.left != null) {
            printPreOrder(node.left);
        }

        if (node.right != null) {
            printPreOrder(node.right);
        }

    }

    public static void main(String[] args) {
        DFSTree binaryTree = new DFSTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.printInOrder(binaryTree.root);
        binaryTree.printPostOrder(binaryTree.root);
        binaryTree.printPreOrder(binaryTree.root);
    }

}

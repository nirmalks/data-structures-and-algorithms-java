package com.nirmal.binarysearchtree;

class TreeNode {
    int data;
    TreeNode left,right;

    TreeNode(int item) {
        this.data = item;
        this.left = this.right = null;
    }
}

public class BinarySearchTree {
    TreeNode root;

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root.data +
                "left=" + root.left.data +
                "right=" + root.right.data +
                '}';
    }

    public boolean contains(int target) {
        TreeNode currentNode = this.root;
        while(currentNode != null) {
            if (target > currentNode.data) {
                currentNode = currentNode.right;
            } else if (target < currentNode.data) {
                currentNode = currentNode.left;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean containsRecursive(TreeNode root, int target) {
        TreeNode currentNode = this.root;

        if (currentNode == null || currentNode.data == target) {
            return true;
        }
        if (currentNode.data > target) {
            return containsRecursive(currentNode.right, target);
        }
        return containsRecursive(currentNode.left, target);
    }

    public TreeNode insert(TreeNode root, int target) {
        TreeNode currentNode = root;
        if (currentNode == null) {
            root = new TreeNode(target);
            return root;
        }

        if(target > currentNode.data) {
            currentNode.right = insert(root.right, target);
        } else if (target < currentNode.data) {
            currentNode.left = insert(root.left, target);
        }
        return currentNode;
    }

    public int minValue(TreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public TreeNode delete(TreeNode root, int target) {
        TreeNode currentNode = root;
        if(currentNode == null) {
            return root;
        }

        if(currentNode.data > target) {
            currentNode.left = delete(currentNode.left, target);
            return currentNode;
        } else if(currentNode.data < target) {
            currentNode.right = delete(currentNode.right, target);
            return currentNode;
        } else {
            if (currentNode.left == null) {
                return currentNode.right;
            } else if (currentNode.right == null) {
                return currentNode.left;
            } else {

                currentNode.data = minValue(currentNode.right);
                currentNode.right = delete(currentNode.right,currentNode.data);
//                TreeNode successorParent = currentNode.right;
//                TreeNode successor = currentNode.right;
//                while (successor.left != null) {
//                    successorParent = successor;
//                    successor = successor.left;
//                }
//
//                successorParent.left = successor.right;
//                currentNode.data = successor.data;
                return currentNode;
            }
        }
    }

    BinarySearchTree(int item) {
        this.root = new TreeNode(item);
    }

    public int maxValue(TreeNode root) {
        int maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }

    public int height(TreeNode root) {
        if(root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Integer.max(leftHeight,rightHeight) + 1;
    }

    public int getNodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getNodeCount(root.left);
        int rightHeight = getNodeCount(root.right);
        return leftHeight + rightHeight + 1;
    }

    public void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            System.out.println("data" + root.data);
            inOrder(root.right);
        }
    }

    public void preOrder(TreeNode root) {
        if(root != null) {

            System.out.println("data" + root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(TreeNode root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println("data" + root.data);
        }
    }

    public boolean isBST(TreeNode node) {
        return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTUtil(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if(node.data > min
                && node.data < max
                && isBSTUtil(node.left,min, node.data)
                && isBSTUtil(node.right,node.data,max)) {
            return true;
        }
        return false;
    }

    public TreeNode getSuccessor(TreeNode node, int data) {
        TreeNode currentNode = findNodeByData(node, data);
        if (currentNode == null) {
            return null;
        }
        if(currentNode.right != null) {
            return getMinValueNode(currentNode.right);
        } else {
            TreeNode successor = null;
            TreeNode ancestor = node;
            while (ancestor != currentNode) {
                if (currentNode.data < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }

    public TreeNode getMinValueNode(TreeNode node) {
        TreeNode minNode = node;
        if(node.left == null) {
            return minNode;
        }
        while (node.left != null) {
            minNode = node.left;
            node = node.left;
        }
        return minNode;
    }

    public TreeNode findNodeByData(TreeNode node, int data) {
        if(node == null) {
            return node;
        }
        if(node.data > data) {
            return findNodeByData(node.left,data);
        } else if(node.data < data){
            return findNodeByData(node.right,data);
        } else {
            return node;
        }
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.root.left = new TreeNode(8);
        bst.root.left.left = new TreeNode(5);
        bst.root.right = new TreeNode(15);
        bst.root.right.right = new TreeNode(20);
        System.out.println(bst.contains(150));

        bst.root = bst.insert(bst.root, 9);
        System.out.println("new node" + bst.root.left.right.data);
        bst.root = bst.delete(bst.root, 8);
        System.out.println("new node" + bst.root.left.data);
        System.out.println("max val" + bst.maxValue(bst.root));
        bst.inOrder(bst.root);
        System.out.println("height" + bst.height(bst.root));
        System.out.println("node count" + bst.getNodeCount(bst.root));
        System.out.println("is binary tree" + bst.isBST(bst.root));
        System.out.println("node by data" + bst.findNodeByData(bst.root,15).data);
        System.out.println("get successor" + bst.getSuccessor(bst.root,9).data);
    }
}

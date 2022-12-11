//============================================================================
// Name        : AVLTree.java
// Author      : Chase Outman
// Version     : 1.0
/* Description : AVL tree class that allows the user to create a AVL tree of Bid
                 items. The tree is a self balancing tree that checks the difference
                 in height between the left and right legs of the tree when adding a
                 new bid to the tree. If the height is out of balance by a factor of
                 2, the tree will self balance by rotating the nodes
                                    EXAMPLE

                 2                                      2
                / \                                    / \
               1   3            ----->                1   7
                    \                                    / \
                     7                                  3   8
                      \
                       8
 */
//============================================================================
package com.chase;

public class AVLTree {
    //node class for the AVL tree
    private class Node {
        private int height;
        private Bid value;
        private Node left;
        private Node right;

        public Node(Bid value) {
            this.value = value;
        }
    }
    //initialize root node
    private Node root;

    public void remove(String value) {
        removeNode(this.root, value);
    }

    private Node removeNode(Node root, String value) {
        //checks if the tree is current empty or if the end of subtree is reached
        if (root == null) {
            System.out.println("Bid " + value + " does not exist in tree");
            return root;
        }
        //if root bidID is greater than the searching bidID than traverse down the left side of the tree
        if (root.value.getBidId().compareTo(value) > 0) {
            root.left = removeNode(root.left, value);
        }
        //if root bidID is less than the searching bidID than traverse down the right side of the tree
        else if (root.value.getBidId().compareTo(value) < 0) {
            root.right = removeNode(root.right, value);
        }
        //else then the root bidID matches the searching bidID
        else {
            //if root has no child nodes than return null to delete the node
            if (root.left == null && root.right == null) {
                System.out.println("Bid " + value + " has been removed from tree");
                return null;
            }
            //if root has no left child nodes than set the root to the right child node
            else if (root.left == null) {
                System.out.println("Bid " + value + " has been removed from tree");
                return root.right;
            }
            //if root has no right child nodes than set the root to the left child node
            else if (root.right == null) {
                System.out.println("Bid " + value + " has been removed from tree");
                return root.left;
            }
            //if root has a left and right child node that set the root to the left child and the old right child node to the new root
            else {
                root = root.left;
                root.right = removeNode(root.right, root.left.value.getBidId());
                System.out.println("Bid " + value + " has been removed from tree");
            }
        }
        //sets height for the new root
        setHeight(root);
        //returns the new root after checking the balance of the tree
        return balance(root);
    }
    //search function for AVL tree
    public void search(String searchBid) {
        //initialize current node
        Node cur = root;

        while (cur != null) {
            //checks to see if the bid id value of the current node matches the searching bid id value
            if (cur.value.getBidId().equals(searchBid)) {
                //output that the bid was found and outputs the bid id, title, and bid amount of the searched item
                System.out.println("Bid was found");
                System.out.println(cur.value.getBidId() + " " + cur.value.getTitle() + " " + cur.value.getAmount());
                return;
            }
            //if current node bid id value is greater than the searching bid id the traverse down the left child node
            if (cur.value.getBidId().compareTo(searchBid) > 0) {
                cur = cur.left;
            }
            //else traverse down the right child node
            else {
                cur = cur.right;
            }
        }
        //if no matching bid id was found outputs that the bid was not found
        System.out.println("Bid was not found!");
    }

    //in order traversal that uses recursion to output data in 'in order' order
    private void inOrder(Node root) {
        if (root == null)
            return;
        //traverses down the left side first
        inOrder(root.left);
        //outputs the data of the node
        System.out.println(root.value.getBidId() + " " + root.value.getTitle() + " " + root.value.getAmount());
        //traverse down the right side
        inOrder(root.right);
    }

    //start of the recursive call to the inOrder function
    public void print() {
        inOrder(root);
    }


    public void insert(Bid value) {
        root = insert(root, value);
    }
    //insert function for AVL tree
    private Node insert(Node root, Bid value) {
        //if tree is empty it sets the current value to the root
        if (root == null)
            return new Node(value);
        //if the inserted bid id is less than the root bid id value than insert to the left child
        if (value.getBidId().compareTo(root.value.getBidId()) < 0)
            root.left = insert(root.left, value);
        //else insert to the right child
        else
            root.right = insert(root.right, value);
        //tracks current height of the tree
        setHeight(root);
        //then checks to see if the tree is out of balanced
        return balance(root);
    }
    //function to check if tree is balanced
    private Node balance(Node root) {
        //checks if left side of tree is heavy compared to the right
        if (isLeftHeavy(root)) {
            //if true than check the balance of the left side
            if (balanceFactor(root.left) < 0)
                //if less than zero rotate the left side of the tree
                root.left = rotateLeft(root.left);
            //else rotate the right side of the tree
            return rotateRight(root);
        }
        //checks if right side of tree is heavy compared to the left
        else if (isRightHeavy(root)) {
            //if tree than check the balance of the right side
            if (balanceFactor(root.right) > 0)
                //if greater than zero then rotate the right side of the tree
                root.right = rotateRight(root.right);
            //else rotate the left side of the tree
            return rotateLeft(root);
        }
        return root;
    }
    //rotates the left side of the tree by making the right child node of the new root
    //and moving the old root to the left child node of the new root
    private Node rotateLeft(Node root) {
        Node newRoot = root.right;

        root.right = newRoot.left;
        newRoot.left = root;
        //recalculates the height of the new root and old root
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    //rotates the right side of the tree by making the left child node of the new root
    //and moving the old root to the right child node of the new root
    private Node rotateRight(Node root) {
        Node newRoot = root.left;

        root.left = newRoot.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }
    //sets the height of the tree
    private void setHeight(Node node) {
        //finds the largest height between the left side or right side of the tree
        node.height = Math.max(
                height(node.left),
                height(node.right)) + 1;
    }
    //determines if the left side of the tree is heavy
    private boolean isLeftHeavy(Node node) {
        //returns false if tree is out of balance by a factor of 2 height
        return balanceFactor(node) > 1;
    }

    //determines if the right side of the tree is heavy
    private boolean isRightHeavy(Node node) {
        //returns false if tree is out of balance by a factor of 2 height
        return balanceFactor(node) < -1;
    }

    //calculate the balance of the tree
    private int balanceFactor(Node node) {
        //if node equals null set balance value to 0, else calculate the value of the left height of tree
        //  subtract value of the right height of the tree
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }
    //height function that tracks height of tree
    private int height(Node node) {
        //if node equals null than set height to -1 else return the height of the node
        return (node == null) ? -1 : node.height;
    }


}
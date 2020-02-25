package Trees;

import java.util.Stack;
import java.util.stream.StreamSupport;

// Creating a binary tree and different types of traversal
public class BinaryTree {
    Node root;
    // Create a Binary tree
    public BinaryTree(){
        root = null;
    }

    public BinaryTree(int key){
        root = new Node(key);
    }

    // preOrder traversal (DLR)
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.key);
        preOrder(root.left);
        preOrder(root.right);
    }

    // Iterative impl of PreOrder Traversal
    public void preOrderIterative(Node root){
        if(root == null){
            return;
        }

        Stack<Node> myStack = new Stack<>();
        myStack.push(root);

        while(!myStack.empty()){
            Node currNode = myStack.peek();
            System.out.println(currNode.key);
            myStack.pop();

            if(currNode.right != null){
                myStack.push(currNode.right);
            }

            if(currNode.left != null){
                myStack.push(currNode.left);
            }
        }
    }

    // inorder traversal (LDR)
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        preOrder(root.left);
        System.out.println(root.key);
        preOrder(root.right);
    }

    // Iterative impl of InOrder Traversal
    // Solution: 1. push root, 2. set curr = curr.next until curr becomes null, 3. then pop from the stack
    // 4. set curr = curr.right
    // Each time you pop a node, make sure to set the curr node to curr. right and then if it is not null, push
    // that node and set curr = curr.left and if that node is null, then pop the node and repeat
    public void inOrderIterative(Node root){
        if(root == null){
            return;
        }

        Stack<Node> nodeStack = new Stack<>();
        Node curr = root;

        while(!nodeStack.empty() || curr != null){
           while(curr != null){
               nodeStack.push(curr);
               curr = curr.left;
           }

           curr = nodeStack.pop();
           System.out.println(curr.key);
           curr = curr.right;
        }
    }

    // postOrder traversal (LRD)
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.key);
    }

    public void postOrderIterativeUsingTwoStacks(Node root){
        if(root == null){
            return;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);

        while(!s1.empty()){
            Node curr = s1.peek();
            s2.push(curr);
            s1.pop();

            if(curr.left != null){
                s1.push(curr.left);
            }

            if(curr.right != null){
                s1.push(curr.right);
            }
        }

        while(!s2.empty()){
            System.out.println(s2.pop().key);
        }
    }

    public void postOrderIterative(Node root){
        if(root == null){
            return;
        }

        Stack<Node> s1 = new Stack<>();
        while(true){
            while(root != null){
                s1.push(root);
                s1.push(root);
                root = root.left;
            }
            if(s1.empty()) return;
            root = s1.pop();
            if(!s1.empty() && s1.peek() == root){
                root = root.right;
            } else {
                System.out.println(root.key);
                root = null;
            }
        }
    }

    public static void main(String[] args) {
        // This will create root
        BinaryTree bTree = new BinaryTree(1);

        // To add nodes to the left
        bTree.root.left = new Node(3);

        // To add node to the right
        bTree.root.right = new Node(5);

        // To add left and right nodes for left node
        bTree.root.left.left = new Node(7);
        bTree.root.left.right = new Node(9);

        // To add left and right nodes for right node
        bTree.root.right.left = new Node(11);
        bTree.root.right.right = new Node(13);

//        System.out.println("PreOrder Traversal");
//        bTree.preOrder(bTree.root);
//
        System.out.println("InOrder Traversal");
        bTree.inOrder(bTree.root);
//
//        System.out.println("postOrder Traversal");
//        bTree.postOrder(bTree.root);

//        System.out.println("PreOrder Iterative Traversal");
//        bTree.preOrderIterative(bTree.root);
//
//        System.out.println("InOrder Iterative Traversal");
//        bTree.inOrderIterative(bTree.root);

//        System.out.println("PostOrder Iterative Traversal Using Two Stacks");
//        bTree.postOrderIterativeUsingTwoStacks(bTree.root);
//
//        System.out.println("PostOrder Iterative Traversal 1 Stack");
//        bTree.postOrderIterative(bTree.root);
    }
}

class Node{
    int key;
    Node left, right;

    public Node(int key){
        this.key = key;
        this.left = this.right = null;
    }
}

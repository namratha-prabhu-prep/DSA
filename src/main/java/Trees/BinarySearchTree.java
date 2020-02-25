package Trees;

public class BinarySearchTree extends BinaryTree {
    class BSTNode{
        int data;
        BSTNode left, right;

        public BSTNode(int data){
            this.data = this.data;
            this.left = this.right = null;
        }
    }

    // Find element recursive approach
    public Node findElementRecursiveApproach(Node root, int data){
        if(root == null){
            return null;
        }
        if(data < root.key){
            return findElementRecursiveApproach(root.left, data);
        } else if(data > root.key){
            return findElementRecursiveApproach(root.right, data);
        }
        return root;
    }

    // Find element by non recursive approach
    public Node findElementNonRecursiveApproach(Node root, int data){
        if(root == null){
            return null;
        }
        if(data == root.key){
            return root;
        } else if(data < root.key){
            root = root.left;
        } else if(data > root.key) {
            root = root.right;
        }
        return root;
    }

    public Node findMinElement(Node root){
//        if(root == null){
//            return null;
//        }
//        while(root.left != null){
//            root = root.left;
//        }
//        return root;

        // Recursive approach
        if(root == null){
            return null;
        }
        if(root.left == null) {
            return root;
        } else {
            return findMinElement(root.left);
        }
    }

    public Node findMaxElement(Node root){
//        TC: O(n)  SC: O(1)
//        if(root == null){
//            return null;
//        }
//        while(root.right != null){
//            root = root.right;
//        }
//        return root;

        // Recursive approach
        // TC: O(n)  SC: O(n)
        if(root == null){
            return null;
        }
        if(root.right != null){
            return findMaxElement(root.right);
        }
        return root;
    }

    // TC: O(n)  SC: O(1)
    public Node insertIterative(Node root, int data){
        if(root == null) {
            root = new Node(data);
            return root;
        }
        Node current = root;
        while(current != null){
            if(current.key == data){
                return root;
            }
            if(data > current.key){
                current = current.right;
                if(current.right == null && current.key != data){
                    current.right = new Node(data);
                    return root;
                }
            } else if(data < current.key) {
                current = current.left;
                if(current.left == null  && current.key != data){
                    current.left = new Node(data);
                    return root;
                }
            }
        }
        return root;
    }

    // TC: O(n)  SC: O(n)
    public Node insertRecursive(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data > root.key){
            if(root.right == null){
                root.right = new Node(data);
            }
            insertRecursive(root.right, data);
        } else if(data < root.key){
            if(root.left == null){
                root.left = new Node(data);
            }
            insertRecursive(root.left, data);
        }
        return root;
    }

    public Node deleteIterative(Node root, int data){
        if(root == null){
            return null;
        }
        while(root != null){
            if(data < root.key){
                if(root.left != null){
                    if(root.left.key == data){
                        Node del = root.left;
                        root.left = null;
                        return del;
                    }
                    root = root.left;
                }
            } else if(data > root.key){
                if(root.right != null){
                    if(root.right.key == data){
                        Node del = root.right;
                        if(root.right.left != null && root.right.right != null){

                        }
//                        else if(root.left.left != null){
//                            root.left = root.left.left;
//                        } else if(root.left.right != null){
//                            root.left = root.left.right;
//                        }
                        else if(root.right.right != null){
                            root.right = root.right.right;
                        }
//                        else if(root.right.left != null){
//                            root.right = root.right.left;
//                        }
                        return del;
                    }
                    root = root.right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BinaryTree bTree = new BinaryTree(6);
        // To add nodes to the left
        bTree.root.left = new Node(2);

        // To add node to the right
        bTree.root.right = new Node(8);

        // To add left and right nodes for left node
        // bTree.root.left.left = new Node(1);
        bTree.root.left.right = new Node(4);
        bTree.root.left.right.left = new Node(3);
        bTree.root.left.right.right = new Node(5);

        // To add left and right nodes for right node
        bTree.root.right.left = new Node(7);
        bTree.root.right.right = new Node(9);

//        System.out.println("Insert ==> Recursive approach");
//        bst.insertRecursive(bTree.root, 10);
//        bst.insertRecursive(bTree.root, 1);
//        bTree.inOrderIterative(bTree.root);

        System.out.println("Insert ==> Iterative approach");
        bst.insertIterative(bTree.root, 10);
        bst.insertIterative(bTree.root, 1);
        bTree.inOrderIterative(bTree.root);

        System.out.println("delete ==> Iterative approach");
        bst.deleteIterative(bTree.root, 9);
        bst.deleteIterative(bTree.root, 7);
        bTree.inOrderIterative(bTree.root);

        // Find element by recursive approach
//        Node val = bst.findElementRecursiveApproach(bTree.root, 0);
//        System.out.println("Find element by recursive approach");
//
//        if(val != null){
//            System.out.println(val.key);
//        } else {
//            System.out.println("The element could not be found");
//        }
//
//        // Find element by non recursive approach
//        Node val1 = bst.findElementRecursiveApproach(bTree.root, 0);
//        System.out.println("Find element by non recursive approach");
//
//        if(val1 != null){
//            System.out.println(val1.key);
//        } else {
//            System.out.println("The element could not be found");
//        }
//
//        // Find element by non recursive approach
//        Node val3 = bst.findMinElement(bTree.root);
//        System.out.println("Find minimum element");
//        if(val3 != null){
//            System.out.println(val3.key);
//        } else {
//            System.out.println("The element could not be found");
//        }
//
//        // Find element by non recursive approach
//        Node val4 = bst.findMaxElement(bTree.root);
//        System.out.println("Find maximum element");
//        if(val4 != null){
//            System.out.println(val4.key);
//        } else {
//            System.out.println("The element could not be found");
        }
    }

package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
226. Invert Binary Tree

Input:
     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:
     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/
public class InvertBTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTreeRecursive(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTreeRecursive(root.left);
        TreeNode right = invertTreeRecursive(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            // swapping left and right nodes
            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;

            if(currentNode.left != null) queue.add(currentNode.left);
            if(currentNode.right != null) queue.add(currentNode.right);
        }
        return root;
    }

    /*
    It is the same for both recursive and iterative approach
    TC: O(n), since we go through each node once
    SC: O(n), since in the worst case, the queue/stack will contain all nodes in one level of the binary tree
     */
}

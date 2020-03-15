package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.

Example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.
*/

public class MaxDepth {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // solution using DFS
    public int maxDepthDFS(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack();
        Stack<Integer> depths = new Stack();
        int maxDepth = 0;

        stack.add(root);
        depths.add(1);

        while(!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            int tempDepth = depths.pop();
            maxDepth = Math.max(maxDepth, tempDepth);
            if(currNode.right != null) {
                stack.add(currNode.right);
                // we add 1 to tempDepth because, for that corresponding node
                // we have to pull the depth added at that point. whereas maxDepth is like the total depth so far
                depths.add(tempDepth + 1);
            }
            if(currNode.left != null)  {
                stack.add(currNode.left);
                depths.add(tempDepth + 1);
            }
        }
        return maxDepth;
    }

    // Solution using BFS
    public int maxDepthBFS(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        // traverses each level.
        // At a time queue will only have nodes of the same level
        // So s-- loops until we traverse a level's nodes and add it to the queue.
        // So once we complete traversing a level's nodes, we increment the depth
        while(!q.isEmpty()) {
            int s = q.size();
            while(s-- > 0) {
                TreeNode currNode = q.poll();
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
            depth++;
        }
        return depth;
    }

    // Recursive solution
    public int maxDepthRecursive(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepthRecursive(root.left);
        int rightDepth = maxDepthRecursive(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }
}

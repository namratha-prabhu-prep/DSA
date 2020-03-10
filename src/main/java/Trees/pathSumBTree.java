package Trees;

import java.util.Stack;

/*
112. Path Sum
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class pathSumBTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSumRecursive(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right == null) return (sum==0);
        return hasPathSumRecursive(root.left, sum) || hasPathSumRecursive(root.right, sum);
    }

    public boolean hasPathSumIterative(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<TreeNode> node_stack = new Stack<>();
        Stack<Integer> sum_stack = new Stack();
        node_stack.add(root);
        sum_stack.add(sum-root.val);

        TreeNode node;
        int remaining_sum;
        while(!node_stack.isEmpty()) {
            node = node_stack.pop();
            remaining_sum = sum_stack.pop();
            if(node.left == null && node.right == null && remaining_sum == 0) return true;
            if(node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(remaining_sum-node.left.val);
            }
            if(node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(remaining_sum-node.right.val);
            }
        }
        return false;
    }

    /*
    It is the same for both recursive and iterative approach
    TC: O(n), since we go through each node once
    SC: 1. when the Btree is not balanced, it is O(n) (because it might be a skew tree)
        2. if the Btree is a balanced Btree, then it is O(logn)
     */
}

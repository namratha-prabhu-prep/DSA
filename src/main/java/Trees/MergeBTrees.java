package Trees;

import java.util.Stack;

// 617. Merge Two Binary Trees https://leetcode.com/problems/merge-two-binary-trees/
public class MergeBTrees {
    public static class TreeNode {
        int val;
        MergeBTrees.TreeNode left;
        MergeBTrees.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTreesIterative(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        Stack<TreeNode[]> stack = new Stack();
        stack.push(new TreeNode[]{t1,t2});
        while(!stack.isEmpty()){
            TreeNode[] t = stack.pop();
            if(t[0] == null || t[1] == null) continue;
            t[0].val += t[1].val;
            /* We only check for t[0].left == null because, we are
             manipulating t1 tree and
             1. if t[1].left == null, t2 tree is neglected and not needed.
             2. If t[1].left != null, then we need the value of t[1].left to              be copied to t1 tree.
            */
            if(t[0].left == null) t[0].left = t[1].left;
            else stack.push(new TreeNode[]{t[0].left, t[1].left});
            if(t[0].right == null) t[0].right = t[1].right;
            else stack.push(new TreeNode[]{t[0].right, t[1].right});
        }
        return t1;
    }

    public TreeNode mergeTreesRecursive(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTreesRecursive(t1.left, t2.left);
        t1.right = mergeTreesRecursive(t1.right, t2.right);
        return t1;
    }
}

package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class isSymmetricBTrees {
    public static class TreeNode {
        int val;
        isSymmetricBTrees.TreeNode left;
        isSymmetricBTrees.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Recursive Approach
    public boolean isSymmetricRecursive(TreeNode root) {
        // Send root as the left and right root becasue null check is done in the recursive function
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode lr, TreeNode rr){
        if(lr == null && rr == null) return true;
        if(lr == null || rr == null) return false;

        return (lr.val == rr.val) && isMirror(lr.left, rr.right) && isMirror(lr.right, rr.left);
    }

    // Iterative Approach
    public boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode lRoot = queue.poll();
            TreeNode rRoot = queue.poll();
            if(lRoot == null && rRoot == null) continue;
            if(lRoot == null || rRoot == null) return false;
            if(lRoot.val != rRoot.val) return false;
            queue.add(lRoot.left);
            queue.add(rRoot.right);
            queue.add(lRoot.right);
            queue.add(rRoot.left);
        }
        return true;
    }
}

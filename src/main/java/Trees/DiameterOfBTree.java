package Trees;

// 543. Diameter of Binary Tree https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBTree {
    int ans;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }

    public int height(TreeNode root) {
        if(root == null) return 0;
        // Finding diameter of a BT https://www.youtube.com/watch?v=ey7DYc9OANo
        // Finding height of a BT https://www.youtube.com/watch?v=_O-mK2g_jhI
        // Calculate the height of the left subtree and right subtree and consider the max(lHeight,rHeight)+1,
        // this would give the height of a node. We add +1 because, we get the number or edges and to get the number of nodes
        // we have to add 1.
        //
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        // This will compare the heights of the leftsubtree, rightsubtree and the node. Which ever is maximum is returned. because
        // diameter doesn't actually have to go through the node. If the diameter of the left subtree is greater than the full tree's
        // diameter, then the left subtree's diameter is returned.
        ans = Math.max(ans, lHeight+rHeight);
        // This return value returns the height of a particular node in context
        return Math.max(lHeight,rHeight)+1;
    }

    public static void main(String[] args) {
        DiameterOfBTree diameterOfBTree = new DiameterOfBTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBTree.diameterOfBinaryTree(root));
    }
}

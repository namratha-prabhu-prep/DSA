package Trees;

import java.util.HashMap;
import java.util.Map;

/*
437. Path Sum III
You are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

 */
public class PathSumBTreeMediumQues {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int pathSum(TreeNode root, int sum) {
        // Using a map to save the currSum(sum of the values of all nodes traversed until now) and the frequency
        Map<Integer, Integer> map = new HashMap<>();
        // we add this because if (currSum-sum) == 0, then we have to increment the count. Look at the code on line 30
        map.put(0,1);
        return helper(root, 0, sum, map);
    }

    public int helper(TreeNode root, int currSum, int sum, Map<Integer, Integer> map) {
        if(root == null) return 0;
        // currSum(sum of the values of all nodes traversed until now)
        currSum += root.val;
        // count is the value to be returned, we do currSum-sum because totalsum - targetSum should return a node value
        // already traversed if there are node values which sum up to targetSum.
        // Eg: root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
        // in this example, by the time we reach node 3 on level 2, map would have ([10:1],[15:1])
        // currSum = 15+3 = 18, currSum-sum = 18-8 = 10
        // then, count = map.getOrDefault(10, 0); There fore count = 1; This is because 5 + 3 = 8 and
        // node value 10 was the extra value added to the currSum
        int count = map.getOrDefault(currSum-sum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0)+1);
        /*
        Each recursion returns the total count of valid paths in the subtree rooted at the current node. And this sum can be divided into three parts:
        - the total number of valid paths in the subtree rooted at the current node's left child
        - the total number of valid paths in the subtree rooted at the current node's right child
        - the number of valid paths ended by the current node
        */
        count += helper(root.left, currSum, sum, map) + helper(root.right, currSum, sum, map);
        // restore the map, as the recursion goes from the bottom to the top
        map.put(currSum, map.get(currSum)-1);
        return count;
    }
}

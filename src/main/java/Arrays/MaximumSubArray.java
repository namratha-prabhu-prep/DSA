package Arrays;

public class MaximumSubArray {
    /*
    Approach 1: Divide and Conquer
    TC: O(nlogn)
    1. Dividing the array takes O(logn) time (similar to merge sort implementation)
    2. Looping to calculate the maxSum will take O(n).
    So in total it is O(nlogn)
    SC: O(logn), because of the recursive call stack
     */
    public int maxSubArrayDivideAndConquer(int[] nums) {
        return helper(0, nums.length-1, nums);
    }

    public int helper(int left, int right, int[] nums) {
        if(left == right) return nums[left];
        int mid = (left+right) / 2;

        int leftSum = helper(left, mid, nums);
        int rightSum = helper(mid+1, right, nums);
        int mergeSum = merge(left, right, nums, mid);

        return Math.max(Math.max(leftSum, rightSum), mergeSum);
    }

    public int merge(int left, int right, int[] nums, int mid) {
        int currSum = 0;
        int leftArrSum = Integer.MIN_VALUE;

        for(int i = mid; i >= left; i--) {
            currSum += nums[i];
            leftArrSum = Math.max(leftArrSum, currSum);
        }

        currSum = 0;
        int rightArrSum = Integer.MIN_VALUE;

        for(int i = mid+1; i <= right; i++) {
            currSum += nums[i];
            rightArrSum = Math.max(rightArrSum, currSum);
        }

        return leftArrSum + rightArrSum;
    }

    /*
    Approach 2: Using Greedy approach
    Use maxSum for keeping track of the maxSum so far and currSum for calculating the currSum

    TC: O(n)
    SC: O(1)
     */
    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }

    /*
    Approach 3: Using Greedy approach and also keeping track of the start and end index of the max sub array
    If we have to return the starting and ending indices of the maximum sub array
    This implementation also uses Greedy approach
    TC: O(n)
    SC: O(1)
    */
    public int maxSubArrayWithIndices(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        int start = 0, end  = 0, s = 0;

        for(int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if(maxSum < currSum) {
                maxSum = currSum;
                start = s;
                end = i;
            } else if(currSum < nums[i]) {
                currSum = 0;
                s = i+1;
            }
        }
        System.out.println(start + ", " + end);
        return maxSum;
    }

    /*
    Approach 4: Using Dynamic programming approach
    COMING SOON
     */

    public static void main(String[] args) {
        System.out.println
                (new MaximumSubArray(). maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println
                (new MaximumSubArray(). maxSubArrayWithIndices(new int[]{-2,-3, 4,-1,-2,1,5,-3}));
    }
}

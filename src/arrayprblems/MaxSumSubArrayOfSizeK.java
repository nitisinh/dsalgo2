package arrayprblems;

/**
 * Given an array of positive numbers and a positive number ‘k,’
 * find the maximum sum of any contiguous subarray of size ‘k’.
 * Example 1:
    * Input: [2, 1, 5, 1, 3, 2], k=3
    * Output: 9
    * Explanation: Subarray with maximum sum is [5, 1, 3]
     * Example 2:
     * Input: [2, 3, 4, 1, 5], k=2
     * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */

public class MaxSumSubArrayOfSizeK {

    /**
     * Solution : Sliding window - Time Complexity - O(n) , Space : O(1)
     * Basically , we will fix the window size to k , take sum of it and update it to max_sum
     * Add one right hand side element  and remove left hand side element and update the cur_sum.
     * so we will take cur_sum of each window of size 'k' and check if the sum is greater than max_sum.
     * If yes , then update the max_sum otherwise , just continue to next window.
     * @param nums
     * @param k
     * @return
     */
    public static int findMamSubArrayOfSizeK(int[] nums, int k){
        if(nums==null) return Integer.MIN_VALUE;
        if(nums.length<k || k<=0) return Integer.MIN_VALUE;
        int max_sum = Integer.MIN_VALUE, curSum = 0;
        //get the sum of fist window of size k
        for(int i =0;i<k;i++){
            curSum += nums[i];
        }
        max_sum = Math.max(curSum,max_sum);
        // Slide the window and compare maximum sum with every window of size k and update accordingly.
        for(int i = k ; i <nums.length ; i++){
            curSum = curSum + nums[i];
            curSum = curSum - nums[i-k];
            max_sum = Math.max(curSum,max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{2, 1, 5, 1, 3, 2};
        System.out.println(MaxSumSubArrayOfSizeK.findMamSubArrayOfSizeK(test1,3));

        int[] test2 = new int[]{2, 3, 4, 1, 5};
        System.out.println(MaxSumSubArrayOfSizeK.findMamSubArrayOfSizeK(test2,2));
    }
}

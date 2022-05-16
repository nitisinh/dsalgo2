package arrayprblems;

/**
 * Given an array of positive numbers and a positive number ‘S,’
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 *
 * Example1 :
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to
 * '7' is [5, 2].
 *
 * Example2 :
 *
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to
 * '7' is [8].
 * Example 3:
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8'
 *  are [3, 4, 1] or [1, 1, 6].
 */

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        if(S< 0 || arr==null) return -1;
        int curSum =0, minLen = Integer.MAX_VALUE, startId = 0, endId =0;
        //This outer loop will make sure of a window whose sum >= target
        while(endId <arr.length){
            curSum += arr[endId++];
            //once we have a window whose sum>=target, let shrink the window from left and see
            //do we have any smaller window whose sum >= target
            //This inner loop will take care of that.
            while(curSum>=S && startId<endId){
                //maintain a minimum length of the window whose sum>=target
                minLen = Math.min(minLen,(endId - startId));
                //update the current sum
                curSum = curSum - arr[startId];
                //shrink the window from left
                startId++;
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{2, 1, 5, 2, 3, 2};
        int s1 = 7;
        int[] test2 = new int[]{2, 1, 5, 2, 8};
        int s2 = 7;
        int[] test3 = new int[]{3, 4, 1, 1, 6};
        int s3 = 8;
        System.out.println(MinSizeSubArraySum.findMinSubArray(s1,test1));
        System.out.println(MinSizeSubArraySum.findMinSubArray(s2,test2));
        System.out.println(MinSizeSubArraySum.findMinSubArray(s3,test3));
    }
}
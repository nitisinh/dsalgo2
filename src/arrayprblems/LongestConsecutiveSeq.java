package arrayprblems;
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
    /**
     * This function will return the size of the longest consecutive sequence.
     * @param nums
     * @return
     */
    public static int findLongestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        //This set will make sure unique elements are there and being counted...
        Set<Integer> numSet = new HashSet<Integer>();
        //Add all the elements in the set.
        for(int num : nums){
            numSet.add(num);
        }
        //update the size of longest consecutive sequence.
        int longestConsecutiveSeqSize = 1;
        for(int num : numSet){
            //handle if this element was already handled.
            //Below if condition makes sure that the current number was not considered during any consecutive sequence
            if(!numSet.contains(num-1)){
                //start counting
                int maxStreak = 1;
                //start checking the consecutive elements.
                int nextNum = num;
                while(numSet.contains(++nextNum)){
                    //increase the consecutive sequence size.
                    maxStreak++;
                    longestConsecutiveSeqSize = Math.max(longestConsecutiveSeqSize,maxStreak);
                }
            }
        }
        return longestConsecutiveSeqSize;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(Arrays.toString(nums) + " : " + findLongestConsecutive(nums));
        int[]  nums1 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(Arrays.toString(nums1) + " : " + findLongestConsecutive(nums1));
    }
}

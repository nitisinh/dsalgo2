package arrayprblems.twopointer;
/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
 *
 * Constraints:
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        //sort the array
        Arrays.sort(nums);
        //Iterate and solve 2 sum (sorted) for each element
        for(int i = 0 ; i < nums.length ; i++){
            //very important to handle the duplicate value of i .
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = nums.length -1;
            while(j<k){
                if(nums[i] + nums[j] + nums[k] == 0 ){
                    //if the sum is 0 , add to result
                    //increment j and decrement k
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j++],nums[k--])));
                    //handle the duplicate value of j
                    while(j<k && nums[j] == nums[j-1]) ++j;
                }
                //if total sum is less than 0 then move the left pointer.
                if(nums[i] + nums[j] + nums[k] < 0 ){
                    j++;
                }
                //if total sum is more than 0 then move the right pointer.
                if(nums[i] + nums[j] + nums[k] > 0 ){
                    k--;
                }

            }
        }
        return result;
    }
}

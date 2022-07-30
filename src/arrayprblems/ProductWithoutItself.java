package arrayprblems;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]

 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

public class ProductWithoutItself {
    /**
     * Logic : For each element , find left product and right product and multiply them in result array
     * Space complexity for this solution is O(1) if output array does not count as extra space for space complexity analysis.
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        //create an array to hold the result.
        int[] res = new int[nums.length];
        //find the left product for each element and update the result array with the value.
        int left = 1;
        for(int i =0; i< nums.length; i++){
            if(i!=0){
                left = left * nums[i-1];
            }
            res[i] = left;
        }
        //find the  right product for each element and update the result array with the value.
        int right = 1;
        for(int i = nums.length -1; i >=0 ; i--){
            if(i!=nums.length-1) right = right * nums[i+1];
            res[i] *= right;
        }
        return res;
    }
    public static void main(String[] args) {

    }
}

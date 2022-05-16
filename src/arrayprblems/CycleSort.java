package arrayprblems;

public class CycleSort {
    /**
     * Cycle sort algorithm
     * @param nums
     * @return
     */
    public static int[] cSort(int[] nums){
        int i = 0 ;
        while(i< nums.length){
            int j = nums[i] - 1; // we subtracted 1 to make the numbers in range of 0 to length -1;
            if(nums[i] <= nums[nums.length] && nums[i] != nums[j]){
                swap(nums,i,j);
            }else i++;
        }
        return nums;
    }

    /**
     * Swap 2 elements of the array
     * @param nums
     * @param firstId
     * @param secondId
     * @return
     */
    private static int[] swap(int[] nums, int firstId, int secondId){
        int temp = nums[firstId];
        nums[firstId] = nums[secondId];
        nums[secondId] = temp;
        return nums;
    }
}

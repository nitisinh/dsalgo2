package arrayprblems.twopointer;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * sample photo - https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 */
public class MostWaterContainer {
    public int maxArea(int[] height) {
        //we must need at least 2 pillars to contain the water.
        if(height.length < 2 ) return 0;
        int low = 0 ,high = height.length -1,maxWater = 0, currWater = 0;
        while(low<high){
            //Area containing water will be calculated as width * height where
            //Width = high - low.
            //height to be considered = Minimum height between the two pillars
            currWater = (high - low) * Math.min(height[low],height[high]);
            maxWater = Math.max(currWater, maxWater);
            //Maximise the size of the container.
            //Between the two pillars , one which is smaller should be changed
            if(height[low] <= height[high]){
                low++;
            }else{
                high--;
            }
        }
        return maxWater;
    }
}

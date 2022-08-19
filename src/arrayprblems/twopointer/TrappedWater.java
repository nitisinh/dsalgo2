package arrayprblems.twopointer;

public class TrappedWater {
    public int findTrappedWater(int[] height) {
        int result = 0, leftMaxElevation = 0 , rightMaxElevation = 0;
        //for every bar height , find out the maximum elevation on left and right side
        for(int i = 0 ; i < height.length; i++){
            leftMaxElevation = 0;
            rightMaxElevation = 0;
            //find maximum left elevation
            for(int left = 0; left < i ; left++){
                leftMaxElevation = Math.max(leftMaxElevation,height[left]);
            }
            //find maximum right elevation
            for(int right = i+1; right < height.length ; right++){
                rightMaxElevation = Math.max(rightMaxElevation,height[right]);
            }
            //Find out the shorter elevation from amongst the right and left elevation
            int minElevation = Math.min(leftMaxElevation,rightMaxElevation);
            //Find the pit depth.
            int currentWaterTrapped = minElevation > height[i] ? minElevation - height[i] : 0;
            //Add all the put depths.
            result+=currentWaterTrapped;
        }
    return result;
    }
    public int findTrappedWaterTwoPointer(int[] height) {
                //use 2 pointers left and right
                //use leftMaxElevation and rightMaxElevation to record the pit depth on top of every bar.
                int left = 0 , right = height.length - 1;
                int result = 0, leftMaxElevation = 0, rightMaxElevation = 0;
                while(left < right){
                    //Note that, we need to find the smaller bar between left bar and right bar.
                    //If one side bar is taller, we need to care about the opposite side elevation
                    //if bar pointed by left pointer is smaller
                    //process leftMaxElevation because
                    //we have already found that there is a taller bar on right
                    if(height[left] < height[right]){
                        //if there is no elevation on the left side.
                        if(height[left] >= leftMaxElevation){
                            leftMaxElevation = height[left];
                        }else{
                            //We have found a pit and its depth will be
                            //equal to difference between left elevation and height of bar
                            result += leftMaxElevation - height[left];
                        }
                        left++;
                    }else{
                        //Here, right side bar is smaller.So we have confirmed elevation on left
                        //Find if there is elevation on right side of the bar or not.
                        if(height[right] >= rightMaxElevation){
                            //No elevation found on right side, just update the elevation
                            rightMaxElevation = height[right];
                        }else{
                            //we have found elevation on the right side as well
                            //find the depth of the pit.
                            result += rightMaxElevation - height[right];
                        }
                        right--;
                    }
                }
                return result;


    }
}


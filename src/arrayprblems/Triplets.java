package arrayprblems;

/**
 * Given an array containing N integers and a number S,denoting a target sum.
 * Find all distinct integers that can add up to form target sum.
 * The numbers in each triplet should be ordered in ascending order, and triplets should be ordered(ascending) too based on first element in the triplet.
 * Return empty array if no such triplet exists.
 * Ex -
 * array = [1,2,3,4,5,6,7,8,9,15]
 * target - 18
 * output -
 * [[1,2,15],
 * [3,7,8],
 * [4,6,8],
 * [5,6,7]]
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Triplets {

    public List<List<Integer>> findTriplet(int[] arr, int target){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(arr == null) return ans;
        if(arr.length < 3) return ans;
        Arrays.sort(arr);
        int i = 0;
        while(i<arr.length-2){
            int j = i +1, k = arr.length - 1;
            int firstNum = arr[i];
            while(j<k){
                int secondNum = arr[j], thirdNum = arr[k];
                //if triplet found create a list for triplet and add triplet to the answer.
                if(arr[i] + secondNum + thirdNum == target){
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(arr[i]);
                    triplet.add(secondNum);
                    triplet.add(thirdNum);
                    ans.add(triplet);
                    //handle the situation where duplicate numbers are there to the right of second number
                    while(j<k && arr[j] == secondNum) j++;
                    //handle the situation where duplicate numbers are there to the left of third number
                    while(j<k && arr[k] == thirdNum) k--;
                }
                //if the sum is less , we need to maximise the sum , so increment the left index
                else if (arr[i] + secondNum + thirdNum < target) j++;
                //if sum is greater than target, we need to minimise the sum , so dement the right index.
                else k--;
            }
            while(arr[i] == firstNum && i <arr.length) i++;

        }
        return  ans;
    }

    public static void main(String[] args) {
        System.out.println("Triplet problem");
    }
}

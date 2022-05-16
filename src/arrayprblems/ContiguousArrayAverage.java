package arrayprblems;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class ContiguousArrayAverage {
    /**
     * Find the average of every contiguous array of size k and return the array of average
     * @param arr
     * @param k
     * @return
     */
    public static List<Integer> findAverage(int[] arr, int k){
        List<Integer> result = new ArrayList<Integer>();
        if(arr.length < k) {
            return result;
        }
        int windowStart = 0, windowEnd = k-1, sum = 0, i =0;
        while(i<=windowEnd){
            sum += arr[i++];
        }
        windowEnd++;
        result.add(sum/5);
        while(windowEnd<arr.length){
            sum -= arr[windowStart++];
            sum += arr[windowEnd++];
            result.add(sum/5);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        List<Integer> result = ContiguousArrayAverage.findAverage(input,5);
        Iterator itr = result.iterator();
        //Note we need to take care of float values otherwise , it will only print numbers.
        while(itr.hasNext()) System.out.println(itr.next());
    }
}

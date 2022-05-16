package arrayprblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayofArray {
    public static void main(String[] args) {
//        int[][] intervals = new int[4][2];
        int[][] intervals  = {{1,3},{15,18},{7,12},{2,6},{8,10}};
        System.out.println(Arrays.deepToString(intervals));
        intervals = mergeInterval(intervals);
        //Arrays.toString() to print normal arrays
//        System.out.println(Arrays.toString(intervals));
        System.out.println(Arrays.deepToString(intervals));

    }

    public static int[][] mergeInterval(int[][] intervals){
        List<int[]> result = new ArrayList<>();
        int resultIndex = -1;
        /*
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
         */
        //Below line is equivalent to above commented block.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int[] interval : intervals){
            if(result.isEmpty() || (resultIndex >=0 && result.get(resultIndex)[1]<interval[0])){
                result.add(interval);
                resultIndex++;
            }
            else if(result.get(resultIndex)[1] > interval[0]){
                result.get(resultIndex)[1] = Math.max(result.get(resultIndex)[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}

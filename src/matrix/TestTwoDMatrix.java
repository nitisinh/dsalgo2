package matrix;

import java.util.Arrays;

public class TestTwoDMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
        for(int i =0;i<mat.length;i++) printArr(mat[i]);
    }
    private static void printArr(int[] nums){
        System.out.println(Arrays.toString(nums));
//        Arrays.binarySearch();
    }
}

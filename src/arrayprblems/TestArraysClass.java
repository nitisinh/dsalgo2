package arrayprblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TestArraysClass {
    public static void main(String[] args) {
        int[] arr = {1,5,6,7,12,19,200};
        System.out.println(Arrays.binarySearch(arr,100));
        Queue<Integer> q = new LinkedList<>();
        q.isEmpty();
        q.poll();
    }
}

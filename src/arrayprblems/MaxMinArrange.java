package arrayprblems;

import java.util.Arrays;

public class MaxMinArrange {
    public static void rearrange(int arr[], int n){

        // Your code here
        int maxElement = Integer.MIN_VALUE,minIdx = 0, maxIdx = n-1;
        for (int i = 0; i<n;i++){
            maxElement = maxElement>arr[i] ? maxElement : arr[i];
        }
        maxElement += 1;
        for(int i = 0;i<n;i++){
            if(i%2==0){
                arr[i] = arr[i] + (arr[maxIdx--]%maxElement)*maxElement;
            }else{
                arr[i] = arr[i] + (arr[minIdx++]%maxElement)*maxElement;
            }
        }
        for(int i=0;i<n;i++){
            arr[i] = arr[i]/maxElement;
        }
    }

    public static void main(String[] args) {
        int[] input1 = {1,2,3,4,5,6};
        rearrange(input1,6);
        System.out.println(Arrays.toString(input1));

    }
}

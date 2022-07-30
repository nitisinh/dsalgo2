package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibDynamic {
    /**
     * This is the DP implementation of fibonacii. memo is used to memoize the value.
     * @param n
     * @param memo
     * @return
     */
    public static  int fibDynamic(int n, Map<Integer,Integer> memo){
        //Base case
        if(n<=2){
            return 1;
        }
        //if the result is already present in the memoized data , just return
        else if(memo.containsKey(n)){
            return memo.get(n);
        }
        //recursive case
        else {
            //update the memo.
            memo.put(n,fibDynamic(n-1, memo ) + fibDynamic(n-2,memo));
            return  memo.get(n);
        }
    }

    /**
     * This is the actual fib function which is called first which internally calls dynamic implementation of the fib.
     * @param n
     * @return
     */
    public static int fib(int n){
        Map<Integer,Integer> memo = new HashMap();
        return fibDynamic(n,memo);
    }

    /**
     * Driver function.
     * @param args
     */
    public static void main(String[] args) {
        int input = 50;
        System.out.println((fib(input)));
    }
}

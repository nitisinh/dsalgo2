package dynamicprogramming;

public class Knapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity){
        //TODO: write code here
        return -1;

    }

    private int recursiveKnapsack(int[] profits, int[] weights, int capacity, int currentIndex){
        return -1;
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 0;
        System.out.println("Map profit with capacity " +  capacity + " is : " + ks.solveKnapsack(profits, weights, capacity));
    }
}

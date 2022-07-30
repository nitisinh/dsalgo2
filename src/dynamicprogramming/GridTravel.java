package dynamicprogramming;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
public class GridTravel {
    /**
     * Find the total number of steps required to travel from top-left of a grid(size : row*col) to reach bottom-right.
     * @param row
     * @param col
     * @return
     */
    public static int gridTravellerRecursive(int row , int col){
        //Covering the base cases.
        if(row==1 && col ==1) return 1;
        if(row ==0 || col == 0) return 0;
        //Recursive Approach
        return gridTravellerRecursive(row-1,col) + gridTraveller(row,col-1);
    }

    /**
     * Entry function for all flavors of gridTraveller solution.
     * @param row
     * @param col
     * @return
     */
    public static int gridTraveller(int row , int col){
       //Calling the dynamic flavour of the code.
       return gridTravellerDynamic(row,col,new HashMap<String,Integer>());
        //Calling the Recursive flavour of the code.
        //Time Complexity = 2^(m+n)
        //Space Complexity = m+n
        //return gridTravellerRecursive(row,col,);
    }

    /**
     *
     * @param row
     * @param col
     * @param memo
     * @return
     * Time Complexity : O(m*n)
     * Space Complexity : O(m+n)
     */
    public static int gridTravellerDynamic(int row , int col, Map<String,Integer> memo){
        //Covering the base cases.
        if(row==1 && col ==1) return 1;
        if(row ==0 || col == 0) return 0;
        //Dynamic way
        //create the Key for "m,n" combination
        String key = row+","+col;
        if(memo.containsKey(key)) return memo.get(key);
        //we know that gridTraveller(m,n)  =gridTraveller(n,m)
        //find if "n,m" key has been updated already
        String sameComboKey = col + "," + row;
        if(memo.containsKey(sameComboKey)) return memo.get(sameComboKey);
        //update the memo with the key and return the value.
        memo.put(key,gridTravellerDynamic(row-1,col,memo)+gridTravellerDynamic(row,col-1,memo));
        return memo.get(key);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveller(1,1));
        System.out.println(gridTraveller(2,3));
        System.out.println(BigInteger.valueOf(gridTraveller(18,18)));
//        System.out.println(gridTraveller(1,1));

    }
}

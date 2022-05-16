package arrayprblems;

/**
 *  Number of Islands
 *      Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *      An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *      Example 1:
 *      Input: grid = [
 *          ["1","1","1","1","0"],
 *          ["1","1","0","1","0"],
 *          ["1","1","0","0","0"],
 *          ["0","0","0","0","0"]
 *      ]
 *      Output: 1
 *
 *     Example 2:
 *      Input: grid = [
 *      ["1","1","0","0","0"],
 *      ["1","1","0","0","0"],
 *      ["0","0","1","0","0"],
 *      ["0","0","0","1","1"]
 *      ]
 *      Output: 3
 *      Constraints:
 *
 *       m == grid.length
 *       n == grid[i].length
 *      1 <= m, n <= 300
 *      grid[i][j] is '0' or '1'.
 */

public class NumberOfIsland {
    private void markIsland(char[][] grid,int i, int j){
        //boundary condition
        if(j>=grid[0].length || i >=grid.length || i<0 ||j<0) return;
        // base condition
        if(grid[i][j] == '0') return;
        //Recursively call for all neighbouring points
        else{
            grid[i][j] = '0';
            markIsland(grid,i,j+1);
            markIsland(grid,i,j-1);
            markIsland(grid,i+1,j);
            markIsland(grid,i-1,j);
        }
    }

    /**
     * Driver function which returns the number of island
     * So basically all connected '1's will make island .
     * So once we have found 1 , mark all connected 1's as 0 because connected 1's will contribute to one island
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        //traverse through each entry
        for(int i =0;i<grid.length;i++){
            for(int j=0; j< grid[0].length;j++){
                //If '1' is found that means land is formed.
                if(grid[i][j] == '1') {
                    res++;
                    //Find all connected land and mark them as '0' so that they may not be considered again
                    markIsland(grid,i,j);
                }
            }
        }
        return res;
    }
}

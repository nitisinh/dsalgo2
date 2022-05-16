package problems;
// { { 31, 32, 33, 34 },
//   { 32, 32, 33, 34 },
//   { 33, 32, 33, 34 },
//   { 34, 35, 36, 37 }
//};
// 31, 32, 33, 34, 35, 36, 37 -> 7
public class GridContinuousPath {
    public static int findMaxPath(int[][] record,int[][] grid,int m,int n,int i, int j){
        if(record[i][j]==0){
            int result = 0;

            if(i==m-1 && j ==n-1){
                record[i][j] = 1;
                return 1;
            }
            if(i==m-1 ||j == n-1){
                result = 1;
            }
            if(i+1<m && grid[i][j]==grid[i+1][j]-1){
                result = 1 + findMaxPath(record,grid,m,n,i+1,j);
            }
            if(j+1<n && grid[i][j]==grid[i][j+1]-1){
                result = Math.max(result,1 + findMaxPath(record,grid,m,n,i,j+1));
            }
            record[i][j] = result;
        }
        return record[i][j];
    }


    public static int entryMethod(int[][] grid,int m, int n ){
        int[][] record = new int[m][n];
        for (int i =0;i<m;i++){
            for (int j =0;j<n;j++){
                record[i][j] = 0;
            }
        }
        //assume we are stareting from (0,0)
        return findMaxPath(record,grid,m,n,0,0);
    }

    public static void main(String[] args){
        int grid[][] = { { 31, 32, 33, 34 },
                { 32, 32, 33, 34 },
                { 33, 32, 33, 34 },
                { 34, 35, 36, 37 }};
        System.out.println(entryMethod(grid,4,4));
    }




}
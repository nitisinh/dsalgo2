package arrayprblems;
/*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    Note:
    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
    Example 1 =>
    Input: board =
    [['5','3','.','.','7','.','.','.','.']
    ,['6','.','.','1','9','5','.','.','.']
    ,['.','9','8','.','.','.','.','6','.']
    ,['8','.','.','.','6','.','.','.','3']
    ,['4','.','.','8','.','3','.','.','1']
    ,['7','.','.','.','2','.','.','.','6']
    ,['.','6','.','.','.','.','2','8','.']
    ,['.','.','.','4','1','9','.','.','5']
    ,['.','.','.','.','8','.','.','7','9']]
    Output: true

    Example 2 =>
    Input: board =
    [['8','3','.','.','7','.','.','.','.']
    ,['6','.','.','1','9','5','.','.','.']
    ,['.','9','8','.','.','.','.','6','.']
    ,['8','.','.','.','6','.','.','.','3']
    ,['4','.','.','8','.','3','.','.','1']
    ,['7','.','.','.','2','.','.','.','6']
    ,['.','6','.','.','.','.','2','8','.']
    ,['.','.','.','4','1','9','.','.','5']
    ,['.','.','.','.','8','.','.','7','9']]
    Output: false
    Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */


import org.w3c.dom.ls.LSOutput;

import java.util.HashSet;
import java.util.Set;
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        if(board.length < 9 || board[0].length < 9 ) return false;
        //create a set for each row , column and block
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] blockSet = new HashSet[9];
        //initialise all the sets
        for(int i = 0 ; i < 9 ; i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            blockSet[i] = new HashSet<>();
        }
        //for each value , check if there is duplicate value in any set or not
        //if duplicate value is there that means suduko is wrong.
        for(int row = 0 ; row < 9 ; row++){
            for(int col = 0 ; col < 9 ; col++){
                Character val = board[row][col];
                if(val == '.') continue;
                if(rowSet[row].contains(val)) return false;
                if(colSet[col].contains(val)) return false;
                // calculate the block number based on the row and col number.

                int block = 3*(row/3) + (col/3);
                if(blockSet[block].contains(val)) return false;
                //update all the sets
                rowSet[row].add(val);
                colSet[col].add(val);
                blockSet[block].add(val);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                 {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};


        System.out.println( "Valid Sudoku : " + isValidSudoku(board));

    }
}



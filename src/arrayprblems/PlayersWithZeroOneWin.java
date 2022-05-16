package arrayprblems;
/*
Find Players With Zero or One Losses
Return a list answer of size 2 where:
answer[0] is a list of all players that have not lost any matches.
answer[1] is a list of all players that have lost exactly one match.
The values in the two lists should be returned in increasing order.
Note:
You should only consider the players that have played at least one match.
The testcases will be generated such that no two matches will have the same outcome.
Example 1:

Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
Output: [[1,2,10],[4,5,7,8]]
Explanation:
Players 1, 2, and 10 have not lost any matches.
Players 4, 5, 7, and 8 each have lost one match.
Players 3, 6, and 9 each have lost two matches.
Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
Example 2:

Input: matches = [[2,3],[1,3],[5,4],[6,4]]
Output: [[1,2,5,6],[]]
Explanation:
Players 1, 2, 5, and 6 have not lost any matches.
Players 3 and 4 each have lost two matches.
Thus, answer[0] = [1,2,5,6] and answer[1] = [].

 */
import java.util.*;

public class PlayersWithZeroOneWin {
    public static List<List<Integer>> findWinners(int[][] matches) {
        //store win at 0th position and lose count at 1th position for each player
        Map<Integer,int[]> teamLoseCounter = new HashMap();
        List<List<Integer>> result = new ArrayList<>();
        //append empty lists in the result with the format expected
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for(int[] match : matches){
            //find entry for losing team
            //if there is fresh entry , add an array with default values as 0
            int[] currentMatchLoser = teamLoseCounter.getOrDefault(match[1],new int[]{0,0});
            //find entry for winnning team
            //if there is fresh entry , add an array with default values as 0
            int[] currentMatchWinner = teamLoseCounter.getOrDefault(match[0],new int[]{0,0});
            //increment lose count for losing team
            currentMatchLoser[1]++;
            //increment win count for winning team
            currentMatchWinner[0]++;
            //update the lose / win count for the team
            teamLoseCounter.put(match[1], currentMatchLoser);
            teamLoseCounter.put(match[0], currentMatchWinner);
        }
        //Now iterate through the map and record the team which has lost 0 times and 1 time.
        for(int key : teamLoseCounter.keySet()){
            if(teamLoseCounter.get(key)[1] == 0) {
                result.get(0).add(key);
            }
            if(teamLoseCounter.get(key)[1] == 1){
                result.get(1).add(key);
            }
        }
        //sort the  list entries as expected.
        Collections.sort(result.get(0));
        Collections.sort(result.get(1));
        return result;
    }

    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(findWinners(matches));
    }
}

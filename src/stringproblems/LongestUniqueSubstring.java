package stringproblems;
/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 *  Input: s = "abcabcbb"
 *  Output: 3
 *  Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *  Input: s = "bbbbb"
 *  Output: 1
 *  Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *  Input: s = "pwwkew"
 *  Output: 3
 *  Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *  Input: s = ""
 *  Output: 0
 */

import java.util.HashMap;
public class LongestUniqueSubstring {
    /**
     * Below approach maintains a map of unique characters with its index.
     * @param s
     * @return maximum length of a substring which has unique characters.
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        //maintain a hashmap of character pointing to the position
        HashMap<Character,Integer> charMap = new HashMap<>();
        int maxLen = 0, startIndx = 0, currLen = 0;
        while(startIndx<s.length()){
            char curr = s.charAt(startIndx);
            //if the map already contains the character , that means the uniqueness is broken
            if(charMap.containsKey(curr)){
                //we need to start from the next index of last occurence of the current character.
                startIndx = charMap.get(curr) + 1;
                //clear the map as we need to start a fresh for the subsequence
                charMap.clear();
                //check if the last maxlength was bigger than the current one
                maxLen = Math.max(currLen, maxLen);
                currLen = 0;
                continue;
            }
            //found a unique character . add it to map with the index
            charMap.put(curr,startIndx);
            currLen++;
            //update the max length as the new charcter got added to the charMao
            maxLen = Math.max(currLen, maxLen);
            startIndx++;
        }
        return maxLen;
    }
}

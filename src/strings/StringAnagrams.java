package strings;
import java.util.List;
import java.util.ArrayList;

/**
 * String Anagrams (hard) #
 * Given a string and a pattern, find all anagrams of the pattern in the given
 * string.
 * Anagram is actually a Permutation of a string. For example, “abc” has the
 * following six anagrams:
 * 1. abc 2. acb 3. bac 4. bca 5. cab 6. cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 */
public class StringAnagrams {
    /**
     *
     * @param s : Main String
     * @param p : Pattern string
     * @return List of Strings which are anagrams of the pattern
     */
    public static List<Integer> findStringAnagrams(String s, String p) {
//        List resultIndices = new ArrayList();
//        // TODO: Write your code here
//        return resultIndices;
        //s and p consist of lowercase English letters.
        int[] charMap = new int[26];
        int start =0, end =0, windowSize = 0;
        while(start<p.length()) ++charMap[p.charAt(start++) - 'a'];
        start = 0;
        List<Integer> result = new ArrayList<Integer>();
        while(end<s.length()){
            char endChar = s.charAt(end);
            //decrement count for the pattern's character found in main string
            --charMap[endChar - 'a'];
            windowSize = end - start + 1;
            //if window size grows bigger than pattern's length, shrink it
            //update the charMap while shrinking the window
            if(windowSize > p.length()){
                //leftmost character of window to be exited
                char startChar = s.charAt(start);
                ++charMap[startChar - 'a'];
                start++;
            }
            //If the pattern inside the window is anagram then add start to result.
            if(isAnagramPrersent(charMap)) result.add(start);
            end++;
        }
        return result;
    }

    /**
     * This function will check if all the entried for characters is zero or not
     * If all are zero means , the sliding window has got all the characters of the pattern
     * @param nums
     * @return
     */
    private static boolean isAnagramPrersent(int[] nums){
        for(int num : nums){
            if(num != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ppqp" , p1 = "pq";
        String s2 = "abbcabc" , p2 = "abc";
        System.out.println(StringAnagrams.findStringAnagrams(s1,p1));
        System.out.println(StringAnagrams.findStringAnagrams(s2,p2));
    }
}

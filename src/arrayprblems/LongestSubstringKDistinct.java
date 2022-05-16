package arrayprblems;

import java.util.HashMap;

public class LongestSubstringKDistinct {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            // use this hashmap to maintain the count of each character
            //we will have maximum k entries in the map
            HashMap<Character,Integer> charCount = new HashMap<Character,Integer>();
            int startIdx =0, endIdx =0, curLen = 0, maxLen =0;
            while(endIdx < s.length() && startIdx <s.length()){
                //Add character with its count in the map
                char ch_right = s.charAt(endIdx);
                charCount.put(ch_right,charCount.getOrDefault(ch_right,0) +1);
                //check if the count of character is more than k
                //run this loop until the count of entry does not become equal to k
                while(charCount.size() > k){
                    char characterAtFirstIndx = s.charAt(startIdx);
                    if(charCount.get(characterAtFirstIndx) == 1 ){
                        charCount.remove(characterAtFirstIndx);
                    }else{
                        charCount.put(characterAtFirstIndx,charCount.get(characterAtFirstIndx) - 1);
                    }
                    startIdx++;
                }
                //Now we have made the count of entry in the map = k
                //so lets register the maximum length
                maxLen = Math.max(endIdx-startIdx+1,maxLen);
                //increase the window size from right side.
                endIdx++;
            }
            return maxLen;
        }

    }



package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
        String s = "braceddddgbvfngfgh";
        int start = 0;
        while(start<s.length()){
            charMap.put(s.charAt(start), charMap.getOrDefault(s.charAt(start++),0) + 1);

        }
        Set<Character> keyset = charMap.keySet();
        for (char key: keyset) {
            System.out.println(key + " : " + charMap.get(key));
        }

        Map<String,Integer> teamPointMap = new HashMap<>();
        PriorityQueue<String> winners = new PriorityQueue<>((a,b)-> {return teamPointMap.get(b) - teamPointMap.get(a);});
    }
}

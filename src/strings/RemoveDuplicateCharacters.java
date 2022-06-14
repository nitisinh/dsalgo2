package strings;

import java.util.*;

public class RemoveDuplicateCharacters {
    public static String removeDuplicateLetters(String s) {
        //Stack to hold the characters in right lexical order.
        Stack<Character> charStack = new Stack<>();
        //Set to check the uniqueness of the character.
        Set<Character> charSet = new HashSet<>();
        //Map to hold the last index which holds each character.
        Map<Character,Integer> charMap = new HashMap<>();
        //update the charMap to store the last occurrence index of a character.
        for(int i = 0 ; i < s.length(); i++){
            charMap.put(s.charAt(i),i);
        }
        for(int i = 0 ; i < s.length(); i++){
            char currentChar = s.charAt(i);
            //if the current character is unique and already not considered.
            if(charSet.add(currentChar)){
                char stackTopChar;
                //stack should not be empty and
                //top character should be lexically bigger than current character and
                //charMap should show that top character will again be coming in sequence.
                while(charStack.size() > 0 && (stackTopChar  = charStack.peek()) > currentChar && charMap.get(stackTopChar)>i){
                    //remove the character from the stack and the set
                    charSet.remove(charStack.pop());
                }
                //Push the current character at right position.
                charStack.push(currentChar);
            }
        }
        //StringBuilder to build the result.
        StringBuilder sb = new StringBuilder();
        while(!charStack.isEmpty()){
            sb.append(charStack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }
}

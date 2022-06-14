package strings;

import java.util.Stack;

public class MinimumRemovalForValidParenthesis {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
//        String s = "a)b(c)d";
//        String s = "))((";
        //This array copy of string will be worked upon.
        char[] charResult = s.toCharArray();
        //Stack to be used to maintain the equal number of opening and closing braces
        Stack<Integer> charStack = new Stack<Integer>();
        for(int i = 0; i < charResult.length; i++){
            //if it is alphabet , just continue
            if(Character.isAlphabetic(charResult[i]))continue;
            //if it is opening brace , push to the stack
            else if(charResult[i]  == '(') charStack.push(i);
            //if it is closing brace
            else {
                //if there is no opening brace in stack , this closing brace will be removed.
                if(charStack.isEmpty()) charResult[i] = '#';
                //if stack has opening brace , it will be popped.
                else charStack.pop();
            }
        }
        //if there are still opening brace after all processing, mark them invalid.
        while(charStack.size()>0){
            charResult[charStack.pop()] = '#';
        }
        StringBuilder sb = new StringBuilder();
        //build the string builder for all valid characters.
        for(char c : charResult){
            if(c !='#') sb.append(c);
        }
        System.out.println(sb.toString());
    }


}

package arrayprblems.twopointer;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.isEmpty() || s.isBlank()) return true;
        //initiate two pointers.
        int start = 0 , end = s.length()-1;
        while(start<end){
            //capture the start and end character in 2 varibles
            char leftChar = s.charAt(start);
            char rightChar = s.charAt(end);
            //if the character is not alphabet or number skip and move
            if(!Character.isLetterOrDigit(leftChar)){
                ++start;
                continue;
            }
            if(!Character.isLetterOrDigit(rightChar)){
                --end;
                continue;
            }
            if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) return false;
            start++;
            end--;
        }
        return true;
    }
}

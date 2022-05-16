package strings;

public class CharOperation {
    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int start = 0; start<s1.length() ; start++){
            System.out.println(s1.charAt(start) - 'a');
        }

        System.out.println("***Handling CAPS letter now***");

        for(int start = 0; start<s2.length() ; start++){
            System.out.println(s2.charAt(start) - 'A');
        }

        System.out.println("***Lets check the integer value for the small letters***");
        for(int start = 0; start<s1.length() ; start++){
            System.out.println(s1.charAt(start) + ":" + (int)s1.charAt(start));
        }

        System.out.println("***Lets check the integer value for the small letters***");
        for(int start = 0; start<s2.length() ; start++){
            System.out.println(s2.charAt(start) + ":" + (int)s2.charAt(start));
        }
    }
}

package strings;

/**
 * Given a null-terminated string, remove all the white spaces (tabs or spaces) present in the string.
 * Example:#
 * Sample input#
 * All greek to me.
 * Expected output#
 * Allgreektome.
 */
public class RemoveWhiteSpace {
    public static void main(String[] args) {
        String s  = "All greek to me.          ";
        //Below by adding a '+' sign in the regex, we have handled continuous spaces as well.
        System.out.println(s.replaceAll(" +",""));

        //other way of doing it

    }
}

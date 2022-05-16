package arrayprblems;

public class ArrayScrible {
    public static void main(String[] args) {
        //check what is the default value of the array
        int[] arr = new int[26];
//        for(int num : arr) System.out.println(num);
        ++arr['D' - 'A'];
        for(int num : arr) System.out.println(num);
    }
}

package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateAndInitialise {
    public static void main(String[] args) {
        List<Integer> list = null;
        list = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(list);
    }
}

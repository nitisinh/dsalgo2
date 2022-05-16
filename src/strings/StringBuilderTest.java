package strings;

public class StringBuilderTest {
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(start < s.length()){
            sb.append(s.charAt(start));
            if(start++%2 ==0){
                sb.deleteCharAt(0);
            }
        }
        System.out.println(sb);
    }
}

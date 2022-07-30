package arrayprblems;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxStock {

    public static List<Integer> findSol(List<Integer> stockPrice){
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> left = new PriorityQueue<>();
        for(int i = 0 ; i < stockPrice.size();i++){
            left.add(stockPrice.get(i));
            int minIndex = -1;
            for(int k = i +1; k < stockPrice.size();k++){
                if(stockPrice.get(k)>left.peek()){
                    if(minIndex==-1) minIndex = k;
                }
            }
            result.add(minIndex);
        }
        return result;
    }
}

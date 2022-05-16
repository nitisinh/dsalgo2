package problems;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRU {
    static int capacity;
    static final String BAD_VAL = "BAD_VAL";
    //Store the Cache entry with key in the map
    HashMap<Integer,Cache> entry = new HashMap<>();
    //Use Double Ended queue to maintain the least & most recently used elements based on the keys.
    Deque<Integer> q = new LinkedList<>();
    LRU(int cap){
        capacity = cap;
    }
    class Cache{
        int key;
        String value;
        Cache(int key,String value){
            this.key = key;
            this.value = value;
        }
    }

    /**
     * This functino puts an element in the LRU
     * @param key
     * @param value
     */
    public void putElement(int key, String value){
        //check if the key is already present in the map
        if(entry.containsKey(key)){
            q.remove(key);
        }else{
            if(q.size() == capacity){
                int lastKey = q.removeLast();
                entry.remove(lastKey);
            }
        }
        //Create a new entry
        Cache newItem = new Cache(key,value);
        //update the entry in the map
        entry.put(key,newItem);
        //update the queue to mark the current element as most recently used element
        q.addFirst(key);
    }

    /**
     * This function will be used to fetch the element from the cache
     * @param key
     * @return
     */
    public String getElement(int key){
        //if the key exists in the entry. Return the value of cache.
        if(entry.containsKey(key)){
            //fetch the value from the entry
            String val = entry.get(key).value;
            //update the queue to mark the current element as the most recently used.
            q.remove(key);
            q.addFirst(key);
            return val;
        }
        return BAD_VAL;
    }

    /**
     * Driver Main function.
     * @param args
     */
    public static void main(String[] args) {
        LRU lru = new LRU(4);
        lru.putElement(1,"One");
        lru.putElement(2,"Two");
        lru.putElement(3,"Three");
        lru.putElement(4,"Four");
        System.out.println(lru.q);
        lru.putElement(5,"Five");
        System.out.println(lru.q);
    }
}

package heap;

import java.util.PriorityQueue;

public class MyPriorityQueue {
    PriorityQueue<Integer> heap;
    int capacity;

    /**
     * NOTE: By default the heap created in min heap.
     * @param cap
     */
    public MyPriorityQueue(int cap){
        this.capacity = cap;
        this.heap = new PriorityQueue<Integer>(cap);
    }

    /**
     * Add element to the heap.
     * @param key
     */
    public void add(int key){
        if(this.heap.size() == this.capacity){
            System.out.println("Heap overflown.Can't add any more");
            return;
        }
        try{
            this.heap.add(key);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MyPriorityQueue heap = new MyPriorityQueue(5);
        heap.add(4);
        heap.add(1);
        heap.add(10);
        heap.add(0);
        System.out.println(heap.heap);
    }

}

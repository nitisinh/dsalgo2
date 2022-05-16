package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCheatList {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q);
        testAdd(q);
        testOffer(q);
        testPoll(q);
        testPeek(q);
        testRemove(q);

//        q.offer(10);
//        System.out.println(q);
//        System.out.println("peek : " + q.peek() + "\nAfter peek - ");
//        System.out.println(q);
//        System.out.println("poll : " + q.poll() + "\nAfter poll - ");
//        System.out.println(q);
    }
    public  static void testOffer(Queue<Integer> myQ){
        System.out.println("Original Queue : " + myQ);
        myQ.offer(100);
        System.out.println("Ran offer(100) : " + myQ);
        System.out.println(myQ);
    }
    public  static void testAdd(Queue<Integer> myQ){
        System.out.println("Original Queue : " + myQ);
        myQ.add(200);
        System.out.println("Ran add(200) : " + myQ);
    }
    public  static void testPoll(Queue<Integer> myQ){
        System.out.println("Original Queue : " + myQ);
        myQ.poll();
        System.out.println("Ran poll() :" + myQ);
    }
    public  static void testPeek(Queue<Integer> myQ){
        System.out.println("Original Queue : " + myQ);
        myQ.peek();
        System.out.println("Ran peek() :" + myQ);
    }
    public  static void testRemove(Queue<Integer> myQ){
        System.out.println("Original Queue : " + myQ);
        myQ.remove();
        System.out.println("Ran remove() :" + myQ);
    }
}

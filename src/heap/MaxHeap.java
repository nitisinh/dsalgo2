package heap;

public class MaxHeap {
    private int capacity;
    private int[] heap;
    private int size;

    /**
     * Constructor to build the max heap.
     * Initialise the size and array to represent the heap
     * @param capacity
     */
    public  MaxHeap(int capacity){
        //initiate the size of the heap = 0
        //size will maintain the number of current elements in the heap.
        this.size = 0;
        this.capacity = capacity;
        heap = new int[capacity];
    }

    /**
     * This functin will return the index of parent.
     * @param index
     * @return
     */
    private int parent(int index) {
        if(index==0) {
            System.out.println("Curernt node is root node");
            return index;
        }
        return (index-1)/2; //parent node = (ith node - 1) /2
    }

    /**
     * This function will return the left child of current node.
     * @param index
     * @return
     */
    private int left(int index){
        if(index == this.capacity) {
            System.out.println("Current node is a leaf node");
            return index;
        }
        //left child of ith node = 2*i +1
        return ((2*index)+1);
    }

    /**
     * This function will return the right child of current node.
     * @param index
     * @return
     */
    private int right(int index){
        if(index == this.capacity) {
            System.out.println("Current node is a leaf node");
            return index;
        }
        //left child of ith node = 2*i +2
        return ((2*index)+2);
    }


    /**
     * This method will sure that max heap property is intact.
     * @param index
     */
    private void heapify(int index) {
        //If the current index breaches the size of the heap. No need to heapify
        if(index>=this.capacity) return;
        int parentIndex = parent(index);
        //check if the parent node has less value than child node. This means max heap property violated.
        //we need to swap the nodes here
        while(index!=0 && heap[parentIndex] < heap[index]){
            int temp = heap[parentIndex];
            heap[parentIndex] = heap[index];
            heap[index] = temp;
        }
    }
    /**
     * This API finds the max element present in the heap.
     * @return
     */
    public int getMax(){
        if(this.size == 0){
            System.out.println("Heap is empty!!");
            //considering the minimum possible value of integer.
            return Integer.MIN_VALUE;
        }
        //root node contains the maximum value in Max heap.
        return this.heap[0];
    }

    /**
     * Thie method to be used to insert a key
     * @param key
     */
    public void insert(int key){
        // If the heap is already full just flag and return
        if(this.size == this.capacity){
            System.out.println("Heap overflown. No space to add new key");
            return;
        }
        //Add the node at the end.
        this.heap[this.size] = key;
        //heapify if required
        heapify(this.size++);
    }








}

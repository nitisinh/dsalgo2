package multithreading;
import java.lang.Runnable;
import java.lang.Thread;


class MTDemo implements Runnable{
    //This is implementation of the run class defined in Runnable interface.
    public void run(){
        System.out.println("Executing run() function");
    }
}

class MTDemoThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread class has been extended here !!!");
    }
}



public class MTImplementsRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MTDemo());
        t1.start();

        //In case Thread class is extended we can directly start the object.
//        MTDemoThread mtdt = new MTDemoThread();
//        mtdt.start();
        new MTDemoThread().start();
    }

}

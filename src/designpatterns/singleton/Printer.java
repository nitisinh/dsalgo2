package designpatterns.singleton;

public class Printer {

    // If we directly instantiate here , it is called Eager Singleton
    // An object is created as soon as class is created even if we do not need the instance , it is created
    // Make this variable volatile so that no value is cached and it is always stored in main memory.
    // Volatile will make sure that all threads are reading the same variable.
    private static volatile Printer printerInstance = null;
    //make the constructor private so that the class can not be instantiated.
    private Printer(){

    }
    //write a function to get the instance of the class
    //This should be static function to make sure no object is needed to access it.
    public static Printer getInstance(){
        //lazy loading
        if(printerInstance==null){
            //create a synchronized block so that no two thread instantiates the class
            synchronized (Printer.class){
                //Add double lock here -> Add the check once again so that even when second thread enters , it does not instantiate
                if(printerInstance == null){
                    printerInstance = new Printer();
                }
            }
        }
        return printerInstance;
    }
}

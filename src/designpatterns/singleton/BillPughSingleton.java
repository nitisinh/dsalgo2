package designpatterns.singleton;

/*
Bill Pugh was main force behind the java memory model changes.
His principle “Initialization-on-demand holder idiom” also uses the static block idea, but in a different way.
It suggests to use static inner class.
Until we need an instance, the LazyHolder class will not be initialized until required,
and you can still use other static members of BillPughSingleton class.
This is the solution, I will recommend to use. I have used it in my all projects.
 */


public class BillPughSingleton {
    private  BillPughSingleton(){
    }
    private static class LazyLoader{
        private static final BillPughSingleton INSTANCE  = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance(){
        return LazyLoader.INSTANCE;
    }
}

package designpatterns.factory;

public class Chocolate implements IceCream{

    @Override
    public void tastesLike() {
        System.out.println("Tastes like chocolate");
    }
}

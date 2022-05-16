package designpatterns.factory;

public class Vanilla implements IceCream{
    @Override
    public void tastesLike() {
        System.out.println("Tastes like Vanilla");
    }
}

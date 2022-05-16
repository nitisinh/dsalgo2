package designpatterns.factory;

public class IceCreamFactoryDemo {
    public static void main(String[] args) {
        IceCreamFactory icefactory  = new IceCreamFactory();
        IceCream myIceCream = icefactory.getIceCream("vanilla");
        myIceCream.tastesLike();
    }
}

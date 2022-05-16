package designpatterns.factory;

public class IceCreamFactory {
    public IceCream getIceCream(String type){
        switch(type.toUpperCase()){
            case "VANILLA":
                return new Vanilla();
            case "CHOCOLATE" :
                return new Chocolate();
            case "STRAWBERRY" :
                return new Strawberry();
            default:
                return null;
        }
    }
}

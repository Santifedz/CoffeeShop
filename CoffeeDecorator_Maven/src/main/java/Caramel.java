public class Caramel extends CoffeeDecorator{

    private double cost = .80;
    Caramel(Coffee specialCoffee){
        super(specialCoffee);
    }

    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addCaramel();
    }

    private double addCaramel() {

        //System.out.println(" + Caramel: $.80");

        return cost;
    }
}

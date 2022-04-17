public class AlmondMilk extends CoffeeDecorator{

    private double cost = .75;
    AlmondMilk(Coffee specialCoffee){
        super(specialCoffee);
    }

    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addAlmondMilk();
    }

    private double addAlmondMilk() {
        //System.out.println(" + Almond Milk: $.75");
        return cost;
    }
}

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ShopController {


    @FXML
    public ListView<String> receipt;
    @FXML
    public RadioButton coffee;
    @FXML
    public RadioButton cream;
    @FXML
    public RadioButton sugar;
    @FXML
    public RadioButton caramel;
    @FXML
    public RadioButton almondMilk;
    @FXML
    public RadioButton extraShot;
    @FXML
    public TextField name;

    public void orderRequest(MouseEvent mouseEvent) {

        if(CoffeeShop.coffee == true){
            CoffeeShop.count = 1;
            Coffee order = new BasicCoffee();
            receipt.getItems().add(name.getText()+" Order:");
            receipt.getItems().add("Black Coffee: $3.99");
            if(CoffeeShop.cream){
                CoffeeShop.count += 1;
                order = new Cream(order);
                receipt.getItems().add(" + cream: $.50");
            }
            if(CoffeeShop.extraShot){
                CoffeeShop.count += 1;
                order = new ExtraShot(order);
                receipt.getItems().add(" + extra shot: $1.20");
            }
            if(CoffeeShop.sugar){
                CoffeeShop.count += 1;
                order = new Sugar(order);
                receipt.getItems().add(" + sugar: $.50");
            }
            if(CoffeeShop.caramel){
                CoffeeShop.count += 1;
                order = new Caramel(order);
                receipt.getItems().add(" + caramel: $.80");
            }
            if(CoffeeShop.almondMilk){
                CoffeeShop.count += 1;
                order = new AlmondMilk(order);
                receipt.getItems().add(" + Almond Milk: $.75");
            }

            receipt.getItems().add("total: " + order.makeCoffee());
            CoffeeShop.count += 1;

            CoffeeShop.orderList.add(order);
            CoffeeShop.coffee = false;
            coffee.setSelected(false);
            CoffeeShop.almondMilk = false;
            almondMilk.setSelected(false);
            CoffeeShop.cream = false;
            cream.setSelected(false);
            CoffeeShop.caramel = false;
            caramel.setSelected(false);
            CoffeeShop.sugar = false;
            sugar.setSelected(false);
            CoffeeShop.extraShot = false;
            extraShot.setSelected(false);

        }else{
            receipt.getItems().add("SELECT A COFFEE!");
            CoffeeShop.count += 1;
        }
    }

    public void selectCoffee(MouseEvent mouseEvent) {
        if(coffee.isSelected())
            CoffeeShop.coffee = true;
        if(!coffee.isSelected())
            CoffeeShop.coffee = false;
    }

    public void selectCream(MouseEvent mouseEvent) {
        if(cream.isSelected())
            CoffeeShop.cream = true;
        if(!cream.isSelected())
            CoffeeShop.cream = false;
    }

    public void selectSugar(MouseEvent mouseEvent) {
        if(sugar.isSelected())
            CoffeeShop.sugar = true;
        if(!sugar.isSelected())
            CoffeeShop.sugar = false;
    }

    public void selectCaramel(MouseEvent mouseEvent) {
        if(caramel.isSelected())
            CoffeeShop.caramel = true;
        if(!caramel.isSelected())
            CoffeeShop.caramel = false;
    }

    public void selectAlmondMilk(MouseEvent mouseEvent) {
        if(almondMilk.isSelected())
            CoffeeShop.almondMilk = true;
        if(!almondMilk.isSelected())
            CoffeeShop.almondMilk = false;
    }

    public void selectExtraShot(MouseEvent mouseEvent) {
        if(extraShot.isSelected())
            CoffeeShop.extraShot = true;
        if(!extraShot.isSelected())
            CoffeeShop.extraShot = false;
    }

    public void remove(MouseEvent mouseEvent) {
        for(int i = 0; i <= CoffeeShop.count; i++){
            receipt.getItems().remove(0);
        }
    }
}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CoffeeShop extends Application {

	static boolean coffee = false;
	static boolean cream = false;
	static boolean sugar = false;
	static boolean caramel = false;
	static boolean almondMilk = false;
	static boolean extraShot = false;
	static int count = 0;

	static ArrayList<Coffee> orderList;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Who want's coffee!!!");

		Parent shopRoot = FXMLLoader.load(getClass().getResource("shop.fxml"));
		Scene shop = new Scene(shopRoot);
		shopRoot.getStylesheets().add(getClass().getResource("shopStyle.css").toExternalForm());
		primaryStage.setScene(shop);
		primaryStage.show();
		
		Coffee order = new AlmondMilk(new Caramel(new Sugar(new Cream( new ExtraShot(new BasicCoffee())))));
		
		double cost = order.makeCoffee();
		System.out.println("Total: "+cost);
	}

}

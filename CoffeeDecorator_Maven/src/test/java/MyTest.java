import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AllCoffeeTest {

		Coffee order = new AlmondMilk(new Caramel(new Sugar(new Cream( new ExtraShot(new BasicCoffee())))));
		double cost1 = order.makeCoffee();

		@Test
		void priceAllCheckTest(){
			assertEquals((3.99+1.20+0.50+0.50+0.80+0.75),cost1, "wrong value");
		}

		Coffee BasicOrder = new BasicCoffee();
	    double cost2 = BasicOrder.makeCoffee();

		@Test
		void priceCoffeeCheckTest(){
			assertEquals(3.99,cost2, "wrong value");
		}

		Coffee CaramelLatte = new ExtraShot(new Cream(new Caramel(BasicOrder)));
		double cost3 = CaramelLatte.makeCoffee();

		@Test
		void priceCaramelLatteCheckTest(){
			assertEquals(3.99+1.2+0.5+0.8,cost3, "wrong value");
		}

		double cost4 = BasicOrder.makeCoffee();
		@Test
		void priceBasicAfter(){
			assertEquals(3.99,cost4, "wrong value");
		}

		Coffee DairyFree = new AlmondMilk(new BasicCoffee());
		double cost5 = DairyFree.makeCoffee();
		@Test
		void priceDairyFree(){
		assertEquals(3.99+0.75,cost5, "wrong value");
	}

		Coffee DairyFreeLatte = new ExtraShot(DairyFree);
		double cost6 = DairyFreeLatte.makeCoffee();
		@Test
		void priceDairyFreeLatte(){
		assertEquals(3.99+0.75+1.20,cost6, "wrong value");
	}

		Coffee redEye = new ExtraShot(new BasicCoffee());
		double cost7 = redEye.makeCoffee();
		@Test
		void priceRedEye(){
		assertEquals(3.99+1.20,cost7, "wrong value");
	}

		Coffee myOrder = new ExtraShot(new ExtraShot(new ExtraShot(new ExtraShot(new ExtraShot(redEye)))));
		double cost8 = myOrder.makeCoffee();
		@Test
		void priceMyOrder(){
		assertEquals(3.99+(1.20*6),cost8, "wrong value");
	}

		Coffee difficultCustomer = new ExtraShot(new Sugar(new Sugar(new Caramel(new Caramel(new AlmondMilk(new Caramel(new Cream(new ExtraShot(new BasicCoffee())))))))));
		double cost9 = difficultCustomer.makeCoffee();
		@Test
		void priceDifficult(){
		assertEquals(11.040000000000001,cost9, "wrong value");
	}

		Coffee simple1 = new Sugar(new BasicCoffee());
		Coffee simple2 = new Sugar(new BasicCoffee());
		@Test
		void priceSame(){
		assertEquals(simple1.makeCoffee(),simple2.makeCoffee(), "wrong value");
	}




}

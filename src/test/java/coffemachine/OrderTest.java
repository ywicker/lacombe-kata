package coffemachine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import coffemachine.model.Drink;
import coffemachine.model.Order;

public class OrderTest {

	@Test
	public void getMessage() {
		assertEquals(new Order(Drink.Tea, 1, 0.5).getMessage(), "T:1:0");
		assertEquals(new Order(Drink.Coffee, 2, 0.2).getMessage(), "M:Missing 40");
		assertEquals(new Order(Drink.Coffee, 2, 0.7).getMessage(), "C:2:0");
		assertEquals(new Order(Drink.Chocolate, 0, 0.5).getMessage(), "H::");
		assertEquals(new Order(Drink.Orange, 0, 0.6).getMessage(), "O::");
		assertEquals(new Order(Drink.HotCoffee, 0, 0.7).getMessage(), "Ch::");
		assertEquals(new Order(Drink.HotTea, 2, 0.7).getMessage(), "Th:2:0");
		assertEquals(new Order(Drink.HotChocolate, 1, 0.7).getMessage(), "Hh:1:0");

		assertEquals(new Order(null, 1, 0.5).getMessage(), "::");
	}
}

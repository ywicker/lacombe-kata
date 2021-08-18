package coffemachine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import coffemachine.model.Drink;
import coffemachine.model.Order;

public class OrderTest {

	@Test
	public void getMessage() {
		assertEquals(new Order(Drink.T, 1).getMessage(), "T:1:0");
		assertEquals(new Order(Drink.C, 2).getMessage(), "C:2:0");
		assertEquals(new Order(Drink.H, 0).getMessage(), "H::");

		assertEquals(new Order(null, 1).getMessage(), "::");
	}
}

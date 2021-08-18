package coffemachine.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Generate commande to maker
 */
public class Order {
	private static Map<Drink, String> drinkCodes = new HashMap<Drink, String>();
	private static Map<Drink, Double> drinkPrices = new HashMap<Drink, Double>();
	static {
		drinkCodes.put(Drink.Tea, "T");
		drinkPrices.put(Drink.Tea, 0.4);
		drinkCodes.put(Drink.Coffee, "C");
		drinkPrices.put(Drink.Coffee, 0.6);
		drinkCodes.put(Drink.Chocolate, "H");
		drinkPrices.put(Drink.Chocolate, 0.5);
		drinkCodes.put(Drink.Orange, "O");
		drinkPrices.put(Drink.Orange, 0.6);
		drinkCodes.put(Drink.HotTea, "Th");
		drinkPrices.put(Drink.HotTea, 0.7);
		drinkCodes.put(Drink.HotCoffee, "Ch");
		drinkPrices.put(Drink.HotCoffee, 0.7);
		drinkCodes.put(Drink.HotChocolate, "Hh");
		drinkPrices.put(Drink.HotChocolate, 0.7);
	}

	private Drink type;
	private int sugars;
	private String message;

	public Order(final Drink type, final int sugars, final double money) {
		this.type = type;
		this.sugars = sugars;
		try {
			double price = drinkPrices.get(type);
			if(price > money) {
				String value = Double.toString((price - money) * 100);
				this.message = "M:Missing " + value.substring(0, value.indexOf("."));
			} else {
				this.message = drinkCodes.get(type) + ":" + (sugars > 0 ? Integer.toString(sugars) + ":0" : ":");
			}
		} catch (NullPointerException e) {
			this.message = "::";
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

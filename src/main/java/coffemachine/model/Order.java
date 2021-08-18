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
		drinkCodes.put(Drink.Chocalate, "H");
		drinkPrices.put(Drink.Chocalate, 0.5);
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

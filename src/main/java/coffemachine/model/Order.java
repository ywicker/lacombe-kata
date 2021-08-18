package coffemachine.model;

/**
 * Generate commande to maker
 */
public class Order {
	private Drink type;
	private int sugars;
	private boolean stick;
	private String message;

	public Order(final Drink type, final int sugars) {
		this.type = type;
		this.sugars = sugars;
		this.stick = sugars > 0;
		try {
			this.message = type.toString() + ":" + Integer.toString(sugars) + ":" + (stick ? "0" : "");
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

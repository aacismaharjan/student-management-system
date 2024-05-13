public enum PizzaRate {
	SMALL(4.99f),
	MEDIUM(6.99f),
	LARGE(9.99f);
	
	private final float price;
	
	PizzaRate(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return price;
	}
}
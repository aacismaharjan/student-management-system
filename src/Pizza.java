// Define the Pizza class with customer name, pizza size, and topping
public class Pizza {
    // Private attributes for encapsulation
    private String customerName;
    private String pizzaSize;
    private String topping;

    // Default constructor
    public Pizza() {
        this.customerName = "Unknown";
        this.pizzaSize = "Medium";
        this.topping = "Cheese";
    }

    // Constructor with parameters
    public Pizza(String customerName, String pizzaSize, String topping) {
        this.customerName = customerName;
        this.pizzaSize = pizzaSize;
        this.topping = topping;
    }

    // Setter for customer name
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getter for customer name
    public String getCustomerName() {
        return this.customerName;
    }

    // Setter for pizza size
    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    // Getter for pizza size
    public String getPizzaSize() {
        return this.pizzaSize;
    }

    // Setter for topping
    public void setTopping(String topping) {
        this.topping = topping;
    }

    // Getter for topping
    public String getTopping() {
        return this.topping;
    }

    // Method to display pizza information
    public void displayPizzaInfo() {
        System.out.println("Customer Name: " + this.customerName);
        System.out.println("Pizza Size: " + this.pizzaSize);
        System.out.println("Topping: " + this.topping);
    }
    
    public float getTotalPrice() {
    	if(this.getPizzaSize().equals("Medium")) {
    		return PizzaRate.MEDIUM.getPrice();
    	}else if(this.getPizzaSize().equals("Small")) {
    		return PizzaRate.SMALL.getPrice();
    	}
    	
    	return PizzaRate.LARGE.getPrice();
    }
    
    public String getPizzaText() {
    	return this.getCustomerName() + "\t\t\t\t\t" + this.getTopping() + "\t\t\t\t\t" + Integer.parseInt(this.getTopping()) * getTotalPrice() + "\n";
    }
}
//
//// Test program for Pizza class
//public class PizzaDemo {
//    public static void main(String[] args) {
//        // Create a Pizza object with default values
//        Pizza pizza1 = new Pizza();
//
//        System.out.println("Default Pizza:");
//        pizza1.displayPizzaInfo();
//
//        // Create a Pizza object with custom values
//        Pizza pizza2 = new Pizza("John Doe", "Large", "Pepperoni");
//
//        System.out.println("\nCustom Pizza:");
//        pizza2.displayPizzaInfo();
//
//        // Modify attributes of pizza2
//        pizza2.setCustomerName("Jane Smith");
//        pizza2.setPizzaSize("Small");
//        pizza2.setTopping("Mushrooms");
//
//        System.out.println("\nUpdated Pizza:");
//        pizza2.displayPizzaInfo();
//    }
//}

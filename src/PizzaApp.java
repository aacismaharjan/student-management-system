import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PizzaApp {
	
	static ArrayList<Pizza> pizzaStore = new ArrayList<Pizza>();

    public static void main(String[] args) {
        // Create the main frame
        Frame frame = new Frame("Rocky Woodfired Pizzas Management System");
        
        // Title Label with larger font
        Label lblTitle = new Label("Rocky Woodfired Pizzas Management System");
        lblTitle.setFont(new Font(null, Font.BOLD, 24));
        
        // Panels for layout organization
        Panel panelTitle = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        Panel panelCustomer = new Panel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        Panel panelOptions = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        // Customer name input
        Label lblName = new Label("Customer Name:");
        TextField txtName = new TextField();
        txtName.setPreferredSize(new Dimension(300, 20));
        
        // Number of toppings input
        Label lblToppings = new Label("Number of toppings:");
        TextField txtToppings = new TextField();
        txtToppings.setPreferredSize(new Dimension(300, 20));
        
        // Checkbox group for pizza size
        CheckboxGroup groupSize = new CheckboxGroup();
        Checkbox chkSmall = new Checkbox("Small", groupSize, false);
        Checkbox chkMedium = new Checkbox("Medium", groupSize, false);
        Checkbox chkLarge = new Checkbox("Large", groupSize, false);
        
        // Adding components to the panels
        panelTitle.add(lblTitle);
        panelCustomer.add(lblName);
        panelCustomer.add(txtName);
        panelOptions.add(lblToppings);
        panelOptions.add(txtToppings);
        panelOptions.add(chkSmall);
        panelOptions.add(chkMedium);
        panelOptions.add(chkLarge);
        
        // Panel for button actions
        Panel panelButtons = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        Button btnEnter = new Button("Enter");
        Button btnDisplayAll = new Button("Display All");
        Button btnSearch = new Button("Search");
        Button btnExit = new Button("Exit");
        
        panelButtons.add(btnEnter);
        panelButtons.add(btnDisplayAll);
        panelButtons.add(btnSearch);
        panelButtons.add(btnExit);
        
        // Text area for displaying output
        TextArea txtArea = new TextArea();
        txtArea.setPreferredSize(new Dimension(600, 200));

		
        
        Panel panelHead = new Panel(new GridLayout(3, 1));
        panelHead.add(panelTitle);
        panelHead.add(panelCustomer);
        panelHead.add(panelOptions);
        
        
        
        
        // Adding components to the frame
        frame.setLayout(new BorderLayout());
        frame.setSize(new Dimension(800, 500));
        frame.add(panelHead, BorderLayout.NORTH);
        frame.add(txtArea, BorderLayout.CENTER);
        frame.add(panelButtons, BorderLayout.SOUTH);
        
        btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArea.setText("Customer Name \t\t\t\t\t Garments \t\t\t\t\t Charge\n");
				
				for(Pizza pizza : pizzaStore) {
					if(txtName.getText().equals(pizza.getCustomerName())) {
						txtArea.append(pizza.getCustomerName() + "\t\t\t\t\t" + pizza.getTopping() + "\t\t\t\t\t" + pizza.getTotalPrice() + "\n");
					}
				}
			}
		});
        
        
        btnEnter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String customerName = txtName.getText();
        		String toppings = txtToppings.getText();
        		Checkbox selectedSize = groupSize.getSelectedCheckbox();
        		String pizzaSize = selectedSize != null ? selectedSize.getLabel() : "Unknown";
        		
        		Pizza newPizza = new Pizza(customerName, pizzaSize, toppings);
        		txtArea.setText("Customer Name \t\t\t\t\t Garments \t\t\t\t\t Charge\n");
        		txtArea.append(newPizza.getPizzaText());
        		
        		pizzaStore.add(newPizza);
        	}
        });
        
        btnDisplayAll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		txtArea.setText("Customer Name \t\t\t\t\t Garments \t\t\t\t\t Charge\n");
        		for(Pizza newPizza : pizzaStore) {
        			txtArea.append(newPizza.getPizzaText());
        		}
        	}
        });
        
        
        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        	}
        });
        
        // Window closing behavior
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}

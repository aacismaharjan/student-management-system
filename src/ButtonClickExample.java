import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonClickExample extends JFrame implements ActionListener {
    private JButton button;

    public ButtonClickExample() {
        // Create the button and set its text
        button = new JButton("Click Me!");

        // Register this class as the action listener for the button
        button.addActionListener(this);

        // Set up the JFrame
        this.setTitle("ActionListener Example");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the button to the frame
        this.add(button);

        // Center the frame on the screen
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method is called when the button is clicked
        if (e.getSource() == button) {
            System.out.println("Button was clicked!");
        }
    }

    public static void main(String[] args) {
        // Create and display the GUI
        ButtonClickExample example = new ButtonClickExample();
        example.setVisible(true);
    }
}

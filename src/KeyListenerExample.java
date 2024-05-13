import javax.swing.*;
import java.awt.event.*;

public class KeyListenerExample extends JFrame implements KeyListener {
    public KeyListenerExample() {
        JTextField textField = new JTextField(20);
        textField.addKeyListener(this);
        
        this.add(textField);
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    	System.out.println(e);
        System.out.println("Key typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        new KeyListenerExample();
    }
}

import javax.swing.*;
import java.awt.event.*;

public class MouseListenerExample extends JFrame implements MouseListener {
    public MouseListenerExample() {
        JButton button = new JButton("Hover or Click");
        button.addMouseListener(this);
        
        this.add(button);
        this.setSize(200, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked!");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered!");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited!");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed!");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released!");
    }

    public static void main(String[] args) {
        new MouseListenerExample();
    }
}

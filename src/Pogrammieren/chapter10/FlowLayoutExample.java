package Pogrammieren.chapter10;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample  extends JFrame {

    private FlowLayoutExample(){
        this.setTitle("Flow Layout Example");

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.add(new JLabel("Hello World"));
        this.add(new JTextField("Pausen Dauer", 5));
        this.add(new JButton("Starte Pause"));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}

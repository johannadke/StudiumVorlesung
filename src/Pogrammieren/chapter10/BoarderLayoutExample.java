package Pogrammieren.chapter10;

import javax.swing.*;
import java.awt.*;

public class BoarderLayoutExample extends JFrame {

    private BoarderLayoutExample() {
        this.setTitle("Boarder Layout Example");

        this.setLayout(new BorderLayout()); //eigentlich unnötig, weil default

        this.add(new JButton("Button1"), BorderLayout.NORTH);
        this.add(new JButton("Button2"), BorderLayout.SOUTH);
        this.add(new JButton("Button3"), BorderLayout.EAST);
        this.add(new JButton("Button4"), BorderLayout.WEST);
        //this.add(new JButton("Button5")); //Default ist Center

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(new JButton("Button Center"));
        centerPanel.add(new JButton("Button Center2"));

        this.add(centerPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Programm startet....");
        new BoarderLayoutExample(); //neuer Thraed wird gestartet
        System.out.println("Programm ist zuende...");
    }
}

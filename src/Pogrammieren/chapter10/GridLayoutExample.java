package Pogrammieren.chapter10;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {

    private GridLayoutExample(){
        this.setTitle("Grid Layout Example");

        this.setLayout(new GridLayout(0,2));

        this.add(new JButton("Zelle1"));
        this.add(new JButton("Zelle2"));
        this.add(new JButton("Zelle3"));
        this.add(new JButton("Zelle4"));

        JPanel cellPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cellPanel.add(new JButton("Zelle5"));
        this.add(cellPanel);

        this.add(new JButton("Zelle6"));
        this.add(new JButton("Zelle7"));
        this.add(new JButton("Zelle8"));
        this.add(new JButton("Zelle9"));
        this.add(new JButton("Zelle10"));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new GridLayoutExample();
    }
}

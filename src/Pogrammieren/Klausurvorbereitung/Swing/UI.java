package Pogrammieren.Klausurvorbereitung.Swing;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {
    public UI(){
        JFrame frame = new JFrame();

        JPanel optionenPanel = new JPanel(new FlowLayout());
        JPanel panel = new JPanel(new FlowLayout());
        JPanel datenPanel = new JPanel(new GridLayout(5,2));

        panel.setBorder(BorderFactory.createMatteBorder(3,4,5,6,Color.BLACK));

        datenPanel.setBorder(BorderFactory.createTitledBorder("Daten"));
        datenPanel.add(new JLabel("Name: "));
        datenPanel.add(new TextField());
        datenPanel.add(new JLabel("Vorname: "));
        datenPanel.add(new TextField());
        datenPanel.add(new JLabel("Geburtsadatum: "));
        datenPanel.add(new TextField());
        datenPanel.add(new JLabel("Geburtsort: "));
        datenPanel.add(new TextField());
        datenPanel.add(new JLabel("Stimmung"));

        JPanel p2 = new JPanel(new GridLayout(3,1));
        JRadioButton b1 = new JRadioButton("Glücklich");
        p2.add(b1);
        JRadioButton b2 = new JRadioButton("Ganz Okay");
        p2.add(b2);
        JRadioButton b3 = new JRadioButton("Traurig", true);
        p2.add(b3);
        ButtonGroup opGroup = new ButtonGroup();
        opGroup.add(b1);
        opGroup.add(b2);
        opGroup.add(b3);
        datenPanel.add(p2);


        optionenPanel.add(new JButton("OK"));

        panel.add(datenPanel);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(optionenPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        UI ui = new UI();
    }
}

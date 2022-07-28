package Pogrammieren.Klausurvorbereitung.Probeklausur.SwingUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BizepsVergleich extends JFrame {
    public static final String ACTION_VERGLEICHEN = "VERGLEICHEN";
    public static final String ACTION_SCHLIESSEN = "SCHLIESSEN";

    private BizepsVergleich() {
        super("Bizeps Vergleich");
        this.setLayout(new GridLayout(2, 3));
        JLabel lblSpieler1 = new JLabel("Spieler 1");
        JLabel lblSpieler2 = new JLabel("Spieler 2");
        final JTextField tfSpieler1 = new JTextField("Murvin");
        tfSpieler1.setEnabled(false);
        final JTextField tfSpieler2 = new JTextField();
        Integer[] bWerte = {30, 32, 34, 36, 38, 40, 42, 44, 46, 48};
        final JComboBox bizepsBox1 = new JComboBox(bWerte);
        final JComboBox bizepsBox2 = new JComboBox(bWerte);

        ActionListener zuhoerer = (e) -> {
            if(e.getActionCommand().equals(ACTION_VERGLEICHEN)){
                if(bizepsBox1.getSelectedItem() == bizepsBox2.getSelectedItem()){
                    System.out.println(tfSpieler1.getText() + " und " + tfSpieler2.getText() + " müssen trainieren!");
                } else if(((Comparable)bizepsBox1.getSelectedItem()).compareTo(bizepsBox2.getSelectedItem()) > 0){
                    System.out.println(tfSpieler1.getText() + " ist der Babo!");
                } else {
                    System.out.println(tfSpieler2.getText() + " ist der Babo!");
                }
            } else {
                System.exit(0);
            }
        };


        JButton btnVergleichen = new JButton("Vergleichen");
        JButton btnSchliessen = new JButton("Schließen");
        btnVergleichen.setActionCommand(ACTION_VERGLEICHEN);
        btnSchliessen.setActionCommand(ACTION_SCHLIESSEN);
        btnVergleichen.addActionListener(zuhoerer);
        btnSchliessen.addActionListener(zuhoerer);

        this.add(lblSpieler1);
        this.add(tfSpieler1);
        this.add(bizepsBox1);
        this.add(btnVergleichen);
        this.add(lblSpieler2);
        this.add(tfSpieler2);
        this.add(bizepsBox2);
        this.add(btnSchliessen);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BizepsVergleich();
    }
}
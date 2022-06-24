package Pogrammieren.chapter10;

import javax.swing.*;

public class MyFirstUI {
    public static void main(String[] args) {
        JFrame myFirstUI = new JFrame("My First UI");

        //myFirstUI.setSize(200,400);
        //myFirstUI.setBounds();

        JLabel  myText = new JLabel("Hello World");
        JButton myButton = new JButton("Pause");

        myFirstUI.add(myText);
        myFirstUI.add(myButton);

        myFirstUI.pack(); // automatische Größe für alle Anordnungen
        myFirstUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFirstUI.setVisible(true);
    }
}

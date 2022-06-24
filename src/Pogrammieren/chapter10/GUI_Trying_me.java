package Pogrammieren.chapter10;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public class GUI_Trying_me extends JFrame{

    private GUI_Trying_me(){
        this.setTitle("Logon");

        this.setLayout(new BorderLayout());

        Border dateiBorder = BorderFactory.createTitledBorder("Dateien");
        Border verbindungsBorder = BorderFactory.createTitledBorder("Verbindung");
        Border berechtigunsBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

        JPanel berechtigungsPanel = new JPanel(new FlowLayout()); // BerechtigungsPanel
        berechtigungsPanel.setBorder(berechtigunsBorder);
        JPanel verbindungsPanel = new JPanel(new GridLayout(5,2)); // VerbindungsPanel
        verbindungsPanel.setBorder(verbindungsBorder);
        verbindungsPanel.add(new JLabel("User:"));
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userPanel.add(new JTextField(3));
        verbindungsPanel.add(userPanel);

        verbindungsPanel.add(new JLabel("Passwort:"));
        JPanel pwPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pwPanel.add(new JPasswordField(4));
        verbindungsPanel.add(pwPanel);

        verbindungsPanel.add(new JLabel("Art:"));
        JPanel artPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String auswahlJComboBox[] = {"FTP", "XYZ"};
        JComboBox myBox = new JComboBox(auswahlJComboBox);
        myBox.setSelectedItem("FTP");
        artPanel.add(myBox);
        verbindungsPanel.add(artPanel);

        verbindungsPanel.add(new JLabel("Host:"));
        JPanel hostPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hostPanel.add(new JTextField(4));
        verbindungsPanel.add(hostPanel);

        verbindungsPanel.add(new JLabel("Port:"));
        JPanel portPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        portPanel.add(new JTextField(1));
        verbindungsPanel.add(portPanel);

        JPanel dateiPanel = new JPanel(new GridLayout(3,2)); // DateiPanel
        dateiPanel.setBorder(dateiBorder);
        dateiPanel.add(new JLabel("Quelle:"));
        dateiPanel.add(new JTextField(10));
        dateiPanel.add(new JLabel("Ziel:"));
        dateiPanel.add(new JTextField(10));
        dateiPanel.add(new JLabel("Datum:"));
        try {
            MaskFormatter formatter = new MaskFormatter("####/##/##");
            dateiPanel.add(new JFormattedTextField(formatter));
        } catch (Exception e){
            System.out.println("Hier ist was schiefgelaufen");
        }

        berechtigungsPanel.add(verbindungsPanel);
        berechtigungsPanel.add(dateiPanel);

        JPanel bestätigungsPanel = new JPanel(new FlowLayout()); // BestätigungPanel
        JPanel okPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        okPanel.add(new JButton("OK"));
        bestätigungsPanel.add(okPanel);

        JPanel cancelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cancelPanel.add(new JButton("Cancel"));
        bestätigungsPanel.add(cancelPanel);



        this.add(berechtigungsPanel, BorderLayout.NORTH);
        this.add(bestätigungsPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI_Trying_me();
    }

}

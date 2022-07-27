package Pogrammieren.chapter10.UebungSkript;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aufgabe_MeldeamtUI extends JFrame {
    String[] anredeAuswahl = {"Frau", "Herr", "..."};
    Listenoperationen listenoperationen = new Listenoperationen();
    private static final String ACTION_COMMAND_DEFAULT_SCREEN = "Vergrößern";
    private static final String ACTION_COMMAND_SECOND_SCREEN = "Verkleinern";

    GraphicsDevice defaultScreenDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    GraphicsEnvironment virtualGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] screens = virtualGraphicsEnvironment.getScreenDevices();

    private Aufgabe_MeldeamtUI(){
        this.setTitle("Einwohnermeldeamt");

        JPanel panel_north = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel_center = new JPanel(new FlowLayout());
        JPanel panel_south = new JPanel(new FlowLayout());

        JPanel kontaktdaten_panel = new JPanel(new GridLayout(5,2));
        JPanel familienstand_panel = new JPanel(new GridLayout(4,1));

        Border central_border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        Border kontaktdaten_border = BorderFactory.createTitledBorder("Kontaktdaten");
        Border familienstand_border = BorderFactory.createTitledBorder("Familienstand");

        panel_center.setBorder(central_border);
        kontaktdaten_panel.setBorder(kontaktdaten_border);
        familienstand_panel.setBorder(familienstand_border);

        //Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fensterMenu = new JMenu("Fenster");
        JMenuItem vergroessernMenuItem = new JMenuItem(ACTION_COMMAND_DEFAULT_SCREEN);
        vergroessernMenuItem.setActionCommand(ACTION_COMMAND_DEFAULT_SCREEN);
        JMenuItem verkleinernMenuItem = new JMenuItem(ACTION_COMMAND_SECOND_SCREEN);
        verkleinernMenuItem.setActionCommand(ACTION_COMMAND_SECOND_SCREEN);

        //North Panel
        JLabel nachrichtenLabel = new JLabel("");

        //Central Panel
        JLabel anredenLabel = new JLabel("Anrede:");
        /*anredenLabel.setSize(200, 400);*/
        JComboBox<String> anrede_ComboBox = new JComboBox<String>(anredeAuswahl);
        anrede_ComboBox.setSelectedItem("---");

        JLabel namenLabel = new JLabel("Name:");
        JTextField namenTextField = new JTextField();

        JLabel vornamenLabel = new JLabel("Vorname:");
        JTextField vornamenTextField = new JTextField();

        JLabel geburtsnamenLabel = new JLabel("Geburtsname: ");
        JTextField gebNameTextField = new JTextField();

        JLabel emailLabel = new JLabel("E-Mail:");
        JTextField emailTextField = new JTextField();

        ButtonGroup familienstand_Button_Group = new ButtonGroup();
        JRadioButton ledig_Button = new JRadioButton("ledig");
        ledig_Button.setActionCommand("ledig");
        JRadioButton verheiratet_Button = new JRadioButton("verheiratet");
        ledig_Button.setActionCommand("verheiratet");
        JRadioButton verwittwet_Button = new JRadioButton("verwitwet");
        ledig_Button.setActionCommand("verwitwet");
        JRadioButton geschieden_Button = new JRadioButton("geschieden");
        ledig_Button.setActionCommand("geschieden");
        familienstand_Button_Group.add(ledig_Button);
        familienstand_Button_Group.add(verheiratet_Button);
        familienstand_Button_Group.add(verwittwet_Button);
        familienstand_Button_Group.add(geschieden_Button);

        //South-Panel
        JButton hinzufuegenJButton =  new JButton("Hinzufügen");
        JButton anzeigenJButton =new JButton("Anzeigen");
        JButton suchenJButton = new JButton("Suchen");
        JButton loeschenJButton = new JButton("Löschen");
        JButton listeAnzeigenJButton = new JButton("Liste anzeigen");


        //Listener
        ActionListener ledigActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gebNameTextField.setText("");
                geburtsnamenLabel.setVisible(false);
                gebNameTextField.setVisible(false);
            }
        };

        ActionListener verheiratetActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                geburtsnamenLabel.setVisible(true);
                gebNameTextField.setVisible(true);
            }
        };

        ActionListener verwitwetActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                geburtsnamenLabel.setVisible(true);
                gebNameTextField.setVisible(true);
            }
        };

        ActionListener geschiedenActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                geburtsnamenLabel.setVisible(true);
                gebNameTextField.setVisible(true);
            }
        };

        ActionListener hinzufuegenActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = namenTextField.getText();
                String vorname = vornamenTextField.getText();
                String geburtsname = gebNameTextField.getText();
                String eMail = emailTextField.getText();
                String anrede = anrede_ComboBox.getSelectedItem().toString();
                String familienstand = familienstand_Button_Group.getSelection().getActionCommand();// <-- noch nicht
                ButtonModel button = familienstand_Button_Group.getSelection();//------------------------------------------?
                System.out.println(button);
                System.out.println(anrede + " " + vorname + " " + name + " " + " geb. " + geburtsname + ", Familienstand: " + familienstand + ", EMail: " + eMail);
                if(listenoperationen.hinzufuegen(anrede, name, vorname, geburtsname, eMail, familienstand)){
                    nachrichtenLabel.setText("Einwohner hinzugefügt");
                } else {
                    nachrichtenLabel.setText("Einwohner existiert schon");
                }
            }
        };

        ActionListener anzeigenActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = namenTextField.getText();
                String vorname = vornamenTextField.getText();
                if(listenoperationen.anzeigen(name, vorname)){
                    nachrichtenLabel.setText("Einwohner existiert");
                } else {
                    nachrichtenLabel.setText("Einwohner existiert nicht");
                }
            }
        };

        ActionListener suchenActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = namenTextField.getText();
                String vorname = vornamenTextField.getText();
                if(listenoperationen.suchen(name, vorname)) {
                    nachrichtenLabel.setText("Einwohner wurde gefunden");
                } else {
                    nachrichtenLabel.setText("Einwohner wurde nicht gefunden");
                }
            }
        };

        ActionListener loeschenActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = namenTextField.getText();
                String vorname = vornamenTextField.getText();
                if(listenoperationen.loeschen(name, vorname)) {
                    nachrichtenLabel.setText("Einwohner wurde entfernt");
                } else {
                    nachrichtenLabel.setText("Einwohner konnte nicht entfernt werden");
                }
            }
        };

        ActionListener listeAnzeigenActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listenoperationen.listeAusgeben();
            }
        };

        ActionListener fensterActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ////for (Frame f: frames) {
                    if (e.getActionCommand().equals(ACTION_COMMAND_DEFAULT_SCREEN)) {
                        //moveFrameToDefaultScreen();
                        System.out.println("größer");
                    } else if (e.getActionCommand().equals(ACTION_COMMAND_SECOND_SCREEN)) {
                        System.out.println("kleiner");
                    }
               // }
            }
        };

        //Add Action Listener
        ledig_Button.addActionListener(ledigActionListener);
        verheiratet_Button.addActionListener(verheiratetActionListener);
        verwittwet_Button.addActionListener(verwitwetActionListener);
        geschieden_Button.addActionListener(geschiedenActionListener);

        hinzufuegenJButton.addActionListener(hinzufuegenActionListener);
        anzeigenJButton.addActionListener(anzeigenActionListener);
        suchenJButton.addActionListener(suchenActionListener);
        loeschenJButton.addActionListener(loeschenActionListener);
        listeAnzeigenJButton.addActionListener(listeAnzeigenActionListener);

        vergroessernMenuItem.addActionListener(fensterActionListener);
        verkleinernMenuItem.addActionListener(fensterActionListener);

        // Add Components to Panels
        fensterMenu.add(vergroessernMenuItem);
        fensterMenu.add(verkleinernMenuItem);
        menuBar.add(fensterMenu);

        kontaktdaten_panel.add(anredenLabel);
        kontaktdaten_panel.add(anrede_ComboBox);
        kontaktdaten_panel.add(namenLabel);
        kontaktdaten_panel.add(namenTextField);
        kontaktdaten_panel.add(vornamenLabel);
        kontaktdaten_panel.add(vornamenTextField);
        kontaktdaten_panel.add(geburtsnamenLabel);
        kontaktdaten_panel.add(gebNameTextField);
        kontaktdaten_panel.add(emailLabel);
        kontaktdaten_panel.add(emailTextField);

        familienstand_panel.add(ledig_Button);
        familienstand_panel.add(verheiratet_Button);
        familienstand_panel.add(verwittwet_Button);
        familienstand_panel.add(geschieden_Button);

        panel_south.add(hinzufuegenJButton);
        panel_south.add(anzeigenJButton);
        panel_south.add(suchenJButton);
        panel_south.add(loeschenJButton);
        panel_south.add(listeAnzeigenJButton);

        panel_center.add(kontaktdaten_panel);
        panel_center.add(familienstand_panel);

        panel_north.add(nachrichtenLabel, FlowLayout.LEFT);

       /* JPanel panel = new JPanel();
        panel.add(new JButton("center"), BorderLayout.CENTER);
        panel.add(new JButton("left"), BorderLayout.WEST);
        this.add(panel, BorderLayout.EAST);*/

        this.setJMenuBar(menuBar);
        this.add(panel_north, BorderLayout.NORTH);
        this.add(panel_center, BorderLayout.CENTER);
        this.add(panel_south, BorderLayout.SOUTH);


        //Frame Configurations
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Aufgabe_MeldeamtUI();
    }

    private static void moveFrameToDefaultScreen(JFrame jFrame){

    }
}

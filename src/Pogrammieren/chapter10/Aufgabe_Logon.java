package Pogrammieren.chapter10;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

public class Aufgabe_Logon extends JFrame{

    public final String ACTION_COMMAND_PRINT = "ACTION_COMMAND_PRINT";
    public final String ACTION_COMMAND_CLOSE = "ACTION_COMMAND_CLOSE";

    private Aufgabe_Logon() throws ParseException{

        this.setTitle("Logon");
        this.setLayout(new BorderLayout());

        Border dateiBorder = BorderFactory.createTitledBorder("Dateien");
        Border verbindungsBorder = BorderFactory.createTitledBorder("Verbindung");
        Border berechtigunsBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

        JPanel berechtigungsPanel = new JPanel(new FlowLayout());                                                        // BerechtigungsPanel
        berechtigungsPanel.setBorder(berechtigunsBorder);
        JPanel verbindungsPanel = new JPanel(new GridLayout(5,2));                                             // VerbindungsPanel
        verbindungsPanel.setBorder(verbindungsBorder);

        verbindungsPanel.add(new JLabel("User:"));
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userPanel.add(new JTextField(3));
        verbindungsPanel.add(userPanel);

        verbindungsPanel.add(new JLabel("Passwort:"));
        JPanel pwPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // *Referenzvariable des Panels von User kann auch weiterverwendet werden
        pwPanel.add(new JPasswordField(4));
        verbindungsPanel.add(pwPanel);

        verbindungsPanel.add(new JLabel("Art:"));
        JPanel artPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final String auswahlJComboBox[] = {"FTP", "Telnet", "SMTP"};
        JComboBox<String> myBox = new JComboBox<>(auswahlJComboBox);
        myBox.setSelectedItem("FTP");
        myBox.addItem("HTTP");

        artPanel.add(myBox);
        verbindungsPanel.add(artPanel);

        verbindungsPanel.add(new JLabel("Host:"));
        JPanel hostPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        hostPanel.add(new JTextField(4));
        verbindungsPanel.add(hostPanel);

        verbindungsPanel.add(new JLabel("Port:"));
        JPanel portPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JFormattedTextField port = new JFormattedTextField(new MaskFormatter("#####"));
        portPanel.add(port);


        myBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Item Event - Item: " + e.getItem());
                System.out.println("Item Event - ParameterString: " + e.paramString());
                System.out.println("Item Event - StateChange: " + e.getStateChange());

                if(e.getStateChange() == ItemEvent.SELECTED){
                    JComboBox<String> sourceComboBox = (JComboBox<String>) e.getSource();
                    String selectedItem = (String)sourceComboBox.getSelectedItem();
                    System.out.println("Aktuell selektiert: " + selectedItem);


                    if (e.getItem().equals("FTP")){
                        port.setText("21");
                    } else if(e.getItem().equals("HTTP")){
                        port.setText("80");
                        sourceComboBox.addItem("HTTPS");
                    } else {
                        port.setText("");
                    }
                }
            }
        });

        //portPanel.add(new JTextField(1));
        verbindungsPanel.add(portPanel);

        JPanel dateiPanel = new JPanel(new GridLayout(2,2));                                                   // DateiPanel
        dateiPanel.setBorder(dateiBorder);
        dateiPanel.add(new JLabel("Quelle:"));
        JPanel quellPanel = new JPanel(new FlowLayout());
        quellPanel.add(new JTextField(10));
        dateiPanel.add(quellPanel);
        dateiPanel.add(new JLabel("Ziel:"));
        JPanel zielPanel = new JPanel(new FlowLayout());
        zielPanel.add(new JTextField(10));
        dateiPanel.add(zielPanel);

        berechtigungsPanel.add(verbindungsPanel);
        berechtigungsPanel.add(dateiPanel);

        JPanel bestätigungsPanel = new JPanel(new FlowLayout());                                                         // BestätigungPanel
        JPanel okPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton okButton = new JButton("Ok");
        okButton.setActionCommand(ACTION_COMMAND_PRINT);
        okPanel.add(okButton);

        JPanel cancelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand(ACTION_COMMAND_CLOSE);

        cancelPanel.add(cancelButton);

        ActionListener buttonListener = e -> {
            System.out.println("ActionEvent - Action: " + e.getActionCommand());
            System.out.println("ActionEvent - Parameter: " + e.paramString());
            System.out.println("ActionEvent - Modifierers: " + e.getModifiers()); //Modifiziert Knopfdruck (Ctrl+Button1)
            System.out.println("ActionEvent - when: " + e.getWhen());

            //if(e.getSource() == okButton ) { // || e.getSource() == okMenuBarItem
            if(e.getActionCommand().equals(ACTION_COMMAND_PRINT)){
                System.out.println("Protokoll " + myBox.getSelectedItem() + " - Port: " + port.getText());
            } else if(e.getActionCommand().equals(ACTION_COMMAND_CLOSE)){
                System.out.println("Programm wird geschlossen");
                System.exit(0);
            }
        };

        MouseListener myMouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Exit Component with Mouse " );
                if(e.getSource() instanceof JButton){
                    ((JButton) e.getSource()).setEnabled(true);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Enter Component with Mouse " ); // + e.getSource()
                System.out.println("Koordinaten: " + e.getPoint());
                if(e.getSource() instanceof JButton){
                    ((JButton) e.getSource()).setEnabled(true);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Exit Component with Mouse " ); // + e.getSource()
                System.out.println("Koordinaten: " + e.getPoint());
                if(e.getSource() instanceof JButton){
                    ((JButton) e.getSource()).setEnabled(true);
                }
            }
        };

        okButton.addMouseListener(myMouseListener);
        cancelButton.addMouseListener(myMouseListener);

        okButton.addActionListener(buttonListener);
        cancelButton.addActionListener(buttonListener);

        bestätigungsPanel.add(okPanel);
        bestätigungsPanel.add(cancelPanel);

        this.add(berechtigungsPanel, BorderLayout.NORTH);
        this.add(bestätigungsPanel, BorderLayout.SOUTH);

        JMenuBar myMenuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Datei");

        JMenuItem okMenuItem = new JMenuItem("OK");
        okMenuItem.setActionCommand(ACTION_COMMAND_PRINT);
        okMenuItem.addActionListener(buttonListener);
        JMenuItem cancelMenuItem = new JMenuItem("cancel");
        cancelMenuItem.setActionCommand(ACTION_COMMAND_CLOSE);
        cancelMenuItem.addActionListener(buttonListener);

        fileMenu.add(okMenuItem);
        fileMenu.add(cancelMenuItem);

        myMenuBar.add(fileMenu);

        this.setJMenuBar(myMenuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,350);
        this.setVisible(true);
    }

    public static void main(String[] args) throws ParseException {
        GraphicsDevice defaultScreenDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        System.out.println("Screen Dimensions: " + defaultScreenDevice.getDefaultConfiguration().getBounds().getWidth() + " : " + defaultScreenDevice.getDefaultConfiguration().getBounds().getHeight());

        GraphicsEnvironment virtualGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = virtualGraphicsEnvironment.getScreenDevices();

        for(GraphicsDevice screen : screens){
            System.out.println(screen);
            // ...
        }

        new Aufgabe_Logon();
    }

}

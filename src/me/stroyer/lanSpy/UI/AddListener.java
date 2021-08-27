package me.stroyer.lanSpy.UI;

import me.stroyer.lanSpy.Listeners.lanListener;
import me.stroyer.lanSpy.Methods.ConfirmBox;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener {

    public static JFrame frame = new JFrame("LAN Spy ~ Strpuer");

    public static void open(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(820, 300);
        frame.setLayout(new GridLayout(1, 80));

        JPanel top = new JPanel();


        String description = "Creating a new Network Listener allows you to monitor and listen for discrete packages amongst the network.";
        JLabel desc = new JLabel();
        JLabel listenerInt = new JLabel("ID: ");
        JTextField listenerName = new JTextField("Listener Nickname",1 );
        desc.setText("<html><div style='width: %dpx'><h1>LAN Spy</h1><p>Creating a new Network Listener allows you to monitor and listen for discrete packages amongst the network.</p><br/><br/><br/></div></html>");

        top.add(desc, Component.TOP_ALIGNMENT);

        JPanel middle = new JPanel();

        String[] listenerTypes = new String[5];
        listenerTypes[4] = "IPv6"; listenerTypes[1] = "DNS"; listenerTypes[2] = "Domain"; listenerTypes[3] = "Subnet Gateway"; listenerTypes[0] = "-- Select a listener channel --";
        JComboBox<String> listenerType = new JComboBox<String>(listenerTypes);
        JLabel listenerOptions = new JLabel("Listening Channel: ");

        JButton saveButton = new JButton("Save");

//        middle.add(listenerInt);
//        middle.add(listenerName);
//        middle.add(new JSeparator(SwingConstants.VERTICAL));
//
//        top.add(new JSeparator(SwingConstants.VERTICAL));
//        top.add(listenerInt);
//        top.add(new JSeparator(SwingConstants.VERTICAL));
//        top.add(listenerName);

//        frame.getContentPane().add(top, BorderLayout.NORTH);
//        frame.getContentPane().add(middle, BorderLayout.CENTER);
//        frame.add(top, "1");
//        frame.add(middle, "8");

        JButton close = new JButton("Cancel");
        JButton back = new JButton("Back");

        frame.add(desc, "1");
//
        frame.add(listenerInt, "8");
        frame.add(listenerName, "9");
        frame.add(listenerOptions, "10");
        frame.add(listenerType, "10");
        frame.add(saveButton, "12");


        frame.add(close, "23");
        frame.add(back, "24");

        frame.pack();
        frame.setVisible(true);


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listenerType.getSelectedIndex() != 0) {
                    //ConfirmBox.open();

                    String nick = listenerName.getText();
                    int id = 1;
                    int type = listenerType.getSelectedIndex();
                    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure?");

                    if(confirmation == 0){
                        Alert.infoBox("Generating ...");
                        lanListener newListener = new lanListener(id, nick, type);
                        Alert.infoBox("Succesfully generated LAN Listener [Internal ID: " + newListener.id + " // Nickname: "+newListener.name+" // Channel: "+newListener.channel+" (integer "+type+")"+"]");
                    }
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


    }

}

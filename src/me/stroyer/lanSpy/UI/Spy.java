package me.stroyer.lanSpy.UI;

import me.stroyer.lanSpy.Listeners.DisplayTable;
import me.stroyer.lanSpy.Listeners.listenerStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spy {
    public static void open(){
        JFrame frame = new JFrame("LAN Spy: " + InitialiseUI.profileType);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);

        JPanel top = new JPanel();

        JButton newListener = new JButton("New Network Listener");
        JButton viewListeners = new JButton("View existing listeners");

        top.add(newListener, Component.LEFT_ALIGNMENT);

        frame.getContentPane().add(top, BorderLayout.PAGE_START);
        frame.add(viewListeners);
        frame.setVisible(true);

        newListener.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                AddListener.open();

            }

        });

        viewListeners.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DisplayTable.generateTable();

                //String i = JOptionPane.showInputDialog("Enter the numerical ID of the listener to view (between 0 and "+ (listenerStorage.listeners.size()-1)+" .");
            }
        });
    }
}

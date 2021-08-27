package me.stroyer.lanSpy.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spy {
    public static void open(){
        JFrame frame = new JFrame("LAN Spy ~ Stroyer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);

        JPanel top = new JPanel();

        JButton newListener = new JButton("New Network Listener");

        top.add(newListener, Component.LEFT_ALIGNMENT);

        frame.getContentPane().add(top, BorderLayout.PAGE_START);
        frame.setVisible(true);

        newListener.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                AddListener.open();

            }

        });
    }
}

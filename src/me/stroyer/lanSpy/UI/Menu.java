package me.stroyer.lanSpy.UI;

import me.stroyer.lanSpy.Methods.Authentication.AttemptLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    public static void open(){
        JFrame frame = new JFrame("LAN Spy: " + InitialiseUI.profileType);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        JLabel title = new JLabel("LAN Spy by Stroyer");
        title.setFont(new Font("Verdana", Font.PLAIN, 18));
        JButton closeWindow = new JButton("Close");
        JPanel login = new JPanel();
        JLabel spyListenersLabel = new JLabel("Spy");
        login.add(spyListenersLabel, BorderLayout.PAGE_START);
        JButton openListenerList = new JButton("Open Listeners");
        login.add(openListenerList, BorderLayout.PAGE_END);
        JButton openLoggerOnline = new JButton("Open online logger (LINKSYS [OPTUS])");

        frame.getContentPane().add(openLoggerOnline, BorderLayout.PAGE_START);
        frame.getContentPane().add(closeWindow, BorderLayout.AFTER_LAST_LINE); // Adds Button to content pane of frame
        frame.getContentPane().add(login, BorderLayout.CENTER);
        frame.setVisible(true);

        closeWindow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();

            }
        });

        openListenerList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Spy.open();

            }
        });
    }

}

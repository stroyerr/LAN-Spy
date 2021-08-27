package me.stroyer.lanSpy.Methods;

import me.stroyer.lanSpy.UI.AddListener;
import me.stroyer.lanSpy.UI.Alert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmBox {

    private boolean confirmed = false;

    public static void open(){

        JFrame frame = new JFrame("Confirmation Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(240, 150);
        frame.setLayout(new GridLayout());

        JPanel top = new JPanel();

        JButton newListener = new JButton("New Network Listener");


        JTextArea input = new JTextArea("",1,  7);
        JButton confirm = new JButton("Type 'Confirm'");

        //frame.getContentPane().add(top, BorderLayout.PAGE_START);
        frame.getContentPane().add(input);
        frame.getContentPane().add(confirm);

        frame.setVisible(true);


        final Boolean[] confirmation = {false};
        confirmation[0] = null;

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dialogue = input.getText();
                if (dialogue.equals("Confirm")){
                    Alert.infoBox("Confirmed.");
                    confirmation[0] = true;
                    frame.dispose();
                }else{
                    Alert.infoBox("Confirmation failed. Try again or cancel.");
                    confirmation[0] = false;
                    AddListener.frame.dispose();
                    frame.dispose();
                }
            }


        });

    }



}

package me.stroyer.lanSpy.Methods;

import javax.swing.*;
import java.awt.*;

public class ConfirmBox {
    public static void open(){

        JFrame frame = new JFrame("Confirmation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200  , 80);
        frame.setLayout(new GridLayout(1, 3));

        JLabel text = new JLabel("<html><p>If you are certain you want to complete this action, enter 'Confirm' in the box and then press the Confirm button.</p></html>");
        JTextArea input = new JTextArea();
        JButton confirm = new JButton("Confirm");

        frame.add(text, 1);
        frame.add(input, 2);
        frame.add(confirm, 3);

        frame.setVisible(true);

    }



}

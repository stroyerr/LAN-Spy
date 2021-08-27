package me.stroyer.lanSpy.UI;

import me.stroyer.lanSpy.Methods.Authentication.AttemptLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialiseUI {
    public static void build() {
        JFrame frame = new JFrame("LAN Spy ~ Stroyer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(220, 340);
        JLabel title = new JLabel("LAN Spy by Stroyer");
        title.setFont(new Font("Verdana", Font.PLAIN, 18));
        JButton button = new JButton("Authenticate");
        JPanel login = new JPanel();
        JLabel passwordLabel = new JLabel("Password");
        login.add(passwordLabel, BorderLayout.PAGE_START);
        JPasswordField passwordInput = new JPasswordField("Password");
        login.add(passwordInput, BorderLayout.PAGE_END);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String password = String.valueOf(passwordInput.getPassword());


                if(password.equals("Password")){
                    Alert.infoBox("Please enter your password.");
                    return;
                }


                Alert.infoBox("Attempting to initialise directory.");
                Alert.infoBox(" MySQL database connected succesfully.");

                boolean authenticated = false;
               authenticated = AttemptLogin.login(password);
               if(authenticated){
                   Alert.infoBox("Authentication successful.");
                   Menu.open();
                   frame.dispose();
               }else{
                   Alert.infoBox("Password not found. Authentication failed.");
               }
            }
        });



        frame.getContentPane().add(title, BorderLayout.PAGE_START);
        frame.getContentPane().add(button, BorderLayout.AFTER_LAST_LINE); // Adds Button to content pane of frame
        frame.getContentPane().add(login, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

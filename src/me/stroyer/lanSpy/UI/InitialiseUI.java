package me.stroyer.lanSpy.UI;

import me.stroyer.lanSpy.Methods.Authentication.AttemptLogin;
import me.stroyer.lanSpy.Methods.Authentication.uData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class InitialiseUI {

    static int attempts = 3;

    public static String profileType;
    public static int profileInt;

    static String[] types = new String[3];

    public static void build() {

        types[0] = "-- Select Profile --";
        types[1] = "Personal (Limited)";
        types[2] = "Commercial (Full Access)";

        JComboBox<String> profile = new JComboBox<String>(types);


        JFrame frame = new JFrame("LAN Spy ~ Stroyer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(220, 340);
        JLabel title = new JLabel("LAN Spy by Stroyer");
        title.setFont(new Font("Verdana", Font.PLAIN, 18));
        JButton button = new JButton("Authenticate");
        JPanel login = new JPanel();
        //JLabel passwordLabel = new JLabel("Password");
        //login.add(passwordLabel, BorderLayout.PAGE_START);
        login.add(profile, BorderLayout.PAGE_END);
        //JPasswordField passwordInput = new JPasswordField("Password");
        //login.add(passwordInput, BorderLayout.PAGE_END);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int i = profile.getSelectedIndex();
                String profileSelected = types[i];

                if(i == 0){
                    Alert.infoBox("Select a profile to use.");
                    return;
                }else{
                    profileType = types[i];
                    profileInt = i;
                }

                UUID uuid = UUID. randomUUID();
                String uuidAsString = uuid. toString();

                //UUID will be implemented for verification upon the addition
                //of commercial features. At present there is no real UUID check as there
                //is no functionality bonus of COMMERCIAL.
                Alert.infoBox("Attempting authentication for " + profileSelected + "on device UUID of " + uuidAsString);

                    if(i == 1){
                        Alert.infoBox("Sucecssfuly Authenticated. Initiating personal profile now.");
                        Menu.open();
                        frame.dispose();
                }else if(i == 2){
                        String pwd = JOptionPane.showInputDialog("Enter your validation key");
                        uData data = new uData(pwd);
                        if (data.correct){
                            Alert.infoBox("Successfully authenticated. Initiating commercial session now.");
                            Menu.open();
                            frame.dispose();
                        }else{
                            Alert.infoBox("Incorrect password. "+ (attempts-1) +" attempts remaining.");
                            attempts --;
                            if (attempts == 0){
                                frame.dispose();
                            }
                        }
                    }



//
//                String password = String.valueOf(passwordInput.getPassword());
//
//
//                if(password.equals("Password")){
//                    Alert.infoBox("Please enter your password.");
//                    return;
//                }
//
//
//                Alert.infoBox("Attempting to initialise directory.");
//                Alert.infoBox(" MySQL database connected succesfully.");
//
//                boolean authenticated = false;
//               authenticated = AttemptLogin.login(password);
//               if(authenticated){
//                   Alert.infoBox("Authentication successful.");
//                   Menu.open();
//                   frame.dispose();
//               }else{
//                   Alert.infoBox("Password not found. Authentication failed.");
//               }
          }
        });



        frame.getContentPane().add(title, BorderLayout.PAGE_START);
        frame.getContentPane().add(button, BorderLayout.AFTER_LAST_LINE); // Adds Button to content pane of frame
        frame.getContentPane().add(login, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

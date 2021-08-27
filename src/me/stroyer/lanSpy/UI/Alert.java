package me.stroyer.lanSpy.UI;

import javax.swing.*;

public class Alert {
    public static void infoBox(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "LAN Spy", JOptionPane.INFORMATION_MESSAGE);
    }
}

package me.stroyer.lanSpy.Listeners;

import javax.swing.*;
import java.awt.*;

public class DisplayTable {

    static String[] colNames = new String[3];
    static Object[][] data = {
            {"test ID", "test nickname", "test channel"}
    };

    public static void generateTable(){
        JTable table = new JTable(data, colNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JFrame frame = new JFrame();
        frame.add(scrollPane);

        frame.pack();
        frame.setVisible(true);
    }

}

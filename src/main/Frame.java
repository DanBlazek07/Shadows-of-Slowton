package main;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {
        Panel panel = new Panel();
        setTitle("Shadows of Slowton");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        panel.setItemsOnScreen();
        panel.setNPCOnScreen();
        panel.setEnemyOnScreen();
        panel.start();
    }
}

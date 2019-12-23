package com.khpi;

import javax.swing.*;

public class newframe extends JFrame {

    public static void main(String[] args) {
        newframe frameTabel = new newframe();
    }

    JLabel welcome = new JLabel("Welcome to LingvistInterface");
    JPanel panel = new JPanel();

    newframe() {
        setSize(3000, 300);
        setLocation(500, 800);
        panel.setLayout(null);

        welcome.setBounds(70, 50, 150, 100);

        panel.add(welcome);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}

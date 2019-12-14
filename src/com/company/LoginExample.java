package com.company;

import javax.swing.*;

import java.awt.event.*;

public class LoginExample extends JFrame {

    public static void main(String[] args) {
        LoginExample frame = new LoginExample();
    }

    JButton button = new JButton("Submit");
    JPanel panel = new JPanel();
    JTextField textField = new JTextField(15);
    JPasswordField jPasswordField = new JPasswordField(15);
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    LoginExample() {

        super("Autentification");
        label.setText("Username:");
        label2.setText("Password:");

        setSize(300, 200);
        setLocation(500, 280);
        panel.setLayout(null);



        label.setBounds(10, 30, 100, 20);
        label2.setBounds(10,65,  100,  20);
        textField.setBounds(80, 30, 150, 20);
        jPasswordField.setBounds(80, 65, 150, 20);
        button.setBounds(110, 100, 100, 40);



        panel.add(label);
        panel.add(label2);
        panel.add(button);
        panel.add(textField);
        panel.add(jPasswordField);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        actionlogin();
    }

    public void actionlogin() {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name = textField.getText();
                String pwd = jPasswordField.getText();
                if (name.equals("anna") && pwd.equals("anna")) {
                    newframe regFace = new newframe();
                    regFace.setVisible(true);
                    dispose();
                } else {

                    JOptionPane.showMessageDialog(null,
                            "Wrong Password / Username");
                    textField.setText("");
                    jPasswordField.setText("");
                    textField.requestFocus();
                }

            }
        });
    }
}

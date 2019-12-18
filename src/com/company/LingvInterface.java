package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class LingvInterface {
    private JTextField Input;
    private JButton ClickMe;
    private JPanel MyPanel;
    private JLabel Result;
    private JLabel filename;
    private Object Lingvist;


    public LingvInterface() {
        ClickMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                Result.setText(Input.getText());
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    filename.setText("/home/anna/IdeaProjects/GOST/61876-71t1.csv");
                }


            }
        });
    }

//    public static void main( String[] args ) {
//        JFrame LingvistFrame = new JFrame("LingvistInterface");
//        LingvistFrame.setContentPane(new LingvInterfice().MyPanel);
//        LingvistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        LingvistFrame.pack();
//        LingvistFrame.setVisible(true);
//    }

    public static void showLingvistForm() {
        JFrame LingvistFrame = new JFrame("LingvistInterface");
        LingvistFrame.setContentPane(new LingvInterface().MyPanel);
        LingvistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LingvistFrame.pack();
        LingvistFrame.setVisible(true);
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MyPanel = new JPanel();
        MyPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        ClickMe = new JButton();
        ClickMe.setText("Выбрать таблицу из файла");
        MyPanel.add(ClickMe, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Result = new JLabel();
        Result.setText("Result");
        MyPanel.add(Result, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        filename = new JLabel();
        filename.setText("");
        MyPanel.add(filename, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Input = new JTextField();
        Input.setText("Введите текст для транслитерации");
        MyPanel.add(Input, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(2, 2), new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MyPanel;
    }

}
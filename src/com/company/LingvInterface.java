package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;
import java.lang.*;

public class LingvInterface {
    private static final Map<String, String> list = new HashMap<String, String>();

    private JTextField Input;
    private JButton ClickMe;
    private JPanel MyPanel;
    private JLabel Result;
    private JLabel filename;
    private JLabel charset;
    private Object Lingvist;


    public LingvInterface() {
        ClickMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
//                    filename.setText(file.getName());
                    String csvFilepath = file.getPath();
                    filename.setText(csvFilepath);


                    String line = "";
                    String cvsSplitBy = ",";
                    HashMap<String, String> list = new HashMap<>();
                    try (BufferedReader br = new BufferedReader(new FileReader(csvFilepath))) {
                        while ((line = br.readLine()) != null) {
                            // use comma as separator
                            String[] country = line.split(cvsSplitBy);
                            //System.out.println(country[0] +"  "  + country[1]);
                            list.put(country[0], country[1]);
                        }

                    } catch (IOException err) {
                        err.printStackTrace();
                    }
                }
//                Result.setText(Input.getText());
                String textForTranslit = Input.getText();
                String[] words = textForTranslit.split("\\s");
                String regex = "[а-яёА-ЯЁ]+";
                Pattern pattern = Pattern.compile(regex);
                Matcher m = pattern.matcher(textForTranslit);
                if (m.find()) {
                    charset.setText("Исходный набор символов: кириллический");
                    for (String sub1Text : words) {
                        if ((sub1Text).charAt(0) > 'А' && (sub1Text.charAt(0) < 'Я')) {
                            //need to translit kirill->latin

                            StringBuilder sb = new StringBuilder(textForTranslit.length());
                            for (int i = 0; i < textForTranslit.length(); i++) {
                                String l = textForTranslit.substring(i, i + 1);
                                if (list.containsKey(textForTranslit)) {
                                    sb.append(list.get(textForTranslit));

                                }
                            }


                        }
                    }
                } else {
                    charset.setText("Исходный набор символов: латиница");
                    for (String sub2Text : words) {
                        if ((sub2Text).charAt(0) > 'A' && (sub2Text.charAt(0) < 'Z')) {
                            //need to translit latin->kirill

                            StringBuilder sc = new StringBuilder(textForTranslit.length());
                            for (int i = 0; i < textForTranslit.length(); i++) {
                                String l = textForTranslit.substring(i, i + 1);
                                if (list.containsKey(textForTranslit)) {
                                    sc.append(list.get(textForTranslit));

                                } else {
                                    sc.append(textForTranslit);
                                }
                            }
                        }
                    }

                }
            }
        });
    }

    public static void main( String[] args ) {
        JFrame LingvistFrame = new JFrame("LingvistInterface");
        LingvistFrame.setContentPane(new LingvInterface().MyPanel);
        LingvistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LingvistFrame.pack();
        LingvistFrame.setVisible(true);
    }

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
        MyPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        MyPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        ClickMe = new JButton();
        ClickMe.setText("Выбрать файл таблицы транслитерации");
        ClickMe.setToolTipText("Нажмите, чтобы выбрать файл");
        MyPanel.add(ClickMe, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 3, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(30, 20), null, 0, false));
        Result = new JLabel();
        Result.setText("Result");
        MyPanel.add(Result, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Input = new JTextField();
        Input.setText("");
        MyPanel.add(Input, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(2, 2), new Dimension(200, 20), null, 0, false));
        charset = new JLabel();
        charset.setText("Исходный набор символов:");
        MyPanel.add(charset, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        filename = new JLabel();
        filename.setHorizontalAlignment(2);
        filename.setText("Текущий путь к файлу транслитерации");
        MyPanel.add(filename, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MyPanel;
    }
}

/**
     * @noinspection ALL
     */
   /* public JComponent $$$getRootComponent$$$() {
        return MyPanel;
    }

    public static String CombingWordsInSentence( String[] words ) {
        String res;
        String[] words1 = new String[];
        for (int i = 0; i < words.length; i++) {

            String result = words[i];

            res = result+i;
            break;
        }


        return res;
    }

}*/

package com.khpi;
import java.util.regex.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class CSVtoMap {

    public static void main( String[] args ) throws Exception {
//        String srcText = "my name Anet Goncharova from Kharkov city";
        String srcText = "меня зовут Анна Гочарова и я из города Харькова";
        HashMap<String, String> map = new HashMap<String, String>();


        String line = "";
        String cvsSplitBy = ",";
        HashMap<String, String> translitmap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/anna/GOST_Translit/61876-71t1.csv"))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] trans = line.split(cvsSplitBy);
                System.out.println(trans[0] + "  " + trans[1]);
                translitmap.put(trans[0], trans[1]);
            }

            printValues(translitmap);
            Translit(srcText);
        }
    }

    private static void printValues( HashMap<String, String> map ) {
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String value = pair.getValue();
            System.out.println(value);
        }
    }

    private static void Translit( String toTranslit ) {
        String textForTranslit = toTranslit;
        String[] words = textForTranslit.split("\\s");
        String regex = "[а-яёА-ЯЁ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(textForTranslit);
        if (m.find()) {
            System.out.println("Исходный набор символов: кириллический");
            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i]);
                boolean test = (words[i]).charAt(0) > 'А' && (words[i].charAt(0) < 'Я');
//                boolean test = words[i].matches("/^[А-ЯЁ][а-яё]+$/");
                if (test) {
                    // need to translate
                    System.out.println("Транслитирируем из кирилицы в латиницу слово: " + words[i]);
                }
            }
        } else {
            System.out.println("Исходный набор символов: латиница");
            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i]);
                boolean test = (words[i]).charAt(0) > 'A' && (words[i].charAt(0) < 'Z');
//                boolean test = words[i].matches("/^[A-Z][a-z]+$/");
                    if (test) {
                    // need to translate
                    System.out.println("Транслитирируем из латиницы в кирилицу слово: " + words[i]);
                }

                }
            }
        }
    }



package com.khpi;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.lang.*;
import java.io.*;


public class CSVtoMap {
    public static HashMap<String, String> TranslitTableLatinCyr = new HashMap<>();
    public static HashMap<String, String> TranslitTableCyrLatin = new HashMap<>();

    public static void main( String[] args ) throws Exception {
        String srcText = "my name Anet Goncharova from Kharkov city";
//        String srcText = "меня зовут Анна Гончарова и я из города Харьков";

        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader("/home/anna/GOST_Translit/61876-71t1.csv"))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] trans = line.split(cvsSplitBy);
                System.out.println(trans[0] + "  " + trans[1]);
                TranslitTableLatinCyr.put(trans[0], trans[1]);
                TranslitTableCyrLatin.put(trans[1], trans[0]);
            }

//            printValues(TranslitTableLatinCyr);
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
                    String word=words[i];
                    System.out.println("toTranslit имена собственные " + TranslinFromCyrToLat(word));
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
                    String word=words[i];
                    System.out.println("toTranslit имена собственные " + TranslinFromLatToCyr(word));
                }

            }
        }
    }


        public static String TranslinFromCyrToLat( String word ) {
            StringBuilder sb = new StringBuilder(word.length());
            for (int i = 0; i<word.length(); i++) {
                String l = word.substring(i, i+1);
                if (TranslitTableCyrLatin.containsKey(l)) {
                  sb.append(TranslitTableCyrLatin.get(l));
                }
                else {
                    sb.append(l);
                }
            }
            return sb.toString();
        }


        public static String TranslinFromLatToCyr( String word ) {
            StringBuilder sb = new StringBuilder(word.length());
            for (int i = 0; i<word.length(); i++) {
                String l = word.substring(i, i+1);
                if (TranslitTableLatinCyr.containsKey(l)) {
                    sb.append(TranslitTableLatinCyr.get(l));
            }
                else {
                    sb.append(l);
            }
        }
            return sb.toString();
    }
}

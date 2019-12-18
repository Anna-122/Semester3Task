package com.company;
import java.io.FileReader;
import java.util.Arrays;
import au.com.bytecode.opencsv.CSVReader;;
public class CSVReader {
    @SuppressWarnings("resource")
    public static void main( String[] args ) throws Exception {
        CSVReader reader = new CSVReader(new FileReader("/home/anna/IdeaProjects/ГОСТ/\n");
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                System.out.println(Arrays.toString(nextLine));
            }
        }
    }
}

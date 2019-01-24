package ua.nure.faryha.practice4;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Part1 {
    //part1 - displays the contents of a text file in the console; if word-length>3 ==> word to UpperCase
    private static final String ENCODING = "CP1251";
    public static final String P13 = "(?U)(\\w{4,})";
    public static final int THREE =3;


    public static String getInput(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(new File(fileName), ENCODING);
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }
        scanner.close();
        return sb.toString().trim();
    }


    public static String convert(String text) {
        String s = text;
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(P13);
        Matcher m = p.matcher(s);
        int max = THREE;
        while (m.find()) {
            if (m.group().length() > max) {
                m.appendReplacement(sb, m.group(1).toUpperCase());
            }
        }
        return m.appendTail(sb).toString();
    }

    public static void main(String[] args) throws IOException {
        String input = Part1.getInput("part1.txt");
        System.out.println(Part1.convert(input));
    }
}

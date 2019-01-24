package ua.nure.faryha.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;


public class Part4 implements Iterable {


    // public static final String p41 = "(?m)(?U)([A-Z]{1}[\\w\\d\\s\\-\\,]+[\\.\\!\\?]{1})";
    public static final String p41 = "(?m)(?U)([A-ZА-Я].+\\.)";
    private static final String ENCODING = "CP1251";

    @Override
    public Iterator iterator() {
        String input = null;
        try {
            input = Part4.getInput("part4.txt");
        } catch (IOException e) {
           // e.printStackTrace();
        }
        String finalInput = input;

        return new Iterator() {

            Pattern p = Pattern.compile(p41);
            Matcher m = p.matcher(finalInput);

            @Override
            public boolean hasNext() {
                return m.find();
            }

            @Override
            public Object next() {
                return m.group();
            }
        };
    }


    public static String getInput(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        //    try {
        Scanner scanner = new Scanner(new File(fileName), ENCODING);
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }
        scanner.close();
        //1 System.out.println(sb.toString().replaceAll("\\n|\\r\\n", " " ).replaceAll("\\.\\s", "\\.\n"));
        //2     return sb.toString().trim();

        return sb.toString().replaceAll("\\r\\n", " ").replaceAll("\\.\\s", ".\n").replaceAll("\\s\\s", " ").trim();

        //    } catch (IOException ex) {
        //       ex.printStackTrace();
        //   }
        //   return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        //   String input = Part4.getInput("part4.txt");
        //   System.out.println(input);
        //   System.out.println("");
        Part4 p4 = new Part4();
        Iterator iterator = p4.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}



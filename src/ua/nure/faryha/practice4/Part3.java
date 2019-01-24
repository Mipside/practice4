package ua.nure.faryha.practice4;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

public class Part3 {


    private static final String ENCODING = "CP1251";
    private static final String STOP = "stop";

    // public static final String pint = "(?m)(\\s\\b\\d+\\s\\d*)";
    public static final String pint = "(?m)(\\s\\b\\d+\\s)";
    // public static final String pdoub = "(?m)([+-]?(\\d*[.]).?\\d+)";
    public static final String pdoub = "(?m)(\\.\\d\\d|\\d+\\.\\d+|\\d+\\.)";
    public static final String pch = "(?m)(?U)(\\b\\w\\s)";
    public static final String pstr = "(?U)(?m)([a-zA-zа-яА-Я]\\w{1,})";

    public static String getInput(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        //    try {
        Scanner scanner = new Scanner(new File(fileName), ENCODING);
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }
        scanner.close();

        //  System.out.println(sb.toString().trim());
        return sb.toString().trim();
        //   } catch (IOException ex) {
        //       ex.printStackTrace();
        //  }
        //   return sb.toString();
    }

    public static String getData(String text, String reg) {
        String s = text;
        StringBuffer sb = new StringBuffer();
        //   System.out.println(s);
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(s);
        while (m.find()) {
            // outS = m.group(1);
            //  sb.append(outS);
            sb.append(m.group(1) + " ");
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {//part3
        String input = Part3.getInput("part3.txt");
        Scanner sc = new Scanner(System.in);
        String typeOfData;
        while (sc.hasNext()) {
            typeOfData = sc.nextLine();
            if ("char".equals(typeOfData)) {
                System.out.println(Part3.getData(input, pch).replaceAll("\\s\\s", " ").replaceAll("\\s$", ""));
            } else if ("String".equals(typeOfData)) {
                System.out.println(Part3.getData(input, pstr));
            } else if ("double".equals(typeOfData)) {
                System.out.println(Part3.getData(input, pdoub));
            } else if ("int".equals(typeOfData)) {
                System.out.println(Part3.getData(input, pint).replaceAll("^\\s", "").replaceAll("\\D\\D\\D", " ").replaceAll("\\s$", ""));
            } else if ("stop".equals(typeOfData)) {
                return;
            }
        }
        sc.close();
     /*   System.out.println("char");
        System.out.println(Part3.getData(input, pch).replaceAll("\\s\\s", " ").replaceAll("\\s$", ""));
        System.out.println("string");
        System.out.println(Part3.getData(input, pstr));
        System.out.println("double");
        System.out.println(Part3.getData(input, pdoub));
        System.out.println("int");
        System.out.println(Part3.getData(input, pint).replaceAll("^\\s", "").replaceAll("\\D\\D\\D", " ").replaceAll("\\s$", ""));
    */
    }
}

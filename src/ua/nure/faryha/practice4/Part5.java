package ua.nure.faryha.practice4;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {
    private static final String ENCODING = "CP1251";

    public static void main(String[] args) throws UnsupportedEncodingException {
        Locale locale1 = new Locale("ru", "RU");
        Locale locale2 = new Locale("en", "US");
        ResourceBundle rbRu = ResourceBundle.getBundle("resources", locale1);
        ResourceBundle rbEn = ResourceBundle.getBundle("resources", locale2);

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] mas = sc.nextLine().split(" ");
            if (mas[0].equals("stop")) {
                break;
            }
            Locale locale = new Locale(mas[1]);
            //      System.out.println(locale);
            ResourceBundle defRb = ResourceBundle.getBundle("resources", locale);
            //      System.out.println(defRb.getString(mas[0]));
            //  System.out.println(new String(defRb.getString(mas[0]).getBytes("ISO-8859-1"), "cp1251"));
            //  System.out.println(new String(defRb.getString(mas[0]).getBytes("iso8859-1"),ENCODING));
            System.out.println(defRb.getString(mas[0]));
        }
        sc.close();
    }
}

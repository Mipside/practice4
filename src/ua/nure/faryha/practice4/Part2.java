package ua.nure.faryha.practice4;

import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.security.SecureRandom;

public class Part2 {
    //part2 - making random nums and save them to part2.txt, then sort them and save them to part2_sorted.txt
    public static final int TEN = 10;
    public static final int FIFTY =50;

    //Making mas of random nums and write it to part2.txt and part2_sorted.txt
    public static void randomF() throws IOException {
        int mas[] = new int[TEN];
        int rand;
        SecureRandom r = new SecureRandom();
        for (int i = 0; i < TEN; i++) {
            rand = r.nextInt(FIFTY) + 1;
            mas[i] = rand;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TEN; i++) {
            sb.append(mas[i]).append(" ");
        }
        FileWriter fw = new FileWriter("part2.txt");
        fw.write(sb.toString());
        fw.close();

    }

    //  Here we reading nums from filename.txt
    public static void reading(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while (s != null) {
            System.out.print(s);
            s = br.readLine();
        }
        fr.close();
    }


    public static void sort() throws IOException, IllegalArgumentException {
        //  input stream
        FileInputStream fio = new FileInputStream("part2.txt");
        //input data to String
        Scanner sc = new Scanner(fio).useDelimiter("\\A");
        String result; // = sc.hasNext() ? sc.next() : "";
        if(sc.hasNext()){
            result = sc.next();
        }
        else {result="";};
        //  String to int massive
        String strMass[] = result.split(" ");
        int numMass[] = new int[strMass.length];
        //  System.out.println(result);
        for (int i = 0; i < strMass.length; i++) {
            numMass[i] = Integer.parseInt(strMass[i]);
            //      System.out.println(numMass[i]);
        }
        //  sorting massive
        Arrays.sort(numMass);
        //    System.out.println(Arrays.toString(numMass));
        //    writing massive to part2_sorted.txt
        FileWriter fw2 = new FileWriter("part2_sorted.txt");
        fw2.write(Arrays.toString(numMass).replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", ""));
        fw2.close();
    }


    public static void main(String[] args) throws IOException {
        randomF();
        sort();
        System.out.print("input  ==> ");
        Part2.reading("part2.txt");
        System.out.println("");
        System.out.print("output ==> ");
        Part2.reading("part2_sorted.txt");
        System.out.println("");

    }
}
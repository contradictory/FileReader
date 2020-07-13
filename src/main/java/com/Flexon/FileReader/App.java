package com.Flexon.FileReader;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        File inputFile = new File("D:\\Flexon\\Maven\\test.txt");
        FileReader fileReader = new FileReader(inputFile);

        BufferedReader bufferedReader= new BufferedReader(fileReader);
        java.lang.String line;

        List<String> res = new ArrayList<>();
        Map<java.lang.String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            line = bufferedReader.readLine();
            System.out.println(line);
            if (line == null) {
                break;
            }

            for (int i = 0; i < line.length(); i++) {
                char tmp = line.charAt(i);
                if ((65 <= tmp && tmp <= 97) || (97 <= tmp && tmp <= 122)) {
                    sb.append(tmp);
                } else {
                    String f = sb.reverse().toString();
                    map.put(f, map.getOrDefault(f, 0) + 1);
                    sb.delete(0, sb.length());
                }
            }
            if (sb.length() != 0) {
                String e = sb.reverse().toString();
                map.put(e, map.getOrDefault(e, 0) + 1);
            }
            sb.delete(0, sb.length());
        }


        for (String key : map.keySet()) {

            if (key.length() > 3 && map.get(key) > 5) {
                res.add(key);
//                System.out.println(key);
            }
        }
//        for (String s : res) {
//            System.out.println(s);
//        }

        Iterator<String> it = res.iterator();
        while (it.hasNext()) {
            String print = it.next();
            System.out.println(print);
        }

    }
}

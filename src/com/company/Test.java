package com.company;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashSet<Point> set = new HashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataset.txt"));
            String s = br.readLine();
            while (null != s) {
                String[] line = s.trim().split("\\s+");
                set.add(new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
                s = br.readLine();
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Point p : set) {
            System.out.println(p.toString());
        }
    }
}

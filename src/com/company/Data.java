package com.company;

import java.io.*;
import java.util.*;

public class Data {

    //将文件中的所有数据读入点集
    public static void readData(String path, HashSet<Point> AllPoints) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String s = br.readLine();
            while (null != s) {
                String[] line = s.trim().split("\\s+");
                AllPoints.add(new Point(Double.parseDouble(line[0]), Double.parseDouble(line[1])));
                s = br.readLine();
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将每个点的聚类结果写入文件
    public static void writeData(String path, HashSet<Point> AllPoints) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (Point point : AllPoints) {
                bw.write(point.toString()+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

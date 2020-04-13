package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //key表示生成的类别个数，value表示该个数出现的频次
        /*Map<Integer, Integer> freq = new HashMap<>();

        //类别个数-对应的最小的k值
        Map<Integer, Integer> minK = new HashMap<>();

        //对参数k从1到100进行遍历执行算法，每个参数对应一个生成聚类的个数
        //对生成聚类个数（个数1除外）的频次进行统计，出现频次最多的那个聚类个数可以视作最好的聚类方案
        //在该聚类个数的k值中选取最小的k，作为最佳的k值
        for (int k = 1; k <= 20; k++) {
            HashSet<Point> AllPoints = new HashSet<>();
            //将所有点读入集合
            Data.readData("./clusters-set/Jain.txt", AllPoints);

            //建立基本数据结构
            Utils.initNRSet(k, AllPoints);

            //执行算法
            RNNDBSCAN rnnDbscan = new RNNDBSCAN();
            int numOfClusters = rnnDbscan.rnndbscan(AllPoints, k);

            if (numOfClusters != 1) {
                if (freq.get(numOfClusters) == null) {
                    freq.put(numOfClusters, 0);
                    //放置类别个数对应的最小k值
                    minK.put(numOfClusters, k);
                }

                freq.put(numOfClusters, freq.get(numOfClusters) + 1);
            }
        }

        //取最好情况，执行算法
        int max = -1;
        int bestK = 0;
        int num = 0;
        for (Integer k : freq.keySet()) {
            if (freq.get(k) > max) {
                max = freq.get(k);
                bestK = minK.get(k);
                num = k;
            }
        }

        System.out.println("The choice of k is: " + bestK);
        System.out.println("Number of clusters: " + num);*/

        int k = 14;

        HashSet<Point> AllPoints = new HashSet<>();

        //将所有点读入集合
        Data.readData("./clusters-set/Aggregation.txt", AllPoints);

        //建立基本数据结构
        Utils.initNRSet(k, AllPoints);

        //执行算法
        RNNDBSCAN rnnDbscan = new RNNDBSCAN();
        rnnDbscan.rnndbscan(AllPoints, k);

        //输出结果
        Data.writeData("result.txt", AllPoints);

    }
}

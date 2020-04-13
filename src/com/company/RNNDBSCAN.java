package com.company;

import java.util.*;

public class RNNDBSCAN {

    public HashSet<Point> neighborhood(Point x, int k) {
        HashSet<Point> ans = new HashSet<>();
        for (Point p : Utils.Nmap.get(x)) {
            ans.add(p);
        }
        if (Utils.RMap.get(x) != null) {
            for (Point p : Utils.RMap.get(x)) {
                if (Utils.RMap.get(p) != null && Utils.RMap.get(p).size() >= k) {
                    ans.add(p);
                }
            }
        }
        return ans;
    }

    public boolean expandCluster(Point x, int cluster, int k) {
        if (Utils.RMap.get(x) == null || Utils.RMap.get(x).size() < k) {
            x.setNoise();
            return false;

        } else {
            Queue<Point> seeds = new LinkedList<>();
            x.setCluster(cluster);
            for (Point neighbor : neighborhood(x, k)) {
                seeds.add(neighbor);
                neighbor.setCluster(cluster);
            }
            while (!seeds.isEmpty()) {
                Point y = seeds.remove();
                if (Utils.RMap.get(y) != null && Utils.RMap.get(y).size() >= k) {
                    Set<Point> neighbors = neighborhood(y, k);
                    for (Point z : neighbors) {
                        if (!z.isVisited()) {
                            seeds.add(z);
                            z.setCluster(cluster);
                        } else if (z.isNoise()) {
                            z.setCluster(cluster);
                        }
                    }
                }
            }
            return true;
        }
    }

    public void expandClusters(HashSet<Point> AllPoints, int k) {
        for (Point x : AllPoints) {
            if (x.isNoise()) {
                Set<Point> neighbors = Utils.Nmap.get(x);
                int minCluster = -1;
                double minDist = Double.MAX_VALUE;
                for (Point n : neighbors) {
                    int cluster = n.getCluster();
                    double d = Utils.getDist(x, n);
                    if (Utils.RMap.get(n) != null && Utils.RMap.get(n).size() >= k &&
                        d <= Utils.den(cluster, AllPoints, k) && d < minDist) {
                        minCluster = cluster;
                        minDist = d;
                    }
                }
                x.setCluster(minCluster);

            }
        }
    }

    public void rnndbscan(HashSet<Point> AllPoints, int k) {
        int cluster = 1;
        for (Point x : AllPoints) {
            if (!x.isVisited()) {   //如果未访问
                expandCluster(x, cluster, k);
                cluster += 1;
            }
        }
        expandClusters(AllPoints, k);
    }
}

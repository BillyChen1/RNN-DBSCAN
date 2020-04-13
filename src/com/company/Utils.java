package com.company;


import java.util.*;

public class Utils {
    //存储每个点的N集合
    public static Map<Point, Set<Point>> Nmap = new HashMap<>();
    //存储每个点的R集合
    public static  Map<Point, Set<Point>> RMap = new HashMap<>();

    public static double getDist(Point x, Point y) {
        return Math.sqrt((x.getX()-y.getX())*(x.getX()-y.getX())+(x.getY()-y.getY())*(x.getY()-y.getY()));
    }

    public static void setNRSetForCurPoint(Point x, int k, HashSet<Point> AllPoints) {
       //集合中点的排序规则：距离原点近的在前（大根堆）
        Queue<Point> s = new PriorityQueue<>((p1, p2) -> (int) (getDist(p1, x) - getDist(p2, x)));
        //Set<Point> s = new TreeSet<>((p1, p2) -> (int) (getDist(p1, x) - getDist(p2, x)));
        for (Point p : AllPoints) {
            s.add(p);
        }
        //取出前k小的点置于原点x的N集合
        Set<Point> N = new HashSet<>();
        //Iterator<Point> it = s.iterator();
        for (int i = 0; i < k; i++) {
            Point p = s.remove();   //取队首元素p
            //将p放入x的N集合
            N.add(p);

            //将x放入p的R集合
            if (RMap.get(p) == null) {
                Set<Point> set = new HashSet<>();
                RMap.put(p, set);
            }
            Set tmp = RMap.get(p);
            tmp.add(x);
            RMap.put(p, tmp);
        }
        Nmap.put(x, N);
    }

    //对所有点进行遍历，完成基本数据结构的建立
    public static void initNRSet(int k, HashSet<Point> AllPoints) {
        for (Point p : AllPoints) {
            setNRSetForCurPoint(p, k, AllPoints);
        }
    }

    public static double den(int cluster, HashSet<Point> AllPoints, int k) {
        double max = -1;
        //集合中装有同一簇的点
        List<Point> setOfThisCluster = new ArrayList<>();
        for (Point p : AllPoints) {
            if (p.getCluster() == cluster) {
                setOfThisCluster.add(p);
            }
        }
        for (int i = 0; i < setOfThisCluster.size(); i++) {
            for (int j = i + 1; j < setOfThisCluster.size(); j++) {
                Point x = setOfThisCluster.get(i);
                Point y = setOfThisCluster.get(j);
                if (Utils.RMap.get(x) != null
                    && Utils.RMap.get(x).size() >= k
                    && Utils.RMap.get(y) != null
                    && Utils.RMap.get(y).size() >= k
                    && Utils.Nmap.get(x).contains(y)) {
                    max = Math.max(max, getDist(x, y));
                }
            }
        }
        return max;

    }


}

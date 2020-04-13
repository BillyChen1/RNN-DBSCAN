package com.company;

import java.util.Objects;

public class Point {
    private double x;
    private double y;
    //private boolean visited;
    private int cluster;
    //private boolean noise;

    public Point(double x,double y) {
        this.x = x;
        this.y = y;
        //this.visited = false;
        this.cluster = 0;   //0表示未分类，-1表示噪音
    }

    public double getDistance(Point point) {
        return Math.sqrt((x-point.x)*(x-point.x)+(y-point.y)*(y-point.y));
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public boolean isVisited() {
        return cluster != 0;
    }

    /*public void setVisited(boolean visited) {
        this.visited = visited;
    }*/

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public boolean isNoise() {
        return cluster == -1;
    }

    public void setNoise() { this.cluster = -1; }

    @Override
    public String toString() {
        return x+" "+y+" "+cluster+" "+(isNoise()?1:0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

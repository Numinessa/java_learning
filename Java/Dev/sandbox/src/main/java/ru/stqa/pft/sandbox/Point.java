package ru.stqa.pft.sandbox;


public class Point {
  private double x;
  private double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point p1, Point p2) {
    double dist = Math.sqrt(Math.pow((p1.x-p2.x),2) + Math.pow((p1.y-p2.y),2));
    return dist;
  }

  public static void main(String[] args) {
    Point p1 = new Point(3, 2);
    Point p2 = new Point(5, 7);
    System.out.println("Wynik: " + distance(p1, p2));
  }
}





package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Point {
  private double x;
  private double y;


  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

//  public static double distance(Point p1, Point p2) {
//    double dist = Math.sqrt(Math.pow((p1.x-p2.x),2) + Math.pow((p1.y-p2.y),2));
//    return dist;
//  }
  public double distance(Point p2) {
    double dist = Math.sqrt((this.x-p2.x)*(this.x-p2.x)+(this.y-p2.y)*(this.y-p2.y));
    return dist;
  }

  public static void main(String[] args) {
    Point p1 = new Point(3, 2);
    Point p2 = new Point(5, 7);
    System.out.println("Wynik: "+ p1.distance(p2) );
  }

  @Test
  public void Point() {
    Point p1 = new Point(3, 2);
    Assert.assertEquals(p1.x == 10.0, p1.y == 30.0);
  }
}






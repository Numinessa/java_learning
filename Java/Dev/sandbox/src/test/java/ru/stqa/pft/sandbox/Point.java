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

  @Test
  public void Point( Point p1, Point p2){
    p1 = new Point(11, 10);
    p2 = new Point(5,5);
    Assert.assertEquals(p1.x== 10.0,p1.y ==30.0);
  }
}

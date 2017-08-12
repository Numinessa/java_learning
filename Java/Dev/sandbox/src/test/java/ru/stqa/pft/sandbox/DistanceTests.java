package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
  public void testDistance(){
    Point p1 = new Point(0, 0);
    Point p2 = new Point(12, 5);
    Assert.assertEquals(p1.distance(p2), 13.0);
  }

  @Test
  public void testDistanceSecond(){
    Point p1 = new Point(0,40);
    Point p2 = new Point(30, 0);
    Assert.assertEquals(p1.distance(p2),50.0);
  }
}

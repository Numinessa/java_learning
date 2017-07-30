package ru.stqa.pft.sandbox;

public class Point {
  public double p1 = 5;
  public double  p2 = 10;

 // public static double distance(Point p1, Point p2) {
  //  this.p1 = p1;
  //  this p2 = p2;
  //  return this.p2 * this p1;

 // }
  public static void main(String[] args){

    Point p = new Point();
    System.out.println("cos " + p.p1 +"i "+ p.p2 + " = " + Math.sqrt(p.p1 * p.p2));
  }
}

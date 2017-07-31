package ru.stqa.pft.sandbox;

public class Point {
  public double p1;
  public double p2;

  public Point(double p1, double p2) {
   this.p1 = p1;
   this.p2 = p2;
  }

 // public static double distance(Point p1, Point p2){
 //   return Math.sqrt();
//  }

  public static void main(String[] args){
    Point p = new Point(10, 5);
    System.out.println("Wyliczenie odleglosci miedzy dwoma punktami: " + p.p1 +" i "+ p.p2 + " = " + Math.sqrt(p.p1 * p.p2));
  }
}

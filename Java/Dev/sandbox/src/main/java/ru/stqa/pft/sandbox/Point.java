package ru.stqa.pft.sandbox;

public class Point {
//  public double p1;
//  public double p2;

//  public Point(double p1, double p2) {
//   this.p1 = p1;
//   this.p2 = p2;
//  }

 // public static double distance(Point p1, Point p2){
 //   return Math.sqrt();
//  }
public Point() {
}

  public static void main(String[] args){
    double p1[] = new double[] {2,0,5};
    double p2[] = new double[] {11,7,4};
    System.out.println("Współrzędne I punktu (" + p1[0] + ", "+ p1[1] + ",  "+ p1[2] + ")");
    System.out.println("Współrzędne II pukntu (" + p2[0] + ", " + p2[1] + ", " + p2[2] + ")");
    System.out.println("Wyliczenie odległoś miedzy puntkami = " + Math.sqrt((p2[0] - p1[0])*(p2[0] - p1[0]) + (p2[1] - p1[1])*(p2[1] - p1[1]) + (p2[2] - p1[2])*(p2[2] - p1[2])));
    //Point p = new Point(10, 5);
  //  System.out.println("Wyliczenie odleglosci miedzy dwoma punktami: " + p.p1 +" i "+ p.p2 + " = " + Math.sqrt(p.p1 * p.p2));
  }
}

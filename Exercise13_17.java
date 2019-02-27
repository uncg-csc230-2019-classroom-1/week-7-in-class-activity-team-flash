/*The objective of this program is to create a comlex number class that can 
add, subtract, multiply, divide, and compare different complex numbers.*/
import java.util.Scanner;

public class Exercise13_17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the first complex number: ");
    double a = input.nextDouble();
    double b = input.nextDouble();
    Complex c1 = new Complex(a, b);

    System.out.print("Enter the second complex number: ");
    double c = input.nextDouble();
    double d = input.nextDouble();
    Complex c2 = new Complex(c, d);

    System.out.println("(" + c1 + ")" + " + " + "(" + c2 + ")" + " = " + c1.add(c2));
    System.out.println("(" + c1 + ")" + " - " + "(" + c2 + ")" + " = " + c1.subtract(c2));
    System.out.println("(" + c1 + ")" + " * " + "(" + c2 + ")" + " = " + c1.multiply(c2));
    System.out.println("(" + c1 + ")" + " / " + "(" + c2 + ")" + " = " + c1.divide(c2));
    System.out.println("|" + c1 + "| = " + c1.abs());
    
    Complex c3 = (Complex)c1.clone();
    System.out.println(c1 == c3);
    System.out.println(c3.getRealPart());
    System.out.println(c3.getImaginaryPart());
    Complex c4 = new Complex(4, -0.5);
    Complex[] list = {c1, c2, c3, c4};
    java.util.Arrays.sort(list);
    System.out.println(java.util.Arrays.toString(list));
  }
}
class Complex implements Cloneable, Comparable<Complex>{
    private double a = 0;
    private double b = 0;
    
    public Complex() {        
    }
    public Complex(double a) {
        this.a = a;
    }
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    public double getRealPart() {
        return a;
    }
    public double getImaginaryPart() {
        return b;
    }
    
    public String add(Complex comp1) {
        if (b + comp1.getImaginaryPart() >= 0) {
        return (comp1.getRealPart()+a) + " + " + 
                (comp1.getImaginaryPart() + b) + "i";
        }
        else {
            return (comp1.getRealPart()+a) + " " + 
                (comp1.getImaginaryPart() + b) + "i";
        }
        }
    
    public String subtract(Complex comp2) {
        double c1 = comp2.getRealPart();
        double d1 = comp2.getImaginaryPart();
        if (b-d1 >= 0) {
            return (a-c1) + " + " + (b-d1) + "i";
        }
        else {
            return (a-c1) + " " + (b-d1) + "i";
        }
    }
    
    public String multiply(Complex comp2) {
        double c1 = comp2.getRealPart();
        double d1 = comp2.getImaginaryPart();
        if (b*c1 + a*d1 >= 0) {
            return (a*c1 - b*d1) + " + " + (b*c1 + a*d1) + "i";
        }
        else {
            return (a*c1 - b*d1) + " " + (b*c1 + a*d1) + "i";
        }   
    }
    
    public String divide(Complex comp2) {
        double c1 = comp2.getRealPart();
        double d1 = comp2.getImaginaryPart();
        if (b*c1 - a*d1 >= 0) {
            return ((a*c1+b*d1)/(Math.pow(c1,2)+Math.pow(d1,2))) + " + " + 
                    ((b*c1-a*d1)/(Math.pow(c1,2)+Math.pow(d1,2))) + "i";
        }
        else {
            return ((a*c1+b*d1)/(Math.pow(c1,2)+Math.pow(d1,2))) + " " +
                    ((b*c1-a*d1)/(Math.pow(c1,2)+Math.pow(d1,2))) + "i";
        }   
    }
    
    public double abs() {
        return Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
    @Override
    public String toString() {
        if (b >= 0) {
        return a + " + " + b + "i"; 
        }
        else {
            return a + " " + b + "i";
        }
    }
    @Override 
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    @Override
    public int compareTo(Complex comp2) {
    if (abs() > comp2.abs())
      return 1;
    else if (abs() < comp2.abs())
      return -1;
    else
      return 0;
  }  
        
}
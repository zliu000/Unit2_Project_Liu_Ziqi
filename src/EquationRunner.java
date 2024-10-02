import java.util.Scanner;

public class EquationRunner {
    public static void main(String[] args) {
        // Scanner
        Scanner s = new Scanner(System.in);

        // Variables
        String pointA;
        String pointB;
        double pointX;


        // Main Program
        // Introduction
        System.out.println("Welcome to Linear Equations!"
                + "\nThis program will return a linear equation and:"
                + "\nThe slope blah blah blah"
                + "\n\nPlease enter all points in the following format:"
                + "\n\t(x,y), without ANY space.\n"
        );
        System.out.print("Enter your first Coordinate Point: ");
        pointA = s.nextLine();
        System.out.print("Enter your second Coordinate Point: ");
        pointB = s.nextLine();

        LinearEquation linEqua = new LinearEquation(pointA, pointB);
        System.out.println(linEqua.toString());
    }
}
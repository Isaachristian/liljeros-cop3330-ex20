package org.example;

import java.util.Locale;
import java.util.Scanner;

/**
 * Multistate Sales Tax Calculator
 */
public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        double input;
        double taxRate;
        double tax;
        double output;
        String state;

        System.out.print("What is the total? ");
        try { // handles exception if non-double is passed
            input = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input");
            return;
        }
        output = input;

        System.out.print("What state do you live in? ");
        state = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

        // Handle special cases
        switch (state) {
            case "wisconsin":
                taxRate = 0.05;
                System.out.print("Enter your county: ");
                String county = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
                if (county.equals("eau claire"))
                    taxRate += .005;
                if (county.equals("dunn"))
                    taxRate += .004;
                break;
            case "illinois":
                taxRate = .08;
                break;
            default:
                taxRate = 0;
        }

        if (taxRate != 0) {
            tax = input * taxRate;
            System.out.printf("Your tax is: $%.2f%n", tax);
            output = tax + input;
        } else {
            System.out.println("No tax will be collected");
        }

        System.out.printf("Your total is: $%.2f%n", output);
    }
}

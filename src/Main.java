import calculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        // Read user input and perform operations
        while (true) {
            System.out.println("Enter an operation (+, -, *, /, sin, cos, tan, sqrt, log, quit):");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("quit")) {
                System.out.println("Exiting calculator.");
                break;
            }

            System.out.println("Enter operand(s):");
            double operand1 = scanner.nextDouble();
            double result;

            switch (operation.toLowerCase()) {
                case "+":
                    calculator.add(operand1);
                    break;
                case "-":
                    calculator.subtract(operand1);
                    break;
                case "*":
                    calculator.multiply(operand1);
                    break;
                case "/":
                    calculator.divide(operand1);
                    break;
                case "sin":
                    calculator.sin(operand1);
                    break;
                case "cos":
                    calculator.cos(operand1);
                    break;
                case "tan":
                    calculator.tan(operand1);
                    break;
                case "sqrt":
                    calculator.squareRoot(operand1);
                    break;
                case "log":
                    calculator.logarithm(operand1);
                    break;
                default:
                    System.out.println("Invalid operation.");
                    continue;
            }

            // Print the current value after each operation
            System.out.println("Current Value: " + calculator.getCurrentValue());
        }

        // Close the scanner
        scanner.close();
    }
}

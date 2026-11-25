package JavaAssignment;

public class NumberAnalyzer {
    package javaAssignment;

import java.util.Scanner;

    /**
     * A console program that lets the user run a few simple number operations
     * from a menu: counting down, even/odd report, sign check, and addition.
     */
    public class NumberAnalyzer {

        /**
         * Counts down from 10 to 1 and prints each number on its own line.
         */
        public static void printNumbersDescending() {
            for (int i = 10; i >= 1; i--) {
                System.out.println(i);
            }
        }

        /**
         * Goes through the numbers 1 to 10 and prints whether each one is
         * even or odd, using the format "number -> Even/Odd".
         */
        public static void printEvenOrOdd() {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " -> Even");
                } else {
                    System.out.println(i + " -> Odd");
                }
            }
        }

        /**
         * Looks at a number and decides whether it is above, below, or equal to zero.
         *
         * @param number the integer the user wants to check
         * @return "Positive" if the number is greater than zero, "Negative" if it is
         *         less than zero, or "Zero" if it equals zero
         */
        public static String checkNumberType(int number) {
            if (number > 0) {
                return "Positive";
            } else if (number < 0) {
                return "Negative";
            } else {
                return "Zero";
            }
        }

        /**
         * Adds two integers together.
         *
         * @param number1 the first integer to add
         * @param number2 the second integer to add
         * @return the total of number1 and number2
         */
        public static int calculateSum(int number1, int number2) {
            return number1 + number2;
        }

        /**
         * Prints the menu options to the console.
         */
        private static void printMenu() {
            System.out.println("=========================");
            System.out.println("Number Analyzer Menu");
            System.out.println("=========================");
            System.out.println("1 - Print Numbers 10 to 1");
            System.out.println("2 - Print Even/Odd Report");
            System.out.println("3 - Check Number Type");
            System.out.println("4 - Calculate Sum Between Two Numbers");
            System.out.println("5 - Exit");
            System.out.println("=========================");
        }

        /**
         * Keeps asking until the user types a valid whole number, then returns it.
         *
         * @param scanner the Scanner used to read user input
         * @param prompt  the message shown before reading the number
         * @return the integer entered by the user
         */
        private static int readInt(Scanner scanner, String prompt) {
            while (true) {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                try {
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid whole number.");
                }
            }
        }

        /**
         * Entry point. Shows the menu repeatedly in a do-while loop and runs the
         * chosen operation until the user selects Exit.
         *
         * @param args command-line arguments (not used)
         */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice = 0;

            do {
                printMenu();
                System.out.print("Enter your choice: ");
                String input = scanner.nextLine().trim();

                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    choice = -1; // anything that is not a number is an invalid choice
                }

                switch (choice) {
                    case 1:
                        printNumbersDescending();
                        break;
                    case 2:
                        printEvenOrOdd();
                        break;
                    case 3:
                        int number = readInt(scanner, "Enter a number: ");
                        System.out.println(checkNumberType(number));
                        break;
                    case 4:
                        int first = readInt(scanner, "Enter first number: ");
                        int second = readInt(scanner, "Enter second number: ");
                        System.out.println("Sum = " + calculateSum(first, second));
                        break;
                    case 5:
                        System.out.println("Thank you for using Number Analyzer.");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
                System.out.println();
            } while (choice != 5);

            scanner.close();
        }
    }
}

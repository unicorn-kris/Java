package com.ssu.kristina_chernova.java.lesson_1.task_2;

import java.util.Scanner;
import static java.lang.System.exit;

// Kristina Chernova, task 1, option 1
public class Calculator {

    public static void main(String[] args) {
        Calculator app = new Calculator();
        app.startApplication();
    }

    private final Scanner in = new Scanner(System.in);
    private int firstNumber;
    private int secondNumber;

    private void startApplication() {
        int choice;

        while (true) {
            System.out.println("""
                Enter action:
                1 - Addition
                2 - Subtraction
                3 - Division
                4 - Multiplication
                0 - Exit""");

            choice = in.nextInt();

            switch (choice) {
                case 0 -> exit(0);
                case 1 -> addition();
                case 2 -> subtraction();
                case 3 -> division();
                case 4 -> multiplication();
                default -> System.out.println("Enter correct action!");
            }
        }
    }

    private void enterValues() {
        System.out.println("Enter first number: ");
        firstNumber = in.nextInt();
        System.out.println("Enter second number: ");
        secondNumber = in.nextInt();
    }

    private void addition() {
        enterValues();
        System.out.printf("Addition Result: %d\n", firstNumber + secondNumber);
    }

    private void subtraction() {
        enterValues();
        System.out.printf("Subtraction Result: %d\n", firstNumber - secondNumber);
    }

    private void division() {
        enterValues();
        if (secondNumber != 0) {
            System.out.printf("Division Result (integer) : %d\n", firstNumber / secondNumber);
            System.out.printf("Division Result (integer) : %3.2f\n", (firstNumber * 1.0) / secondNumber);
        }
        else {
            System.out.println("Divide by zero exception");
        }
    }

    private void multiplication() {
        enterValues();
        System.out.printf("Multiplication Result: %d\n", firstNumber * secondNumber);
    }
}
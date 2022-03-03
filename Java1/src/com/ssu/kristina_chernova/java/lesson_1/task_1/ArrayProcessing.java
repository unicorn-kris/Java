package com.ssu.kristina_chernova.java.lesson_1.task_1;

// Kristina Chernova, task 1, option 1
public class ArrayProcessing {

    public static void main(String[] args) {
        ArrayProcessing app = new ArrayProcessing();
        app.startApplication();
    }

    private void startApplication() {
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = ((int)(Math.random() * 20) - 10);
        }

        System.out.println("Initial array:");
        printArray(array);

        changeMaxNegMinPosElements(array);
    }

    private void printArray(int[] array) {
        for (int num: array) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }

    private void changeMaxNegMinPosElements(int[] array) {
        int maxNeg = -100;
        int maxNegIndex = 0;
        int minPos = 100;
        int minPosIndex = 0;

        for (int i = 0; i < array.length; ++i) {
            if (array[i] < 0) {
                if (maxNeg < array[i]) {
                    maxNeg = array[i];
                    maxNegIndex = i;
                }
            }
            else if (minPos > array[i]) {
                minPos = array[i];
                minPosIndex = i;
            }
        }

        array[maxNegIndex] = minPos;
        array[minPosIndex] = maxNeg;

        System.out.println("Change max negative and min positive elements:");
        printArray(array);
    }
}



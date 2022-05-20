package com.ssu.kristina_chernova.java.lesson_7.task_7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class QuickSortMutliThreading extends RecursiveTask<Integer> {
    int start, end;
    int[] arr;

    private int partition(int start, int end,
                          int[] arr) {


        int i = start, j = end;

        // Decide random pivot

        int pivoted = new Random().nextInt(j - i) + i;

        // Swap the pivoted with end

        // element of array;

        int t = arr[j];

        arr[j] = arr[pivoted];

        arr[pivoted] = t;

        j--;


        // Start partitioning

        while (i <= j) {


            if (arr[i] <= arr[end]) {

                i++;

                continue;

            }


            if (arr[j] >= arr[end]) {

                j--;

                continue;

            }


            t = arr[j];

            arr[j] = arr[i];

            arr[i] = t;

            j--;

            i++;

        }


        // Swap pivoted to its

        // correct position

        t = arr[j + 1];

        arr[j + 1] = arr[end];

        arr[end] = t;

        return j + 1;

    }

    // Function to implement
    // QuickSort method
    public QuickSortMutliThreading(int start,
                                   int end,
                                   int[] arr) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override

    protected Integer compute() {
        // Base case
        if (start >= end)
            return null;
        // Find partition
        int p = partition(start, end, arr);
        // Divide array
        QuickSortMutliThreading left = new QuickSortMutliThreading(start, p - 1, arr);
        QuickSortMutliThreading right
                = new QuickSortMutliThreading(p + 1,
                end,
                arr);
        // Left subproblem as separate thread
        left.fork();
        right.compute();
        // Wait untill left thread complete
        left.join();
        // We don't want anything as return
        return null;
    }

    public static void main(String args[]) {
        int n = 5000000;
        int parallelism = 8;
        //generate initial data
        int[] arr = new int[n];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) arr[i] = random.nextInt();

        // ForkJoin ThreadPool to keep
        // thread creation as per resources
        ForkJoinPool pool = new ForkJoinPool(parallelism);


        // Start the first thread in fork
        // join pool for range 0, n-1
        long startTime = System.currentTimeMillis();
        pool.invoke(new QuickSortMutliThreading(0, n - 1, arr));

        long execTime = System.currentTimeMillis() - startTime;

        // Print shorted elements

        System.out.println("Execution Time " + execTime);


        try (PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"))) {
            for (int i = 0; i < n; i++) printWriter.println(arr[i]);
        } catch (IOException ioException) {
            ioException.printStackTrace(System.err);
        }
    }
}
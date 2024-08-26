package org.example;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static DataRepository dataRepository = new DataRepository();

    static final Object lock1 = new Object();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        DataGenerator dataGenerator = new DataGenerator();

        executor.submit(dataGenerator);

        executor.shutdown();

    }
}
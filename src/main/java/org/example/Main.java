package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    static DataRepository dataRepository = new DataRepository();

    static final Object lock = new Object();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        DataGenerator dataGenerator = new DataGenerator();
        DataService dataService = new DataService();

        executor.submit(dataGenerator);
        executor.submit(dataService);


        executor.shutdown();
        try {
            boolean finished = executor.awaitTermination(5, TimeUnit.SECONDS);
            if (!finished) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            String message = e.getMessage();
            System.err.println(message);
            executor.shutdownNow();
            System.out.println("No avg calculated!");
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println(DataService.avg);

    }
}
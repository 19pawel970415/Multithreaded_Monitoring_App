package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    static DataRepository dataRepository = new DataRepository();

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        DataGenerator dataGenerator = new DataGenerator();
        DataService dataService = new DataService();

        Future<?> generatorFuture = executor.submit(dataGenerator);
        try {
            generatorFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Future<?> serviceFuture = executor.submit(dataService);
        try {
            serviceFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        System.out.println(DataService.avg);
    }
}
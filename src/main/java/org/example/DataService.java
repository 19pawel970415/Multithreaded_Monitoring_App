package org.example;

public class DataService implements Runnable {

    static Double avg = 0.0;

    @Override
    public void run() {
        synchronized (Main.lock) {
            Double sum = 0.0;
            try {
                while (Main.dataRepository.getData().size() < 100) {
                    Main.lock.wait();
                }
            } catch (InterruptedException e) {
                String message = e.getMessage();
                System.err.println(message);
                return;
            }
            if (Main.dataRepository.getData().size() == 100) {
                for (Integer element : Main.dataRepository.getData()) {
                    sum += element;
                }
                avg = sum / Main.dataRepository.getData().size();
            } else {
                Thread.currentThread().interrupt();
                System.err.println("The list is incomplete!");
                return;
            }
        }
    }
}

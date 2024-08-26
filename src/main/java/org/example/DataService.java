package org.example;

public class DataService implements Runnable {

    static Double avg = 0.0;

    @Override
    public void run() {
        synchronized (Main.lock2) {
            Double sum = 0.0;
            for (Integer element : Main.dataRepository.getData()) {
                sum += element;
            }
            avg = sum / Main.dataRepository.getData().size();
        }
    }
}

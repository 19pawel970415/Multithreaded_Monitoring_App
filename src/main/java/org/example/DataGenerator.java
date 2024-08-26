package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator implements Runnable {

    @Override
    public void run() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        synchronized (Main.lock) {
            for (int i = 0; i < 100; i++) {
                int element = random.nextInt(10);
                Main.dataRepository.getData().add(element);
            }
            Main.lock.notify();
        }
    }
}

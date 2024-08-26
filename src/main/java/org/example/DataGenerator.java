package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator implements Runnable {

    @Override
    public void run() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        synchronized (Main.lock1) {
            for (int i = 0; i < 100; i++) {
                int element = random.nextInt();
                Main.dataRepository.getData().add(element);
            }
        }
    }
}

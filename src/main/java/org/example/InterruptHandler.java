package org.example;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class InterruptHandler {
    private int[] interruptVector;
    private Semaphore semaphore;

    public InterruptHandler() {
        interruptVector = new int[10];
        semaphore = new Semaphore(1);
    }

    public void interruptGenerator(int threadNumber) {
        int interruptNumber = new Random().nextInt(10);
        System.out.println("Thread " + threadNumber + " gerou interrupção " + interruptNumber);
        try {
            semaphore.acquire();
            interruptVector[interruptNumber]++;
            System.out.println("Thread " + threadNumber + " está esperando para ser tratada");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public void interruptTreatment() {
        while (true) {
            for (int i = 0; i < interruptVector.length; i++) {
                if (interruptVector[i] > 0) {
                    try {
                        semaphore.acquire();
                        System.out.println("Interrupção " + i + " está sendo tratada");
                        Thread.sleep(new Random().nextInt(1000));
                        interruptVector[i]--;
                        System.out.println("Interrupção " + i + " foi desbloqueada");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        InterruptHandler interruptHandler = new InterruptHandler();
        new Thread(() -> interruptHandler.interruptGenerator(1)).start();
        new Thread(() -> interruptHandler.interruptGenerator(2)).start();
        new Thread(() -> interruptHandler.interruptGenerator(3)).start();
        new Thread(() -> interruptHandler.interruptGenerator(4)).start();
        new Thread(() -> interruptHandler.interruptGenerator(5)).start();
        new Thread(() -> interruptHandler.interruptTreatment()).start();
    }
}

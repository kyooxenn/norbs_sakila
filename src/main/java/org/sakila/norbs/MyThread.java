package org.sakila.norbs;



public class MyThread implements Runnable {


    private int threadNumber;
    public MyThread(int threadNumber) {
        this.threadNumber= threadNumber;
    }


    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i +  " from thread " + threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}

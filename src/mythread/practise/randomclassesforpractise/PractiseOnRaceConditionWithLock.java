package mythread.practise.randomclassesforpractise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Check the PractiseOnRaceCondition for the issue.
 * Then check this class for how it resolves that using Lock class.
 */
public class PractiseOnRaceConditionWithLock {

    int id=0;
    Lock theLock= new ReentrantLock();
    public void increase(){
        try{
            theLock.lock();
            this.id++;
        }
        catch (Exception e){
            System.out.println("Exception occured during locking");
        }
        finally {
            theLock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        PractiseOnRaceConditionWithLock practiseOnRaceCondition= new PractiseOnRaceConditionWithLock();

        Thread[] myThreads= new Thread[70];
        for(int i=0;i<70;i++){
            Thread thread= new Thread(() -> {
                practiseOnRaceCondition.increase();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Current thread is interrupted "+Thread.currentThread().getName());
                }
                practiseOnRaceCondition.increase();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Current thread is interrupted "+Thread.currentThread().getName());
                }
                practiseOnRaceCondition.increase();
            });
            myThreads[i]=thread;
        }

        for( Thread thread: myThreads){
            thread.start();
        }
        //tellling main thread to wait till all above threads finish.
        for(Thread thread:myThreads){
            thread.join();
        }

        System.out.println("Final outcome of id is "+ practiseOnRaceCondition.id);
        System.out.println("It should have been "+myThreads.length*3);
    }
}

package mythread.practise.randomclassesforpractise;

public class PractiseThreadJoin {

    int i=0;
    public void print() throws InterruptedException {
        while(i<50){
            if(i==20 || i==30 || i==40) {
                System.out.println("Join called by "+ Thread.currentThread().getName());
                Thread.currentThread().join(500);
            }
            else {
                System.out.println("i value is  "+i+" Thread is "+ Thread.currentThread().getName());
            }
            i++;
        }
        System.out.println("Loop Completed for "+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {

        PractiseThreadJoin practiseThreadJoin= new PractiseThreadJoin();
        Thread[] threads= new Thread[50];
        for(int j=0;j<50;j++) {
            Thread thread = new Thread(() -> {
                try {
                    practiseThreadJoin.print();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted in Thread "+Thread.currentThread().getName());
                }
            });
            threads[j]=thread;
        }
        for(Thread thread:threads){
            thread.start();
        }

        //tellling main thread to wait till all above threads finish.
        for(Thread thread:threads){
            thread.join();
        }
    }
}

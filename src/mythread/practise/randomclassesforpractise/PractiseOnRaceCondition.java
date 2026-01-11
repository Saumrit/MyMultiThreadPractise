package mythread.practise.randomclassesforpractise;

public class PractiseOnRaceCondition {

    int id=0;
    public void increase(){
        this.id++;
    }

    public static void main(String[] args) throws InterruptedException {
        PractiseOnRaceCondition practiseOnRaceCondition= new PractiseOnRaceCondition();

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

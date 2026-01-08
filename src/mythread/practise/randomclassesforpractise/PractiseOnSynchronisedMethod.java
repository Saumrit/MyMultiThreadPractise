package mythread.practise.randomclassesforpractise;

public class PractiseOnSynchronisedMethod {
    int count=50;

    public synchronized void increase(){
        while(count<100) {
            count++;
            System.out.println("count "+count+" increased by " + Thread.currentThread().getName());
        }
    }

    public synchronized void decrease(){
        while(count>0) {
            count--;
            System.out.println("count "+count+" decreased by " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PractiseOnSynchronisedMethod practiseOnSynchronisedMethod= new PractiseOnSynchronisedMethod();

        Thread t1= new Thread(() -> {
            practiseOnSynchronisedMethod.increase();
        });
        Thread t2= new Thread(() -> {
            practiseOnSynchronisedMethod.decrease();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("=======================");
        System.out.println("Done and final value of count is "+practiseOnSynchronisedMethod.count);
        System.out.println("========================");
    }

}

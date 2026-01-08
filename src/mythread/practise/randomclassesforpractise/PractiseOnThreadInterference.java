package mythread.practise.randomclassesforpractise;

/**
 * No Synchronize method here, henceclass level data gets shared across threads and data is inconsistent
 */
public class PractiseOnThreadInterference {
    int count=50;

    public void increase(){
        while(count<100) {
            count++;
            System.out.println("count "+count+" increased by " + Thread.currentThread().getName());
        }
    }

    public void decrease(){
        while(count>0) {
            count--;
            System.out.println("count "+count+" decreased by " + Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        PractiseOnThreadInterference practiseOnThreadInterference= new PractiseOnThreadInterference();

        Thread t1= new Thread(() -> {
            practiseOnThreadInterference.increase();
        });
        Thread t2= new Thread(() -> {
            practiseOnThreadInterference.decrease();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("=======================");
        System.out.println("Done and final value of count is "+practiseOnThreadInterference.count);
        System.out.println("========================");
    }
}

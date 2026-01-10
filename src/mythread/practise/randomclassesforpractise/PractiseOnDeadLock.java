package mythread.practise.randomclassesforpractise;

public class PractiseOnDeadLock {

    int a=0;
    int b=0;

    public synchronized void increaseA(){
        System.out.println("Entered method A...");
        if(b>0) {
            System.out.println("Increased A...");
            a = 1;
        }
        else{
            System.out.println("A can't be increased as B is still 0...Calling IncreaseB()");
            increaseB();
        }
    }

    public synchronized void increaseB(){
        System.out.println("Entered method B...");
        if(a>0) {
            System.out.println("Increased B...");
            b = 1;
        }
        else{
            System.out.println("B can't be increased as A is still 0...Calling IncreaseA()");
            increaseA();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        PractiseOnDeadLock practiseOnDeadLock= new PractiseOnDeadLock();
        Thread producer= new Thread(() ->{
                practiseOnDeadLock.increaseA();
        });
        Thread consumer= new Thread(() ->{
                practiseOnDeadLock.increaseB();

        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

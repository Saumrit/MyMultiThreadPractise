package mythread.practise.randomclassesforpractise;

public class PractiseThreadSleep {

    int i=10;
    String name;
    int age;
    public PractiseThreadSleep() {
    }
    public PractiseThreadSleep(int i, String name, int age) {
        this.i = i;
        this.name = name;
        this.age = age;
    }
    public void print() throws InterruptedException {
        for(int i=1;i<100;i++){
            System.out.println("Printing i= "+i+" By thread "+Thread.currentThread().getName());
            if(i==20|| i==40 || i==60 ||i==80) {
                System.out.println("Cuurent thread "+Thread.currentThread().getName() +" is sleeping");
                Thread.sleep(2000);
            }
        }
    }
    public static void main(String[] args) {
        PractiseThreadSleep practiseThreadSleep = new PractiseThreadSleep();
        Thread t1= new Thread(() -> {
            try {
                practiseThreadSleep.print();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" is interrupted");
            }
        });
        Thread t2= new Thread(() -> {
            try {
                practiseThreadSleep.print();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" is interrupted");
            }
        });
        Thread t3= new Thread(() -> {
            try {
                practiseThreadSleep.print();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" is interrupted");
            }
        });
        t1.start();t2.start();t3.start();
    }
}

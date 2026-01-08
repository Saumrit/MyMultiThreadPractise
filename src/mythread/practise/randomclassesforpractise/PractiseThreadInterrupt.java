package mythread.practise.randomclassesforpractise;

public class PractiseThreadInterrupt {

    int i=0;
    String name;
    int age;
    public PractiseThreadInterrupt() {
    }
    public PractiseThreadInterrupt(int i, String name, int age) {
        this.i = i;
        this.name = name;
        this.age = age;
    }
    public void print() throws InterruptedException {
        for( i=1;i<100;i++){
            System.out.println("Printing i= "+i+" By thread "+Thread.currentThread().getName());
            if(i==20|| i==40 || i==60 ||i==80) {
                System.out.println("Current thread "+Thread.currentThread().getName() +" will sleep now");
                Thread.sleep(3000);
            }
            if(i==30|| i==50 || i==66 ||i==85) {
                //System.out.println("Current thread "+Thread.currentThread().getName() +" will be interrupted now and status of interrupt is "+Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PractiseThreadInterrupt practiseThreadInterrupt= new PractiseThreadInterrupt();
        Thread t1= new Thread(() -> {
            try {
                practiseThreadInterrupt.print();
            } catch (InterruptedException e) {
                System.out.println("================");
                System.out.println(Thread.currentThread().getName()+" has been interrupted and its interrupt status is "+Thread.currentThread().isInterrupted());
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("================");
                    System.out.println(Thread.currentThread().getName()+" will be recovered  and start now");
                    System.out.println("================");
                    Thread.currentThread().start();
                    System.out.println(Thread.currentThread().getName()+"started thread");

                }
            }
        });
        Thread t2= new Thread(() -> {
            try {
                practiseThreadInterrupt.print();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" is interrupted");
            }
        });
        Thread t3= new Thread(() -> {
            try {
                practiseThreadInterrupt.print();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" is interrupted");
            }
        });
        t1.start();t2.start();t3.start();

        Thread.sleep(120000);
    }
}

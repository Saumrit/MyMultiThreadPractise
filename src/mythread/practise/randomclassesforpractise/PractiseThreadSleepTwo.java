package mythread.practise.randomclassesforpractise;

public class PractiseThreadSleepTwo {

    public boolean flag=false;
    public int i=0;
    public void methodFirst() throws InterruptedException {

        while(this.flag && i<50) {

            System.out.println("Flag is true with i="+i+" by thread "+Thread.currentThread().getName());
            if(i%2==0)
                Thread.sleep(500);
            if(i==9) {
                System.out.println(Thread.currentThread().getName()+" called interrupt");
                Thread.currentThread().interrupt();
            }
            if(i>13)
                this.flag=false;
            else
                this.flag=true;
            i++;
        }
        System.out.println("loop finished for "+ Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        PractiseThreadSleepTwo practiseThreadSleepTwo= new PractiseThreadSleepTwo();
        Thread[] threads= new Thread[50];
        for(int j=0;j<50;j++){
            Thread thread= new Thread(() -> {
                try {
                    practiseThreadSleepTwo.flag=true;
                    practiseThreadSleepTwo.methodFirst();
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted, Value of i is "+practiseThreadSleepTwo.i+" "+Thread.currentThread().getName());
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

package mythread.practise.randomclassesforpractise;

public class PractiseThreadCreate {
    int i=10;
    String name;
    int age;

    public PractiseThreadCreate() {
    }

    public PractiseThreadCreate(int i, String name, int age) {
        this.i = i;
        this.name = name;
        this.age = age;
    }


    public static void main(String[] args) throws InterruptedException {
        PractiseThreadCreate p= new PractiseThreadCreate();
        Thread[] myThreads = new Thread[100];
        for(int i=0;i<100;i++){
            Thread thread= new Thread(()->{
                System.out.println("Inside theread with name " +Thread.currentThread().getId());
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
    }
}

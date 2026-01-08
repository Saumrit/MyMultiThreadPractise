package mythread.practise.randomclassesforpractise;

public class PractiseThreadSharingVariableExample {

    public int id=0;
    public String name;

    public void setvariables(){
        System.out.println("Set Method is Entered By "+Thread.currentThread().getName());
        this.id++;
        this.name= Thread.currentThread().getId()+"";
        System.out.println("id is "+this.id+ " & name is "+this.name+" & hashcode is "+this.hashCode());
        this.id= this.id+1;
    }

    public static void main(String[] args) throws InterruptedException {
        PractiseThreadSharingVariableExample practiseThreadSharingVariableExample= new PractiseThreadSharingVariableExample();
        Thread[] threads= new Thread[1500];
        for(int j=0;j<1500;j++){
            Thread t= new Thread(()->{
                practiseThreadSharingVariableExample.setvariables();
            });
            threads[j]=t;
        }

        for(Thread tt:threads){
            tt.start();
        }

        for(Thread tt:threads){
            tt.join();
        }

        System.out.println("id is "+practiseThreadSharingVariableExample.id+
                " & name is "+practiseThreadSharingVariableExample.name+
                " & Thread name is "+Thread.currentThread().getName());
    }
}

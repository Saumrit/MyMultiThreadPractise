package mythread.practise.randomclassesforpractise;

public class PractiseOnThreadmemoryModel extends Thread{

    AddressOperarion addressOperarion= AddressOperarion.getInstance();

    @Override
    public void run() {
        addressOperarion.registerNewAddress();
        printCommonLocalVariable(Thread.currentThread().getName());
        printThreadSpecificVariable(Thread.currentThread().getName());
    }
    public void printCommonLocalVariable(String j){
        System.out.println("Printing from "+Thread.currentThread().getName()+" Thread's own method print()");
    }
    public void printThreadSpecificVariable(String j){
        AddressDTO addressDTO= new AddressDTO();
        System.out.println("This address "+addressDTO+" is specific to "+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads= new Thread[200];
        for(int i=0;i<100;i++){
            PractiseOnThreadmemoryModel practiseOnThreadmemoryModel= new PractiseOnThreadmemoryModel();
            threads[i]=practiseOnThreadmemoryModel;
        }

        for(Thread thread:threads){
            thread.start();
        }
        for(Thread thread:threads){
            thread.join();
        }
    }

}

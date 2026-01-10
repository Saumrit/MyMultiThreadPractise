package mythread.practise.randomclassesforpractise;

public class ProducerConsumerProblem {

    Item[] items=new Item[20];

    public synchronized void produce() throws InterruptedException {
        System.out.println("Production starts...");
        for(int i=0;i<20;i++){
            items[i]= new Item(i,Thread.currentThread().getName());
            System.out.println("Items added "+i);
        }
        System.out.println("Production ends...");
        System.out.println("last item produced is :"+items[19]);
        Thread.currentThread().wait();
        Thread.currentThread().notifyAll();
    }

    public synchronized void  consume() throws InterruptedException {
        System.out.println("Consumption starts...");
        for(int i=0;i<20;i++){
            items[i]= null;
            System.out.println("Items consumed "+i);
        }
        System.out.println("Consumption ends...");
        System.out.println("last item consumed is :"+items[19]);
        Thread.currentThread().wait();
        Thread.currentThread().notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerProblem producerConsumerProblem= new ProducerConsumerProblem();
        Thread producer= new Thread(() ->{
            try {
                producerConsumerProblem.produce();
                producerConsumerProblem.produce();
                producerConsumerProblem.produce();
            } catch (InterruptedException e) {
                System.out.println("Producer Interrupted");
            }
        });

        Thread consumer= new Thread(() ->{
            try {
                producerConsumerProblem.consume();
                producerConsumerProblem.consume();
                producerConsumerProblem.consume();
            } catch (InterruptedException e) {
                System.out.println("Consumer Interrupted");
            }
        });

        producer.start();
        consumer.start();

//        producer.join();
//        consumer.join();
    }
}

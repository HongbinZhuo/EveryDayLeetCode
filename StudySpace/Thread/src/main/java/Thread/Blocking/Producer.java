package Thread.Blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

    private BlockingQueue<String> bq;
    Producer(BlockingQueue<String> bq){
        this.bq=bq;
    }

    public void run(){
        String[] strArr=new String[]{
                "JAVA","Struts","Spring"
        };
        for (int i = 0; i < 999999999999l; i++) {
            System.out.println(getName()+"生产者准备生产集合元素");

            try {
                Thread.sleep(2000);

                bq.put(strArr[i%3]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"生产完成"+bq);
        }
    }
}
class Consumer extends Thread{

    private BlockingQueue<String> bq;
    Consumer(BlockingQueue<String> bq){
        this.bq=bq;
    }

    public void run(){
        while(true){
            System.out.println(getName()+"消费者准备消费集合元素");

            try {
                Thread.sleep(2000);

                bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"消费完成"+bq);
        }
    }
}


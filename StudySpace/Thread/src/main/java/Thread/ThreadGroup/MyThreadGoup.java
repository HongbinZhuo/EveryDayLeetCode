package Thread.ThreadGroup;

public class MyThreadGoup extends Thread {


    public MyThreadGoup(String name){
        super(name);
    }

    public MyThreadGoup(ThreadGroup group,String name){
        super(group,name);
    }
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(getName()+"线程的i变量"+i);
        }
    }
}

package Thread;

public class StartDead extends Thread{
    private int i=0;
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) {

        StartDead startDead = new StartDead();
        for (int i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            if(i==20){
                startDead.start();
                System.out.println(startDead.isAlive());
            }
            if (i>20 && !startDead.isAlive()) {
//             尝试在线程死亡后 再次 start 将引发IllegalThreadStateException
                startDead.start();
            }
        }
    }
}

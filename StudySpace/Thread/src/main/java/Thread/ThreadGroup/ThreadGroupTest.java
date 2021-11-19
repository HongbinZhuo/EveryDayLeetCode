package Thread.ThreadGroup;

public class ThreadGroupTest  {
    public static void main(String[] args) {
        ThreadGroup mainGroup= Thread.currentThread().getThreadGroup();
        System.out.println("主线程名字"+mainGroup.getName());

        System.out.println("主线程是否为后台线程"+mainGroup.isDaemon());

        ThreadGroup tg= new ThreadGroup("新线程组");
        tg.setDaemon(true);
        System.out.println("tg线程是否为后台线程"+tg.isDaemon());

        MyThreadGoup tt =new MyThreadGoup(tg,"tg组的线程甲");
        tt.start();
        new MyThreadGoup(tg,"tg组的线程乙").start();
    }
}

package Thread.LockCondition;

import Thread.notify.Account;
import Thread.notify.DrawThread;

public class DrawTestMain {
    public static void main(String[] args) {
        Account ac=new Account("123",0);
        new DrawThread("取钱者",ac,800).start();
        new DepositThread("存款者甲",ac,800).start();
        new DepositThread("存款者乙",ac,800).start();
        new DepositThread("存款者丙",ac,800).start();

    }
}

package Thread.LockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    //显示定义Lock
    private final Lock lock=new ReentrantLock();
    //指定Lock对象对应的Condition
    private final Condition cond=lock.newCondition();

    private  String accountNo;
    private  double balance;

    private boolean flag=false;

    public Account(){

    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public double getBalance(){
        return  this.balance;
    }
    public   void draw(double drawAmount){
        //加锁
        lock.lock();
        try {
            if(!flag){
            cond.await();
            }else {
                System.out.print(Thread.currentThread().getName()+" 取钱 "+drawAmount);
                balance -=drawAmount;
                System.out.println("    账户余额为："+balance);

                flag=false;

                cond.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void deposit(double depositAmount){
        lock.lock();
        try {
            if(flag){
               cond.await();
            }
            else{
                System.out.print(Thread.currentThread().getName()+" 存款 "+depositAmount);
                balance +=depositAmount;
                System.out.println("    账户余额为："+balance);

                flag=true;
                cond.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}

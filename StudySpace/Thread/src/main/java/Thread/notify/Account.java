package Thread.notify;

public class Account {
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
    public synchronized  void draw(double drawAmount){
        try {
            if(!flag){
             wait();
            }else {
                System.out.print(Thread.currentThread().getName()+" 取钱 "+drawAmount);
                balance -=drawAmount;
                System.out.println("    账户余额为："+balance);

                flag=false;

                notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount){
        try {
            if(flag){
                wait();
            }
            else{
                System.out.print(Thread.currentThread().getName()+" 存款 "+depositAmount);
                balance +=depositAmount;
                System.out.println("    账户余额为："+balance);

                flag=true;
                notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

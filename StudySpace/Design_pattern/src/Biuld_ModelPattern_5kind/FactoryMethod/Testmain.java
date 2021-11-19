package Biuld_ModelPattern_5kind.FactoryMethod;

public class Testmain {
    public static void main(String[] args) {
/*        根据str匹配创建产品
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();
*/

//        采用静态的工厂方法
        Sender sender = SendFactory.produceMail();
        sender.Send();

    }

}

package Biuld_ModelPattern_5kind.FactoryMethod;

public class SendFactory {
//    public Sender produce(String type) {
//        if ("mail".equals(type)) {
//            return new MailSender();
//        } else if ("sms".equals(type)) {
//            return new SmsSender();
//        } else {
//            System.out.println("请输入正确的类型!");
//            return null;
//        }
        public static Sender produceMail(){
            return new MailSender();
        }

        public Sender produceSms(){
            return new SmsSender();
        }

}

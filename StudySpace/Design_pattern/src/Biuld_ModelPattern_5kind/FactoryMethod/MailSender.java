package Biuld_ModelPattern_5kind.FactoryMethod;


public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }
}
package Biuld_ModelPattern_5kind.AbstractFactory;

public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}

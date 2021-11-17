package com.zhb.othertechnology.src.Biuld_ModelPattern_5kind.AbstractFactory;


public class SendSmsFactory implements Provider {

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}

package com.zhb.othertechnology.src.Biuld_ModelPattern_5kind.AbstractFactory;

public class SmsSender implements Sender {

    @Override
    public void Send() {

        System.out.println("this is sms sender!");
    }
}
package com.zhb.othertechnology.src.Biuld_ModelPattern_5kind.AbstractFactory;

public class Testmain {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
    /*
   抽象工厂： 如果你现在想增加一个功能：发及时信息，则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！

好处：如果有新的类进来，只需要添加一个对应的具体工厂类，不影响现有代码，增加了程序的扩展性
缺点：增加了代码量
    * */
}

package Thread.notify;

public  class main {
    public static void main(String[] args) {

        new B("A");

    }
}

class A {
   String name;
   A() {
       System.out.println(1);
   }

   A(String name) {
       this.name = name;
       System.out.println(2);
   }
}
class B extends A{
   B() {
        System.out.println(3);
    }

    B(String name) {
        this.name = name;
        A a=new A();
        System.out.println(4);
    }
}



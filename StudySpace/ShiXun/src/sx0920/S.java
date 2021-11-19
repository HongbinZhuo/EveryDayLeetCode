package sx0920;

 class S {
    public static void main(String[] args) {
        A x=new B();
        x.f();
        System.out.println(x.q);

    }
}
 class A{
   int q=5;
   void f(){
       System.out.println("A.f");
   }
}
class B extends A{
    int q=6;

    void f(){
        System.out.println("B.f");

    }
    void g(){
        System.out.println("B.g");
    }
}
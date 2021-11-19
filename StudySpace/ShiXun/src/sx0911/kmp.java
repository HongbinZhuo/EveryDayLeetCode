package sx0911;

import java.util.Scanner;

public class kmp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        boolean c=false;
        if(!a.isEmpty()){
            c=a.contains(b);
        }
        System.out.println(c);
        show();
    }

    private static void show() {
    }


}

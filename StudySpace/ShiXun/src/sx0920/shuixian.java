package sx0920;

import java.util.Scanner;

public class shuixian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        for (int i = 1; i < a; i++) {
            if (IsShuixian(i)==1)
        System.out.print(i+"   ");
    }
}

    private static int IsShuixian(int a) {
        String b=Integer.toString(a);
        int s=0;
        for (int i = 0; i < b.length(); i++) {
            s  +=  Math.pow((int)(b.charAt(i)-'0'),3);
        }

        if (s==a) return 1;

        else {
            return 0;
        }


    }
}

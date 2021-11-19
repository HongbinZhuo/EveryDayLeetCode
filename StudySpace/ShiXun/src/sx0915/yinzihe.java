package sx0915;

public class yinzihe {
    public static void main(String[] args) {
        for (int i = 2; i <= 10000; i++) {
            int s = 0;
//            到i/2的循环判断 下面改进ath.sqrt(i)
//            for (int j = 1; j <= i/2; j++) {
//                       if(i%j==0) s=s+j;
//            }
//            if(s==i) System.out.println(i);
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (j == i / j) {
                        s = s + j;
                    } else if (j == 1) {
                        s = s + 1;
                    } else {
                        s = s + j + (i / j);
                    }
                }
            }
            if (s == i) System.out.println(i);
        }
    }
}

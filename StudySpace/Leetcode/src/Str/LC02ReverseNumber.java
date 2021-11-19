package Str;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/27 15:05
 */
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
public class LC02ReverseNumber {
    public static void main(String[] args) {
      int a=1534236469;
        System.out.println();
      System.out.println( reverse(a));
    }

    public static int reverse(int x) {


        long result=0;
//        int flag=1;
//        if (x<0){ flag=-1;}
//        x=Math.abs(x);
        while(x != 0){
          result = result *10 + ( x % 10 );
          x=x/10;
        }
//         result *=flag;
        return (int)result==result?(int)result:0;

    }
}

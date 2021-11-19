package sx0911;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        int k;
        int i=1;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n > i){
            n=n-i;
            i++;
        }

       /* int x,y;
        x=n-1;
        y=(i-1)-x;*/
       System.out.println("模块"+i);
        System.out.println("模块第"+n);
        if(i%2==0)
            System.out.println(n+"/"+(i-n+1));
        else
            System.out.println((i-n+1)+"/"+n);
    }
}

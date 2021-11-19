package other;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/30 10:46
 */
public class CountPrimes {
    public static void main(String[] args) {
      countPrimes(10);
    }
    public static  int countPrimes(int n) {
        if(n==0 || n==1) return 0;
        int num=0;
        for(int i=2 ;i<n;i++){
            if(iszhishu(i)) num++;
        }
        return num;

    }
    public static boolean iszhishu(int i){
        for(int j=2;j<=Math.sqrt(i);j++){
            if(i%j==0) return false;
        }
        return  true;
    }
}

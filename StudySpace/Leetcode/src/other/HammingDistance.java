package other;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/30 15:57
 */
public class HammingDistance {
    public static void main(String[] args) {
     hammingDistance(1,4);
    }
    public static int hammingDistance(int x, int y) {
        int s=x^y;
        int mask=1;
        int count=0;
        for (int i = 0; i < 32; i++) {
            if((s&mask)==mask) count++;
            mask <<=1;
        }
    return count;
    }
}

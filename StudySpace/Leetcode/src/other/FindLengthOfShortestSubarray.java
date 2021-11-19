package other;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/1 14:29
 */
public class FindLengthOfShortestSubarray {

    public static void main(String[] args) {
        int[] arr=new int[]{2,3,1,3,1};
    findLengthOfShortestSubarray(arr);
    }
    public static int findLengthOfShortestSubarray(int[] arr) {
        //3种情况  删左边
        //删右边
        //删中间
        //考虑删除右边  即需要让左边有序
        int left = 0;
        int N = arr.length;
        while(left<N-1&&arr[left]<=arr[left+1]){
            left++;
        }
        if(left == N-1) return 0;

        //考虑让右边有序
        int right = N-1;
        while(right>=1&&arr[right]>=arr[right-1])   right--;

        int ans = Math.min(right, N-left-1);

        //删除中间
        //【1，2，3，10，5，4，2，3，5】   right = 5  即右边完全有序    left = 4 即 左边完全有序 保证左右有序的基础上 找到中间  使得arr[i]<=arr[j]
        int i = 0,j = right;
        for(;i<=left&&j<N;){
            if(arr[i]<=arr[j]){
                ans = Math.min(ans,j-i-1);
                i++;
            }else{
                j++;
            }
        }
        return ans;
    }

}

package other;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/29 20:45
 */
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
    //初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
//你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

public class MergeTwoArray {
    public static void main(String[] args) {
        int[] nums1=new int[]{1,2,3,0,0,0};
        int[] nums2=new int[]{2,5,6};

        merge(nums1,3,nums2,3);
        System.out.println(nums1);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1,p2=n-1,p=m+n-1;
        while(p2>=0){
            if(p1>=0&&nums1[p1]>nums2[p2]){
                nums1[p--] = nums1[p1--];
            }else{
                nums1[p--] = nums2[p2--];
            }
        }

    }
}

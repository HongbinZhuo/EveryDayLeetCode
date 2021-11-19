package PaiXu;

import List.ListNode;

import java.util.Arrays;

//归并排序
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        mergeSort(array);

        System.out.println(Arrays.toString(array));
    }


    public static void mergeSort(int[] array) {
        //为空 或者只有一个元素直接返回
        if (array == null || array.length<=1){
            return;
        }
        sort(array,0,array.length-1);

    }

    private static void sort(int[] array, int left, int right) {

      if(left == right){
          return;
      }
         //右移一位  即除以二舍弃小数部分（取整）
      int mid=left+((right-left)>>1);
      // 对左侧子序列进行递归排序
      sort(array, left , mid);
      // 对右侧子序列进行递归排序
      sort(array, mid+1,right);
      //合并
      merge(array,left,mid,right);

    }

    private static void merge(int[] array, int left, int mid, int right) {
        //新建一个temp在存储的排序数组
        int[]   temp=new int[right - left+1];

        //数组下标变量
        int i=0;

        //p1扫描 0-mid
        int p1=left;

        //p2扫描 mid+1 - right  ||||      <= mid 为一段， >mid后为一段
        int p2=mid+1;

        while (p1<=mid && p2<=right){
            //扫描两段中的比较 排序复制到temp中
            temp[i++] = array[p1] < array[p2] ?array[p1++]:array[p2++];

        }

        while (p1<=mid){
        // 如果 p1没扫描完 继续扫描p1 复制到temp
            temp[i++]=array[p1++];
        }

        while (p2<=right){
         //如果 p2 没扫描完 继续扫描p2 复制到temp中
            temp[i++]=array[p2++];
        }

        for ( i = 0; i < temp.length; i++) {
        // 将排序完 的temp 复制到array [left+1] 开始
            array[left+i]=temp[i];

        }
    }





    public ListNode sortList(ListNode head) {
        // 1、递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2、找到链表中间节点并断开链表 & 递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3、当前层业务操作（合并有序链表）
        return mergeTwoLists(left, right);
    }

    //  找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }

}

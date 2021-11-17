package com.zhb.leetcodebasic.src.PaiXu.LinkSort;

import com.zhb.leetcodebasic.src.List.ListNode;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/9 8:54
 */
public class LinkedMergeSort {

     public ListNode mergeSort(ListNode head){
         if(head==null|| head.next==null) return head;

         ListNode mid=  getMid(head);

         ListNode second=mid.next;
         mid.next=null;

         ListNode left= mergeSort(head);
         ListNode right=mergeSort(second);

         return merge(right,left);

     }

      //合并两个链表
    private ListNode merge(ListNode right, ListNode left) {
        //dumy辅助头结点、 排序号的结点将会连接到dumy后面
         ListNode dumy=new ListNode(0);
         ListNode tail= dumy;

         while (right!=null && left!=null){
             if(right.val<=left.val){
               tail.next=right;
               right=right.next;

             }else {
                tail.next=left;
                left=left.next;
             }
                tail=tail.next;
         }
         //将 长链 的剩余部分接到排序好的链之后
         if(right != null){
             tail.next=right;
         }else {
//             if(left!=null)
             tail.next=left;
          }

          return dumy.next;

    }

    //使用快慢两部指针获得中点mid
    private ListNode getMid(ListNode head) {
         if(head==null || head.next==null)  return head;

         ListNode slow= head;
         ListNode fast=head.next;
         while (fast!=null && fast.next!=null){
             slow=slow.next;
             fast=fast.next.next;
         }
         return  slow;


    }
}

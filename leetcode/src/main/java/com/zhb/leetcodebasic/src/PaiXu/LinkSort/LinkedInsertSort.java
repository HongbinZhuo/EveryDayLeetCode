package com.zhb.leetcodebasic.src.PaiXu.LinkSort;

import com.zhb.leetcodebasic.src.List.ListNode;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/8 16:32
 */
public class LinkedInsertSort {



    public  static ListNode insertionSortList(ListNode head){

        if(head==null||head.next==null) return head;

        ListNode pre=head;  //pre指向已经有序的节点
        ListNode cur=head.next;//cur指向待排序的节点
        ListNode aux=new ListNode(-1); //辅助结点  头结点
        aux.next=head;

        while(cur!=null) {

            if (cur.val < pre.val) {
                //先将cur现节点从链表中删除。然后再把cur结点插入到合适的位置
                pre.next = cur.next;

                //从头寻找cur应当插入的位置
                ListNode l1 = aux;
                ListNode l2 = aux.next;

                while (cur.val > l2.val) {
                    // l1为l2前节点
                    l1 = l2;
                    l2 = l2.next;
                }
                //l2找到>=cur的结点
                //cur接到l1后面
                l1.next = cur;
                //l2接到cur的后面 形成一条链
                cur.next = l2;


                cur = pre.next;
            } else {

                pre = cur;
                cur = cur.next;

            }
        }
            return aux.next;
    }


}

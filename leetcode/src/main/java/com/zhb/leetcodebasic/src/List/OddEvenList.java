package com.zhb.leetcodebasic.src.List;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/6 15:47
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode evenHead = head.next;

        ListNode odd = head, even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;



    }

}

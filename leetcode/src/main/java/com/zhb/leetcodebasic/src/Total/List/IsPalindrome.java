package com.zhb.leetcodebasic.src.Total.List;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/6 15:25
 */
public class IsPalindrome {



    public boolean isPalindrome(ListNode head) {
        ListNode fast=head,slow=head;
        ListNode pre = null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;

            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        if(fast != null) {
            slow = slow.next;
        }

        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;

    }



    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;
    }
}

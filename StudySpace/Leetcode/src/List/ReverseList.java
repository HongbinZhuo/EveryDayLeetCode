package List;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/6 15:16
 */
public class ReverseList {
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

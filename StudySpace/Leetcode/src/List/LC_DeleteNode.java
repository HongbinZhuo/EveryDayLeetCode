package List;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2020/12/28 17:54
 */
public class LC_DeleteNode {
    public void deleteNode(ListNode node) {

       node.val=node.next.val;
       node.next=node.next.next;
    }
}

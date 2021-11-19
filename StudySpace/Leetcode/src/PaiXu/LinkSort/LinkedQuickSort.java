package PaiXu.LinkSort;

import List.ListNode;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/9 9:23
 */
//单链表不适合快排
public class LinkedQuickSort {
    public static void main(String[] args) {
        int[] arr= {3, 4, 9, 1, 5, 2, 8, 0, 6, 7};
        //第一个头结点
        ListNode head =new ListNode(arr[0],null );
        //辅助结点
        ListNode temp=head;
        ListNode x=null;
        for (int i = 1; i < arr.length; i++) {
            ListNode p=new ListNode();
            p.val=arr[i];
            p.next=null;
            temp.next=p;
            temp=temp.next;
            if (i==5){
                x=p;
            }
        }



        printList(head);
        quickSortList(head);
        System.out.println("");
        printList(head);
    }


    private static void printList(ListNode head) {
        while(head!=null){
            System.out.print(head.val);
            head=head.next;
        }
    }

   static ListNode quickSortList(ListNode head){
        //链表快排
        if(head==null || head.next==null) return head;
        qsortList(head,null);
        return  head;

    }

    static private void qsortList(ListNode head, ListNode tail) {
       //链表范围[low，higt）左闭右开区间
        if(head !=tail && head.next!= tail){
            ListNode mid=partionList(head,tail);
            qsortList(head,mid);
            qsortList(mid.next,tail);
        }

    }

   static private ListNode partionList(ListNode left, ListNode right) {
        int key=left.val;
        ListNode p=left;
        for(ListNode q=left.next;q!=right;q=q.next){
            if(q.val<key){
                p=p.next;
                //swap(q.val,p.val)
                int temp=q.val;
                q.val=p.val;
                p.val=temp;
            }
        }
        //swap(p.val, left.val)
        int temp=left.val;
        left.val=p.val;
        p.val=temp;

        return p;
    }

}

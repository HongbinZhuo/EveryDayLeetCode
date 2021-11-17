package com.zhb.leetcodebasic.src.other;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/4 11:33
 */

//二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
//偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
//奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
public class IsEvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        int level=-1;
        if (root==null) return false;
        Queue<TreeNode> queue=new LinkedList<>();
        //添加到队列
        queue.offer(root);
        while (!queue.isEmpty()){
            int size =queue.size();
            level++;
            int pre;
            int flag=level%2;
            if(flag==0){ //偶数层,奇数递增
                pre = Integer.MIN_VALUE;
            } else {
                pre = Integer.MAX_VALUE;
            }
            for (int i = 0; i < size; i++) {
                TreeNode temp=queue.poll();
                if(temp.val%2==flag) return false;
                if(flag==0 && pre>=temp.val)return false;
                if(flag==1 && pre<=temp.val)return false;
                pre =temp.val;
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
            }
        }
        return  true;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

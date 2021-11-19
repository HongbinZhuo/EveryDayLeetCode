package other;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/5 16:25
 */

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
public class trap {
    public static void main(String[] args) {
     int[] hights= new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
     trap(hights);
    }
    public static int trap(int[] height) {
        int len=height.length;
        if(len==0 || height==null) return 0;
        int res=0;

        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < len; i++) {
            while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int top=stack.pop();
                if(stack.isEmpty()) break;;
                int distance=i-stack.peek()-1;
                int bounded_height=Math.min(height[i],height[stack.peek()]-height[top]);
                res+=distance*bounded_height;
            }
            stack.push(i);
        }
        return res;
    }
}

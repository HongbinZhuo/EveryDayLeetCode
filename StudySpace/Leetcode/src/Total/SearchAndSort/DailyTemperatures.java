package Total.SearchAndSort;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/8 15:10
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures(nums);
    }

    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;

    }
}


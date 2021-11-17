package com.zhb.leetcodebasic.src.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zhuohongbin
 * @Description TODO
 * @Date 2021/1/1 14:05
 */
public class YangHuiSanJiao {

    public static void main(String[] args) {
         generate(3);

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row= new ArrayList<>();
            for(int j=0;j<i;j++){
                if(j==0 || j==i){
                    row.add(1);
                }else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return  ret;



    }
}

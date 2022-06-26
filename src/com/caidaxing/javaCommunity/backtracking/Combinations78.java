package com.caidaxing.javaCommunity.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/06/20/14:12
 * @Description: 78.子集
 */
public class Combinations78 {
    /**
     * 存放最终组合的结果
     */
    List<List<Integer>> res = new ArrayList<>();
    /**
     * 记录回溯的路径
     */
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 按数组子集里的元素个数不同来划分
        for(int i = 0; i <= nums.length; i ++) {
            backtrack(i, 0, nums);
        }
        return res;
    }

    private void backtrack(int size, int start, int[] nums) {
        if(tmp.size() == size) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start; i < nums.length; i ++) {
            tmp.add(nums[i]);
            backtrack(size, i + 1, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}

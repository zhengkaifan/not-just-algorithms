package com.caidaxing.javaCommunity.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/06/18/21:12
 * @Description: 39. 组合总和
 */
public class Combinations39 {
    /**
     * 存放最终组合的结果
     */
    List<List<Integer>> res = new ArrayList<>();
    /**
     * 记录回溯的路径
     */
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) {
            return res;
        }
        backtrack(candidates,target, 0);
        return res;
    }

    void backtrack(int[] candidates, int target, int start) {
        // 找到目标和
        if(target == 0) {
            res.add(new ArrayList<>(tmp));
        }
        for(int i = start; i < candidates.length; i ++) {
            if(candidates[i] <= target) {
                tmp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

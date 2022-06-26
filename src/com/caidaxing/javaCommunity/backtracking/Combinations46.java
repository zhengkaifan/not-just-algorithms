package com.caidaxing.javaCommunity.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/06/26/16:00
 * @Description: 46. 全排列
 */
public class Combinations46 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        fullPermutation(res, nums, tmp, visited);
        return res;
    }

    private void fullPermutation(List<List<Integer>> res, int[] nums, List<Integer> tmp, boolean[] visited) {
        // 说明找到了一组
        if(tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i ++) {
            if(visited[i]) {
                continue;
            }
            // 做选择
            visited[i] = true;
            tmp.add(nums[i]);
            fullPermutation(res, nums, tmp, visited);
            // 撤销选择
            tmp.remove(tmp.size()- 1);
            visited[i] = false;
        }
    }

}

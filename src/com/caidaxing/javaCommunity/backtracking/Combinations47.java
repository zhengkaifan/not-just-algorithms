package com.caidaxing.javaCommunity.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/06/29/23:21
 * @Description: 47. 全排列 II
 */
public class Combinations47 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        fullPermutation(nums, visited);
        return res;
    }

    private void fullPermutation(int[] nums, boolean[] visited) {
        // 说明找到了一组
        if(tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i ++) {
            if(visited[i]) {
                continue;
            }
            // 固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            // 做选择
            visited[i] = true;
            tmp.add(nums[i]);
            fullPermutation(nums, visited);
            // 撤销选择
            tmp.remove(tmp.size()- 1);
            visited[i] = false;
        }
    }

}

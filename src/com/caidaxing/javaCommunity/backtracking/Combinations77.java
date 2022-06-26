package com.caidaxing.javaCommunity.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/06/14/23:38
 * @Description: 77. 组合
 */
public class Combinations77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combines = new ArrayList<>();
        // 记录回溯算法的递归路径
        List<Integer> combineList = new ArrayList<>();
        backtracking(combineList, combines, 1, k, n);
        return combines;
    }

    private void backtracking(List<Integer> combineList, List<List<Integer>> combines, int start, int k, int n){
        if(k == 0) {
            // 遍历到了第 k 层，收集当前节点的值
            combines.add(new ArrayList<>(combineList));
            return;
        }
        for(int i = start; i <= n - k + 1 ; i ++) {
            // 选择
            combineList.add(i);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtracking(combineList, combines, i + 1, k - 1, n);
            // 撤销选择
            combineList.remove(combineList.size() - 1);
        }
    }
}

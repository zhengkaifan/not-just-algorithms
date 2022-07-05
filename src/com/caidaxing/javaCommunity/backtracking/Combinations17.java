package com.caidaxing.javaCommunity.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 慢跑的猫不吃鱼
 * @Date: 2022/07/05/22:45
 * @Description: 17. 电话号码的字母组合
 */
public class Combinations17 {
    // 每个数字到字母的映射
    String[] KEYS = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    // 存放组合
    List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return combinations;
        }
        // 开始回溯
        Permutation(new StringBuilder(), digits);
        return combinations;
    }

    private void Permutation(StringBuilder stringBuilder, String digits) {
        if (stringBuilder.length() == digits.length()) {
            // 到达回溯树底部
            combinations.add(stringBuilder.toString());
            return;
        }
        int cur = digits.charAt(stringBuilder.length()) - '0';
        String tmp = KEYS[cur];
        for(char t : tmp.toCharArray()){
            stringBuilder.append(t);
            Permutation(stringBuilder, digits);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

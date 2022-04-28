package com.caidaxing.javaCommunity;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: caidaxing
 * @Date: 2022/04/28/16:11
 * @Description: 滑动窗口最大值
 */
public class Code239 {

    public static void main(String[] args) {
        int []nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new Solution239().maxSlidingWindow(nums, k);
        for (int i : res) {
            System.out.println(i);
        }
    }

}

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) {
            return nums;
        }
        int n = nums.length;
        /*
        优先队列
        排序规则：
            如果数字大小不同，后面的元素 - 前面的元素
            如果它们的值相同，就用它们的索引值相减
        * */
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] n1, int[] n2) {
                return n1[0] != n2[0] ? n2[0] - n1[0] :
                        n2[1] - n1[1];
            }
        });
        // 保存结果
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
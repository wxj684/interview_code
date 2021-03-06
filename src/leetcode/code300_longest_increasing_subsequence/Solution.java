package leetcode.code300_longest_increasing_subsequence;

/**
 * @author Created By Frank
 * @date 2018-08-05 10:53
 * <p>
 * 最长上升子序列 (Longest Increasing Subsequence) - 领扣 (LeetCode)
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 */

/**
 * 最长上升子序列 (Longest Increasing Subsequence) - 领扣 (LeetCode)
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 */

import utils.PrintHelper;

import java.util.Arrays;

/**
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n==0) {
            return 0;
        }

        int res = 1;
        int[] memo = new int[n];

        Arrays.fill(memo, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    memo[i] = max(memo[i] , memo[j]+1);
            }
        }

        for(int i = 0;i<n;i++){
            res = max(memo[i],res);
        }
        PrintHelper.printArray(memo);
        return res;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().lengthOfLIS(arr));
    }
}

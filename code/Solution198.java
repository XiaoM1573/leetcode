package code;

// 打家劫舍
public class Solution198 {

    /*
     * 这是一个比较入门的动态规划问题
     * 求最值+选择
     *
     * 先简单分析一下：nums[] = {1,2,3,1}
     * 前1家，只能偷第一家
     * 前2家，取两家的最大值
     * 前3家，max{1+3,2}=4
     * 前4家，分为偷和不偷的情况
     * ...
     * 动态规划方程：
     * dp[i] = max{dp[i-2]+nums[i], dp[i-1]}
     * 边界：
     * dp[0] = nums[0]
     * dp[1] = max{num[0],num[1]}
     *
     * */
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        if (len == 0) return 0;
        if (len == 1) {
            dp[0] = nums[0];
        }
        if (len == 2) {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
        }

        if (len > 2) {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[len - 1];
    }
}

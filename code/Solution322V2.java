package code;

import java.util.Arrays;

public class Solution322V2 {

    public int coinChange(int[] coins, int amount) {
        // 完全背包最值问题
        // 外nums 内target 正序 target>=nums[i]
        // dp[i] = min(dp[i],dp[i-nums]+1) dp[i] amount为i下硬币数最少为多少
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++)
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        System.out.println(Arrays.toString(dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2, 5};
        int amount = 11;
        System.out.println(new Solution322V2().coinChange(coins, amount));
    }
}

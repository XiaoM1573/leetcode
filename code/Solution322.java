package code;

import java.util.*;

public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        // 转化成01背包问题
        List<Integer> newCoins = new ArrayList<>();
        List<Integer> sumCoins = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < coins.length; i++) {
            int num = (amount - 1) / coins[i] + 1;
            for (int j = 0; j < num; j++) {
                newCoins.add(coins[i]);
                sum = sum + coins[i];
                sumCoins.add(sum);
            }
        }
        System.out.println(newCoins.toString());
        System.out.println(sumCoins.toString());


        int[][] dp = new int[newCoins.size()][amount + 1];

        // 只有1枚硬币
        for (int i = 1; i < amount + 1; i++) {
            if (i == newCoins.get(0)) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = -1;
            }
        }
        // 针对amount=0的情况
        for (int i = 0; i < newCoins.size(); i++) {
            dp[i][0] = 0;
        }
        // 这里的i是下标

        for (int j = 1; j < amount + 1; j++)
            for (int i = 1; i < newCoins.size(); i++) {
                if (sumCoins.get(i) == j) {
                    dp[i][j] = i + 1;
                } else if (sumCoins.get(i) > j) {
                    if (j < newCoins.get(i)) {
                        dp[i][j] = -1;
                    } else {
                        if (dp[i - 1][j] == -1) {
                            dp[i][j] = dp[i - 1][j - newCoins.get(i)] + 1;
                        } else{
                            dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - newCoins.get(i)] + 1);
                        }
                    }
                } else {
                    dp[i][j] = -1;
                }
            }

        return dp[newCoins.size() - 1][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(new Solution322().coinChange(coins, amount));

    }
}

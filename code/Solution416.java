package code;

public class Solution416 {


    public boolean canPartition(int[] nums) {
        // 01背包存在性问题
        //  外套nums 内套target 倒序 dp[i] = dp[i] || dp[i-num] 是否存在和为i的子集
        // i>=num

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 若和为奇数 则直接返回false
        if (sum % 2 != 0) return false;

        // 定义dp dp[i]表示是否能划分出sum为i的子集
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true; // sum为0的子集肯定存在，无需移动任何元素
        for (int i = 0; i < nums.length; i++)
            for (int j = 1; j < sum / 2 + 1; j++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }

        return dp[sum / 2];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(new Solution416().canPartition(nums));
    }
}

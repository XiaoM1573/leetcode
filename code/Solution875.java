package code;

public class Solution875 {

    // 解法1：暴力，超出时间限制
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        // len >= 1
        int max = piles[0];
        for (int i = 1; i < len; i++) {
            if (piles[i] > max)
                max = piles[i];
        }
        // 不断收缩右边界，直至不满足;max 肯定是满足的
        boolean flag = true;
        int v = max;
        while (flag) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                count += (int) Math.ceil((double) piles[i] / v);
            }
            if (count <= h) {
                --v;
            } else {
                flag = false;
            }
        }
        return ++v;
    }

    // 解法2：二分法
    public int minEatingSpeed2(int[] piles, int h) {
        int len = piles.length;
        // len >= 1
        int max = piles[0];
        for (int i = 1; i < len; i++) {
            if (piles[i] > max)
                max = piles[i];
        }

        // 在解空间[1,max]内寻找最小解
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < len; i++) {
                count += (int) Math.ceil((double) piles[i] / mid);
            }
            // 若mid满足，则
            if (count <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}

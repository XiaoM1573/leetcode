package code;

import java.util.ArrayDeque;
import java.util.Deque;

// 接雨水
public class Solution42 {

    // 方法1，暴力法
    public int trap1(int[] height) {
        /*
         * 从左向右依次遍历每个点 i
         * 每遍历到一个点，分别向左和向右依次遍历，找到左边最大值left_max和右边最大值right_max
         * ans = ans + min(left_max, right_max) - height[i]
         *
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(1)
         * */
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            // 左右两端不计数
            if (i == 0 || i == height.length - 1) {
                continue;
            }
            int left_max = height[i];
            int right_max = height[i];

            // 向左边遍历寻找左边最大值
            for (int j = 0; j < i; j++) {
                if (height[j] > left_max) {
                    left_max = height[j];
                }
            }
            // 向右边遍历寻找右边最大值
            for (int k = i + 1; k < height.length; k++) {
                if (height[k] > right_max) {
                    right_max = height[k];
                }
            }

            ans = ans + Math.min(left_max, right_max) - height[i];
        }
        return ans;
    }

    // 方法2. 单调栈
    public int trap2(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0, i = 0;
        while (i < height.length) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int tmp = stack.removeLast();
                if (stack.isEmpty()) break;
                int distance = i - stack.peekLast() - 1;
                int _height = Math.min(height[stack.peekLast()], height[i]) - height[tmp];
                ans = ans + distance * _height;

            }
            stack.addLast(i++);
        }
        return ans;
    }

    public int trap3(int[] height) {
        int i = 0;
        return 0;
    }

    public int trap4(int[] height) {
        int i = 0;
        return 0;
    }


}

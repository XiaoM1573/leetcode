package code;

import java.util.Arrays;

public class SolutionKthPairDistance {
    public int solve(int[] nums, int k) {


        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[nums.length - 1];

        int left = 0;
        int right = max - min;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (count_not_greater(nums, mid) > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private long count_not_greater(int[] nums, int mid) {
        long count = 0;
        int j = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (j < n && nums[j] - nums[i] <= mid) {
                j++;
            }
            count += (j - i - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 2};
        System.out.println(new SolutionKthPairDistance().solve(nums, 0));
    }


}

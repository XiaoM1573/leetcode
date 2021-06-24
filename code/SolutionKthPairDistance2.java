package code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionKthPairDistance2 {
    Set<Integer> set = new HashSet<Integer>();

    public int solve(int[] nums, int k) {

        Arrays.sort(nums);
        for(int num: nums){
            set.add(num);
        }

        int min = nums[0];
        int max = nums[nums.length - 1];

        int left = 0;
        int right = max - min;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (count_not_greater(nums, mid) > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int count_not_greater(int[] nums, int mid) {
        int count = 0;
        for(int i = 0; i <= mid; i++){
            for(int num : nums){
                Integer temp = Integer.MAX_VALUE;


            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,2};
        System.out.println(new SolutionKthPairDistance2().solve(nums, 0));
    }


}

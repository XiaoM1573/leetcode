package code;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution327 {
    class Pair implements Comparable<Pair> {
        int i;
        int j;
        long value;

        public Pair(int i, int j, long value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.value == o.value){
                return 1;
            }else{
                return (int)(this.value - o.value);
            }

        }
    }


    public int countRangeSum(int[] nums, int lower, int upper) {
        // 遍历所有的距离，在遍历的同时，进行插入排序
        int distance = 0;
        int n = nums.length;
        int count = 0;
        while (distance < n) {
            Map<Pair, Object> tree = new TreeMap<>();

            for (int i = 0; i + distance < n; i++) {
                tree.put(new Pair(i, i + distance, sum(nums, i, i + distance)), null);
            }

            for (Map.Entry<Pair, Object> entry : tree.entrySet()) {
                long value = entry.getKey().value;
                if (value <= upper && value >= lower) {
                    System.out.println(entry.getKey().i+","+entry.getKey().j);
                    count++;
                }

            }
            distance++;
        }
        return count;
    }

    private long sum(int[] nums, int start, int end) {
        if (start > end) {
            System.out.println("error...");
            return Integer.MIN_VALUE;
        }
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483647,0,-2147483647,2147483647};
        System.out.println(new Solution327().countRangeSum(nums, -564, 3864));

    }
}

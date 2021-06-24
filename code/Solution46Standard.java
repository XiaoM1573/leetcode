package code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution46Standard {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> rs = new ArrayList<>();
        if (len == 0) return rs;

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] visited = new boolean[len];
        dfs(nums, len, 0, path, visited, rs);

        return rs;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] visited, List<List<Integer>> rs) {
        if (depth == len) {
            // path变量全程只用了一个变量，引用的是对象地址，需要添加对path的拷贝
            rs.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 如果当前数被使用了，那么则跳过
            if (visited[i]) continue;
            path.addLast(nums[i]);
            visited[i] = true;
            dfs(nums, len, depth + 1, path, visited, rs);
            visited[i] = false;
            path.removeLast();
        }
    }


}

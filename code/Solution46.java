package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution46 {
    public final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> searchSpace = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> rs = new ArrayList<>();
        dfs(0, searchSpace, rs, nums.length);
        return ans;
    }

    public void dfs(int index, List<Integer> searchSpace, List<Integer> rs, final int end) {
        if (index == end) {
            List<Integer> rsCopy = new ArrayList<>(rs);
            ans.add(rsCopy);
        } else {
            for (int i = 0; i < searchSpace.size(); i++) {
                int tmp = searchSpace.get(i);
                rs.add(searchSpace.get(i));
                searchSpace.remove(i);
                dfs(index + 1, searchSpace, rs, end);
                searchSpace.add(i, tmp);
                rs.remove(rs.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rs = new Solution46().permute(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(rs.toArray()));
    }
}

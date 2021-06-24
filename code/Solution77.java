package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> choices = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            choices.add(i);
        }
        List<Integer> rs = new ArrayList<>();
        dfs(0, choices, rs, k);
        System.out.println(ans);
        return ans;
    }

    public void dfs(int index, List<Integer> choices, List<Integer> rs, int k) {
        if (index == k) {
            ans.add(rs);
            return;
        }
        for (int i = 0; i < choices.size(); i++) {
            rs.add(choices.get(i));
            List<Integer> tmpChoices = new ArrayList<>(choices);
            dfs(index + 1, tmpChoices, rs, k);
            rs.remove(rs.size() - 1);
        }
    }


}

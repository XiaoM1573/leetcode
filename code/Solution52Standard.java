package code;

import java.util.HashSet;
import java.util.Set;

public class Solution52Standard {
    public int count = 0;

    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        dfs(n, 0, columns, diagonals1, diagonals2);
        return count;
    }

    private void dfs(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            ++count;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            int diagonal1 = row - i;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            dfs(n, row + 1, columns, diagonals1, diagonals2);
            diagonals2.remove(diagonal2);
            diagonals1.remove(diagonal1);
            columns.remove(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution52Standard().totalNQueens(6));
    }

}

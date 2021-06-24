package code;


import java.util.Arrays;

public class Solution52 {
    public int sum = 0;

    public int totalNQueens(int n) {
        if (n == 0) return 0;
        // 检查是否可选
        boolean[][] isAllowed = new boolean[n][n];

        dfs(n, 0, isAllowed);
        return sum;
    }

    private void dfs(int n, int depth, boolean[][] isAllowed) {
        if (depth == n) {
            ++sum;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isAllowed[depth][i]) {
//                System.out.println("++===========");
//                for (int l = 0; l < n; l++) {
//                    System.out.println(Arrays.toString(isAllowed[l]));
//                }

                boolean[][] newStatus = new boolean[n][n];
                for (int x = 0; x < n; x++)
                    for (int y = 0; y < n; y++) {
                        newStatus[x][y] = isAllowed[x][y];
                    }

                // 竖向
                for (int j = depth; j < n; j++) {
                    newStatus[j][i] = true;
                }
                // 右斜
                for (int x = depth, y = i; x < n && y < n; x++, y++) {
                    if (y != i) {
                        newStatus[x][y] = true;
                    }
                }
                // 左斜
                for (int x = depth, y = i; x < n && y >= 0; x++, y--) {
                    if (y != i) {
                        newStatus[x][y] = true;
                    }
                }
                dfs(n, depth + 1, newStatus);

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution52().totalNQueens(6));
    }


}

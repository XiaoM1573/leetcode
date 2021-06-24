package code;

public class Solution778 {

    private int N;
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWater(int[][] grid) {

        int n = grid.length;
        this.N = n;
        int min = Math.max(grid[0][0], grid[n - 1][n - 1]);
        int max = -1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        if (min == max) return min;
        int left = min;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (possible(grid, n, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean possible(int[][] grid, int n, int t) {
        // 在当前时间条件下，能够找到一条直接游到终点的路径
        // 用dfs寻找这样一条路径
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        return dfs2(grid, n, 0, 0, visited, t);
    }

    private boolean dfs(int[][] grid, int n, int i, int j, boolean[][] visited, int t) {
        if (i == n - 1 && j == n - 1) {
            System.out.println("i'm here");
            return true;
        }
        boolean flag = false;
        // 每次有4个方向的选择
        for (int k = 0; k < 4; k++) {


            if (k == 0) { // 向右游
                if (j + 1 < n) { // 不越界
                    j = j + 1;
                    if (!visited[i][j] && grid[i][j] <= t) { // 没有游过且可以游到
                        visited[i][j] = true;
                        flag = dfs(grid, n, i, j, visited, t);
                        visited[i][j] = false;
                    }
                    j = j - 1;
                }

            } else if (k == 1) { // 向下游

                if (i + 1 < n) { // 不越界
                    i = i + 1;
                    if (!visited[i][j] && grid[i][j] <= t) { // 没有游过且可以游到
                        visited[i][j] = true;
                        flag = dfs(grid, n, i, j, visited, t);
                        visited[i][j] = false;
                    }
                    i = i - 1;
                }

            } else if (k == 2) { // 向左游

                if (j - 1 >= 0) { // 不越界
                    j = j - 1;
                    if (!visited[i][j] && grid[i][j] <= t) { // 没有游过且可以游到
                        visited[i][j] = true;
                        flag = dfs(grid, n, i, j, visited, t);
                        visited[i][j] = false;
                    }
                    j = j + 1;
                }

            } else { // 向上游

                if (i - 1 >= 0) { // 不越界
                    i = i - 1;
                    if (!visited[i][j] && grid[i][j] <= t) { // 没有游过且可以游到
                        visited[i][j] = true;
                        flag = dfs(grid, n, i, j, visited, t);
                        visited[i][j] = false;
                    }
                    i = i + 1;
                }
            }
            if (flag) break;
        }
        return flag;
    }

    // 之前的dfs超出时间限制，需要牺牲一部分空间换取时间，也就是建立临时变量 取代撤销操作
    private boolean dfs2(int[][] grid, int n, int i, int j, boolean[][] visited, int t) {
        if (i == n - 1 && j == n - 1) {
            return true;
        }
        boolean flag = false;
        // 每次有4个方向的选择
        for (int[] direction : DIRECTIONS) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= t) {
                visited[newX][newY] = true;
                flag = dfs2(grid, n, i, j, visited, t);
                visited[newX][newY] = false;
            }
            if (flag) break;
        }
        return flag;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}

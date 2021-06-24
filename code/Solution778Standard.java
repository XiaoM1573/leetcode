package code;

public class Solution778Standard {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int swimInWater(int[][] grid) {

        int n = grid.length;
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
            if (possible(grid, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean possible(int[][] grid, int t) {
        // 在当前时间条件下，能够找到一条直接游到终点的路径
        // 用dfs寻找这样一条路径
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        return dfs(grid, n, 0, 0, visited, t);
    }


    // 之前的dfs超出时间限制，需要牺牲一部分空间换取时间，也就是建立临时变量 取代撤销操作
    private boolean dfs(int[][] grid, int n, int x, int y, boolean[][] visited, int t) {
        if (x == n - 1 && y == n - 1) {
            System.out.println("i'm here");
            return true;
        }
        // 每次有4个方向的选择
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (inArea(newX, newY, n) && !visited[newX][newY] && grid[newX][newY] <= t) {

                visited[newX][newY] = true;
                if (dfs(grid, n, newX, newY, visited, t)) {
                    return true;
                }
                // 下面的撤销操作是否可以省略
                //visited[newX][newY] = false;
            }
        }
        return false;
    }

    private boolean inArea(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        System.out.println(new Solution778Standard().possible(grid, 16));

    }

}

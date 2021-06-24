package code;

public class Solution5 {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // 边界条件
        int max = 1;
        String ans = "" + s.charAt(0);
        for (int i = 0; i < n; i++) {
            // 单字符
            dp[i][i] = true;
            // 2个字符
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                if (max == 1) {
                    max = 2;
                    ans = s.substring(i, i + 2);
                }
            }
        }
        // 遍历顺序有问题
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                if (j - i >= 2) {
//                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
//                    if (dp[i][j] && j - i + 1 > max) {
//                        max = j - i + 1;
//                        ans = s.substring(i, j + 1);
//                    }
//                }
//            }
//        }

        for (int j = 0; j < n; j++)
            for (int i = 0; i < n; i++) {
                if (j - i >= 2) {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                    if (dp[i][j] && j - i + 1 > max) {
                        max = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        System.out.println(new Solution5().longestPalindrome(s));
    }
}

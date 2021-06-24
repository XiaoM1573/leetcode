package code;

public class Solution10 {


    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();


        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n1; i++)
            for (int j = 1; j <= n2; j++) {
                if (p.charAt(j) >= 97 && p.charAt(j) <= 122) {
                    if (s.charAt(i) == p.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else if (p.charAt(j) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // p[j]为’*‘
                    if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        return dp[n1 - 1][n2 - 1];
    }


    public static void main(String[] args) {
        String s = "";
        System.out.println(s.charAt(0));
    }


}

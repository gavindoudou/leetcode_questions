public class Solution {
    public int longestCommonSubstring (char[] m, char[] n) {
        int max = Integer.MIN_VALUE;
        int mSize = m.length;
        int nSize = n.length;
        int[][] dp = new int[mSize + 1][nSize + 1];
        for (int i = 0; i <= mSize; i++) {
            for (int j = 0; j <= nSize; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (m[i - 1] == n[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        return max;
    }
}

class Solution {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int aLen = A.length;
        int bLen = B.length;
        if (aLen == 0 || bLen == 0) {
            return max;
        }
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 0; i <= aLen; i++) {
            for (int j = 0; j <= bLen; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}

//  0 1 2 3 4 5
//0 0 0 0 0 0 0 
//1 0 0 0 1 0 0
//2 0 0 1 0 0 0
//3 0 1 0 0 0 0
//4 0 0 2
//5 0     3
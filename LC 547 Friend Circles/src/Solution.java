public class Solution {
    public int findCircleNum(int[][] M) {
        if (M.length == 0) {
            return 0;
        }
        int size = M.length;
        int ans = 0;
        boolean [] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                DFS(i, M, visited);
                ans++;
            }
        }

        return ans;
    }
    private void DFS (int i, int[][]M, boolean[]visited) {
        for (int j = 0 ; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                DFS(j, M, visited);
            }
        }
        return;
    }
}

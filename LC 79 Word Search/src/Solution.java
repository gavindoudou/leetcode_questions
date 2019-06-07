class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i  = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search (char[][] board, String word, int x, int y, int index) {
        if (word.length() == index) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] != word.charAt(index) || visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        if (search(board,word,x - 1, y, index + 1) ||search(board,word,x + 1, y, index + 1) ||search(board,word, x, y - 1, index + 1) ||search(board,word, x, y + 1, index + 1)) {
            return true;
        }
        visited[x][y] = false;
        return false;

    }
}
class Solution {
    int[][] output;
    public void gameOfLife(int[][] board) {
        if (board == null || (board.length == 1 && board[0].length == 1)) {
            board[0][0] = 0;
            return;
        }
        output = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j  = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    Cell(i, j, 1, board);
                }
                else {
                    Cell(i, j, 0, board);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = output[i][j];
            }
        }

    }
    private void Cell (int x, int y, int live, int[][] board) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < output.length && j < output[0].length) {
                    if (board[i][j] == 1) {
                        count++;
                    }
                }
            }
        }
        if (live == 1) {
            count--;
            if (count == 2 || count == 3) {
                output[x][y] = 1;
            }
        }
        if (live == 0) {
            if (count == 3) {
                output[x][y] = 1;
            }
        }
    }
}
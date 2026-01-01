class Solution {
    List<List<String>> res = new ArrayList<>();
    boolean[] col, diag1, diag2; // col[c], diag1[r-c+n-1], diag2[r+c]

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diag1 = new boolean[2*n - 1];
        diag2 = new boolean[2*n - 1];
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0, n, board);
        return res;
    }

    private void backtrack(int r, int n, char[][] board) {
        if (r == n) {
            List<String> cur = new ArrayList<>();
            for (char[] row : board) cur.add(new String(row));
            res.add(cur);
            return;
        }
        for (int c = 0; c < n; c++) {
            int d1 = r - c + n - 1, d2 = r + c;
            if (col[c] || diag1[d1] || diag2[d2]) continue;
            col[c] = diag1[d1] = diag2[d2] = true;
            board[r][c] = 'Q';
            backtrack(r + 1, n, board);
            board[r][c] = '.';
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}

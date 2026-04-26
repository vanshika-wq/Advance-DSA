class Solution {
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean[][] visited;
    private char[][] grid;
    private int rows, cols;

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c]) {
                    if (dfs(r, c, -1, -1)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int pr, int pc) {
        visited[r][c] = true;

        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];

            
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
            if (grid[nr][nc] != grid[r][c]) continue;

            // Skip the parent cell we came from
            if (nr == pr && nc == pc) continue;

            // Already visited and not parent → cycle found!
            if (visited[nr][nc]) return true;

            if (dfs(nr, nc, r, c)) return true;
        }
        return false;
    }
}
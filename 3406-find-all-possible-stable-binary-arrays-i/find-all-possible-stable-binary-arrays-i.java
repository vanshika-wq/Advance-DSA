class Solution {
    static final int MOD = 1000000007;
    int[][][][] memo;
    int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        memo = new int[zero + 1][one + 1][2][limit + 1];
        for (int i = 0; i <= zero; i++)
            for (int j = 0; j <= one; j++)
                for (int k = 0; k < 2; k++)
                    java.util.Arrays.fill(memo[i][j][k], -1);

        long ans = 0;
        if (zero > 0) ans += dfs(zero - 1, one, 0, 1);
        if (one > 0) ans += dfs(zero, one - 1, 1, 1);
        return (int)(ans % MOD);
    }

    int dfs(int z, int o, int last, int cnt) {
        if (z == 0 && o == 0) return 1;
        if (memo[z][o][last][cnt] != -1) return memo[z][o][last][cnt];

        long res = 0;

        if (last == 0) {
            if (z > 0 && cnt < limit) res += dfs(z - 1, o, 0, cnt + 1);
            if (o > 0) res += dfs(z, o - 1, 1, 1);
        } else {
            if (o > 0 && cnt < limit) res += dfs(z, o - 1, 1, cnt + 1);
            if (z > 0) res += dfs(z - 1, o, 0, 1);
        }

        return memo[z][o][last][cnt] = (int)(res % MOD);
    }
}
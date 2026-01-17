class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxArea = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            int ax = bottomLeft[i][0];
            int ay = bottomLeft[i][1];
            int bx = topRight[i][0];
            int by = topRight[i][1];
            for (int j = i + 1; j < n; j++) {
                int cx = bottomLeft[j][0];
                int cy = bottomLeft[j][1];
                int dx = topRight[j][0];
                int dy = topRight[j][1];
                // Intersection coordinates
                int left = Math.max(ax, cx);
                int bottom = Math.max(ay, cy);
                int right = Math.min(bx, dx);
                int top = Math.min(by, dy);
                if (left < right && bottom < top) {
                    int side = Math.min(right - left, top - bottom);
                    maxArea = Math.max(maxArea, (long) side * side);
                }
            }
        }
        return maxArea;
    }
}

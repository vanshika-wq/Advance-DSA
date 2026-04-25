import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] a = new long[n];
        
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) a[i] = x;
            else if (x == side) a[i] = side + y;
            else if (y == side) a[i] = 3L * side - x;
            else a[i] = 4L * side - y;
        }
        
        Arrays.sort(a);
        long per = 4L * side;
        long[] b = new long[2 * n];
        
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
            b[i + n] = a[i] + per;
        }
        
        long low = 0, high = 2L * side, ans = 0;
        
        while (low <= high) {
            long mid = (low + high) >> 1;
            if (check(b, n, k, mid, per)) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        
        return (int) ans;
    }
    
    boolean check(long[] b, int n, int k, long d, long per) {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            long last = b[i];
            int idx = i;
            
            for (int t = 1; t < k; t++) {
                idx = lowerBound(b, idx + 1, i + n, last + d);
                if (idx == -1) break;
                last = b[idx];
                cnt++;
            }
            
            if (cnt == k && per - (last - b[i]) >= d) return true;
        }
        return false;
    }
    
    int lowerBound(long[] arr, int l, int r, long target) {
        int res = -1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (arr[m] >= target) {
                res = m;
                r = m - 1;
            } else l = m + 1;
        }
        return res;
    }
}
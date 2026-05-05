class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;  
            }
        }
        
        
        for (int i = m + n - 1; i > 0; i--) {
            if (res[i] >= 10) {
                res[i-1] += res[i] / 10;
                res[i] %= 10;
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < m + n - 1 && res[start] == 0) start++;
        for (int i = start; i < m + n; i++) {
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int val1 = getValue(s.charAt(i));
            if (i + 1 < s.length()) {
                int val2 = getValue(s.charAt(i + 1));
                if (val1 >= val2) {
                    ans += val1;
                } else {
                    ans += val2 - val1;
                    i++;  // Skip next char
                }
            } else {
                ans += val1;
            }
        }
        return ans;
    }
    
    private int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}

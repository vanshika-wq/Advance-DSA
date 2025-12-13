import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Integer> idx = new ArrayList<>();
        Set<String> ok = Set.of("electronics", "grocery", "pharmacy", "restaurant");

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && ok.contains(businessLine[i]) && valid(code[i])) {
                idx.add(i);
            }
        }

        idx.sort((a, b) -> {
            int x = businessLine[a].compareTo(businessLine[b]);
            if (x != 0) return x;
            return code[a].compareTo(code[b]);
        });

        List<String> ans = new ArrayList<>();
        for (int i : idx) ans.add(code[i]);
        return ans;
    }

    private boolean valid(String s) {
        if (s.isEmpty()) return false;
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') return false;
        }
        return true;
    }
}

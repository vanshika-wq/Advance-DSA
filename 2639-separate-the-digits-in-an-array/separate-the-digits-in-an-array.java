class Solution {
    public int[] separateDigits(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        
        for (int n : nums) {
            
            String s = Integer.toString(n);
            
            
            for (int i = 0; i < s.length(); i++) {
                
                list.add(s.charAt(i) - '0');
            }
        }
        
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}
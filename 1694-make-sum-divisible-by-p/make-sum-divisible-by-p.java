public class Solution {
    public int minSubarray(int[] nums, int p) {
        // Step 1: Check if total sum already divisible by p
        // copied 
        long total = 0;
        for (int num : nums) total += num;
        int target = (int)(total % p);
        if (target == 0) return 0;
        
        // Step 2: Map to store prefixMod -> earliest index
        java.util.HashMap<Integer, Integer> seen = new java.util.HashMap<>();
        seen.put(0, -1);  // Empty prefix has mod 0 at index -1
        
        int prefixMod = 0;
        int minLen = nums.length;  // Track minimum subarray length
        
        // Step 3: Traverse array
        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % p;
            
            // Step 4: Check if we can form target remainder
            int needed = (prefixMod - target + p) % p;
            if (seen.containsKey(needed)) {
                minLen = Math.min(minLen, i - seen.get(needed));
            }
            
            // Step 5: Store current prefixMod (keep earliest index)
            seen.put(prefixMod, i);
        }
        
        return minLen == nums.length ? -1 : minLen;
    }
}

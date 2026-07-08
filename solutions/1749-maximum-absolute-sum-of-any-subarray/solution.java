class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minPrefix = 0;
        int maxPrefix = 0;
        int currentPrefix = 0;
        
        for (int num : nums) {
            currentPrefix += num;
            minPrefix = Math.min(minPrefix, currentPrefix);
            maxPrefix = Math.max(maxPrefix, currentPrefix);
        }
        
        return maxPrefix - minPrefix;
    }
}

